package com.group32.vocabularyRevisionAPI.DTO.Level;

import com.group32.vocabularyRevisionAPI.Model.Level;

public class LevelConverter {
    public static LevelDTO toDTO(Level level) {
        if (level == null) return null;

        LevelDTO levelDTO = new LevelDTO();
        levelDTO.setLevelID(level.getLevelID());
        levelDTO.setLevel_name(level.getLevel_name());
        levelDTO.setExperience(level.getExperience());
        return levelDTO;
    }

    public static Level toEntity(LevelDTO levelDTO) {
        if (levelDTO == null) return null;

        Level level = new Level();
        level.setLevelID(levelDTO.getLevelID());
        level.setLevel_name(levelDTO.getLevel_name());
        level.setExperience(levelDTO.getExperience());
        return level;
    }
}
