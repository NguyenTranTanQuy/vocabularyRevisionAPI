package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.DetailedLevel;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevelKey;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Repository.DetailedLevelRepository;
import com.group32.vocabularyRevisionAPI.Repository.LevelRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Component
public class UserService {
    private final UserRepository userRepository;
    private final LevelRepository levelRepository;
    private final DetailedLevelRepository detailedLevelRepository;
    private final DetailedLevelService detailedLevelService;

    public UserService(UserRepository userRepository, LevelRepository levelRepository, DetailedLevelRepository detailedLevelRepository, DetailedLevelService detailedLevelService) {
        this.userRepository = userRepository;
        this.levelRepository = levelRepository;
        this.detailedLevelRepository = detailedLevelRepository;
        this.detailedLevelService = detailedLevelService;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<User> userByUsername =  userRepository.findByUsername(username);
        return userByUsername.orElse(null);
    }

    @Transactional
    public User addUser(User user) {
        Optional<User> userByUsername =  userRepository.findByUsername(user.getUsername());
        if (userByUsername.isPresent()) return null;

        user.setCreated_at(new Date());
        user.setExperience(0L);
        userRepository.save(user);

        DetailedLevel detailedLevel = new DetailedLevel();

        Level level = levelRepository.findById(1L).orElse(null);

        DetailedLevelKey detailedLevelKey = new DetailedLevelKey(user.getUsername(), 1L);
        detailedLevelKey.setUsername(user.getUsername());
        detailedLevelKey.setLevelID(1L);

        detailedLevel.setID(detailedLevelKey);
        detailedLevel.setUser(user);
        detailedLevel.setLevel(level);
        detailedLevel.setCreated_at(new Date());
        detailedLevelRepository.save(detailedLevel);
        return user;
    }

    @Transactional
    public User updateUser(User user, String username) {
        User user_ =  userRepository.findByUsername(username).orElse(null);
        if (user_ == null) return null;
        user_.setFirst_name(user.getFirst_name());
        user_.setLast_name(user.getLast_name());
        user_.setEmail(user.getEmail());
        user_.setDob(user.getDob());
        userRepository.save(user_);
        return user_;
    }

    @Transactional
    public User updateExperience(String username, Long experience) {
        User user =  userRepository.findByUsername(username).orElse(null);
        if (user == null) return null;
        user.setExperience(user.getExperience() + experience);
        Level currentLevel = detailedLevelService.getCurrentLevel(username);
        Level nextLevel = levelRepository.findById(currentLevel.getLevelID() + 1L).orElse(null);

        if(nextLevel != null && nextLevel.getExperience() <= user.getExperience()) {
            detailedLevelService.levelUp(username);
        }
        userRepository.save(user);
        return user;
    }

    public boolean signIn(String username, String password) {
        List<User> userList = userRepository.findAll();

        for (User user:userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    @Transactional
    public boolean resetPassword(String username, String password, String email) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) return false;
        if (!user.get().getEmail().equals(email)) return false;
        userRepository.resetPassword(username, password);
        return true;
    }
}
