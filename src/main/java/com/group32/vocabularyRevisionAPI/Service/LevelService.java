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
        Optional<Level> levelFindByID =  levelRepository.findById(level.getLevelID());
        if (levelFindByID.isEmpty()) return null;

        levelRepository.save(level);
        return level;
    }
}
