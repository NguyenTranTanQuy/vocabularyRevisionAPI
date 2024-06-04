package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.DetailedLevel;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevelKey;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Repository.DetailedLevelRepository;
import com.group32.vocabularyRevisionAPI.Repository.LevelRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class DetailedLevelService {
    private final DetailedLevelRepository detailedLevelRepository;
    private final LevelRepository levelRepository;
    private final UserRepository userRepository;

    public DetailedLevelService(DetailedLevelRepository detailedLevelRepository, LevelRepository levelRepository, UserRepository userRepository) {
        this.detailedLevelRepository = detailedLevelRepository;
        this.levelRepository = levelRepository;
        this.userRepository = userRepository;
    }

    public Level getCurrentLevel(String username) {
        Long levelID =  detailedLevelRepository.getCurrentLevelByUsername(username);
        Optional<Level> level = levelRepository.findById(levelID);
        return level.orElse(null);
    }

    public DetailedLevel addLevelForUser(String username, Long levelID) {
        Optional<User> user = userRepository.findByUsername(username);
        Optional<Level> level = levelRepository.findById(levelID);
        if(user.isEmpty() || level.isEmpty()) return null;

        DetailedLevelKey detailedLevelKey = new DetailedLevelKey();
        detailedLevelKey.setUsername(username);
        detailedLevelKey.setLevelID(levelID);

        DetailedLevel detailedLevel = new DetailedLevel();
        detailedLevel.setID(detailedLevelKey);
        detailedLevel.setUser(user.get());
        detailedLevel.setLevel(level.get());
        detailedLevel.setCreated_at(new Date());

        detailedLevelRepository.save(detailedLevel);
        return detailedLevel;
    }

    public DetailedLevel levelUp(String username) {
        Level level = getCurrentLevel(username);
        if(level == null) return null;

        Long levelID = level.getLevelID();
        return addLevelForUser(username, levelID + 1);
    }
}
