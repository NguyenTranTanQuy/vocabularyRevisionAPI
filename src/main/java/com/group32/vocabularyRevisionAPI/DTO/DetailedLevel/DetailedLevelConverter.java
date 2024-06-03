package com.group32.vocabularyRevisionAPI.DTO.DetailedLevel;

import com.group32.vocabularyRevisionAPI.DTO.Level.LevelDTO;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevel;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevelKey;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Repository.LevelRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;

import java.util.Optional;

public class DetailedLevelConverter {
    public static DetailedLevelDTO toDTO(DetailedLevel detailedLevel) {
        if (detailedLevel == null) return null;

        DetailedLevelDTO detailedLevelDTO = new DetailedLevelDTO();
        detailedLevelDTO.setLevelID(detailedLevel.getID().getLevelID());
        detailedLevelDTO.setUsername(detailedLevel.getID().getUsername());
        detailedLevelDTO.setCreated_at(detailedLevel.getCreated_at());
        return detailedLevelDTO;
    }

    public static DetailedLevel toEntity(DetailedLevelDTO detailedLevelDTO) {
        if (detailedLevelDTO == null) return null;

        DetailedLevel detailedLevel = new DetailedLevel();
        DetailedLevelKey detailedLevelKey = new DetailedLevelKey();
        detailedLevelKey.setUsername(detailedLevelDTO.getUsername());
        detailedLevelKey.setLevelID(detailedLevelDTO.getLevelID());
        detailedLevel.setID(detailedLevelKey);

        detailedLevel.setCreated_at(detailedLevelDTO.getCreated_at());
        return detailedLevel;
    }
}
