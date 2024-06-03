package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Repository.LevelRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LevelService {
    private final LevelRepository levelRepository;
    private final UserRepository userRepository;

    public LevelService(LevelRepository levelRepository, UserRepository userRepository) {
        this.levelRepository = levelRepository;
        this.userRepository = userRepository;
    }

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    public Level addLevel(String levelName, int experience) {
        Level level = new Level();
        level.setLevel_name(levelName);
        level.setExperience(experience);

        levelRepository.save(level);
        return level;
    }

    public Level updateLevel(Level level) {
        Optional<Level> levelFindByID =  levelRepository.findById(level.getLevelID());
        if (levelFindByID.isEmpty()) return null;

        levelRepository.save(level);
        return level;
    }
}
