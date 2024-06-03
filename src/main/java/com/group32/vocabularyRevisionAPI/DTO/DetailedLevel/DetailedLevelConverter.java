package com.group32.vocabularyRevisionAPI.DTO.DetailedLevel;

import com.group32.vocabularyRevisionAPI.DTO.Level.LevelDTO;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevel;
import com.group32.vocabularyRevisionAPI.Model.Level;

public class DetailedLevelConverter {
//    public static DetailedLevelDTO toDTO(DetailedLevel detailedLevel) {
//        if (detailedLevel == null) return null;
//
//        DetailedLevelDTO detailedLevelDTO = new DetailedLevelDTO();
//        detailedLevelDTO(level.getLevelID());
//        levelDTO.setLevel_name(level.getLevel_name());
//        levelDTO.setExperience(level.getExperience());
//        return levelDTO;
//    }

    public static Level toEntity(LevelDTO levelDTO) {
        if (levelDTO == null) return null;

        Level level = new Level();
        level.setLevelID(levelDTO.getLevelID());
        level.setLevel_name(levelDTO.getLevel_name());
        level.setExperience(levelDTO.getExperience());
        return level;
    }
}
