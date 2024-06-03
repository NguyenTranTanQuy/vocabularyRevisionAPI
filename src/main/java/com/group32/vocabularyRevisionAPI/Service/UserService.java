package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Component
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<User> userByUsername =  userRepository.findByUsername(username);
        if (userByUsername.isEmpty()) return null;
        return userRepository.findByUsername(username).get();
    }

    public User addUser(User user) {
        Optional<User> userByUsername =  userRepository.findByUsername(user.getUsername());
        if (userByUsername.isPresent()) return null;

        user.setCreated_at(new Date());
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        Optional<User> userByUsername =  userRepository.findByUsername(user.getUsername());
        if (userByUsername.isEmpty()) return null;

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

    public boolean resetPassword(String username, String password, String email) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) return false;
        if (!user.get().getEmail().equals(email)) return false;
        userRepository.resetPassword(username, password);
        return true;
    }
}
