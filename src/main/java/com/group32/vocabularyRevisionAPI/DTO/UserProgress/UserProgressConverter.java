package com.group32.vocabularyRevisionAPI.DTO.UserProgress;

import com.group32.vocabularyRevisionAPI.Model.UserProgress;
import com.group32.vocabularyRevisionAPI.Model.UserProgressKey;

public class UserProgressConverter {
    public static UserProgressDTO toDTO(UserProgress userProgress) {
        if (userProgress == null) return null;

        UserProgressDTO userProgressDTO = new UserProgressDTO();
        userProgressDTO.setUsername(userProgress.getID().getUsername());
        userProgressDTO.setVocabularyID(userProgress.getID().getVocabularyID());
        userProgressDTO.setCorrect_attempts(userProgress.getCorrect_attempts());
        userProgressDTO.setIncorrect_attempts(userProgress.getIncorrect_attempts());
        userProgressDTO.setLast_attempt_date(userProgress.getLast_attempt_date());
        return userProgressDTO;
    }

    public static UserProgress toEntity(UserProgressDTO userProgressDTO) {
        if (userProgressDTO == null) return null;

        UserProgress userProgress = new UserProgress();
        UserProgressKey userProgressKey = new UserProgressKey();
        userProgressKey.setUsername(userProgressDTO.getUsername());
        userProgressKey.setVocabularyID(userProgressDTO.getVocabularyID());
        userProgress.setID(userProgressKey);
        userProgress.setCorrect_attempts(userProgressDTO.getCorrect_attempts());
        userProgress.setIncorrect_attempts(userProgressDTO.getIncorrect_attempts());
        userProgress.setLast_attempt_date(userProgressDTO.getLast_attempt_date());
        return userProgress;
    }
}
