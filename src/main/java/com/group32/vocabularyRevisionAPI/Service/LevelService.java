package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Repository.LevelRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class LevelService {
    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @Transactional
    public Level addLevel(String levelName, int experience) {
        Level level = new Level();
        level.setLevel_name(levelName);
        level.setExperience(experience);

        levelRepository.save(level);
        return level;
    }

    @Transactional
    public Level updateLevel(Level level) {
        Level level_ =  levelRepository.findById(level.getLevelID()).orElse(null);
        if (level_ == null) return null;

        level_.setLevel_name(level.getLevel_name());
        level_.setExperience(level.getExperience());
        levelRepository.save(level_);
        return level;
    }
}
