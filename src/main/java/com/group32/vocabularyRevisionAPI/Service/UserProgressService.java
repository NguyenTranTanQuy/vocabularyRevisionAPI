package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Controller.UserProgressController;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Model.UserProgress;
import com.group32.vocabularyRevisionAPI.Model.UserProgressKey;
import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Repository.UserProgressRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import com.group32.vocabularyRevisionAPI.Repository.VocabularyRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class UserProgressService {
    private final UserProgressRepository userProgressRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    private final VocabularyRepository vocabularyRepository;


    public UserProgressService(UserProgressRepository userProgressRepository, UserRepository userRepository, @Lazy UserService userService, VocabularyRepository vocabularyRepository) {
        this.userProgressRepository = userProgressRepository;
        this.userRepository = userRepository;
        this.userService = userService;
        this.vocabularyRepository = vocabularyRepository;
    }

    public List<UserProgress> getAllUserProgressByUsername(String username) {
        return userProgressRepository.findAllUserProgressByUsername(username);
    }

    @Transactional
    public UserProgress addUserProgress(String username, Long vocabularyID, boolean isTrue) {
        User user = userRepository.findByUsername(username).orElse(null);
        Vocabulary vocabulary = vocabularyRepository.findById(vocabularyID).orElse(null);
        if (user == null || vocabulary == null) return null;

        UserProgressKey userProgressKey = new UserProgressKey(username, vocabularyID);
        UserProgress userProgress = userProgressRepository.findById(userProgressKey).orElse(null);

        if (userProgress == null) {
            userProgress = new UserProgress();
            userProgress.setID(userProgressKey);
            userProgress.setUser(user);
            userProgress.setVocabulary(vocabulary);
            userProgress.setCorrect_attempts(0);
            userProgress.setIncorrect_attempts(0);
        }

        if (isTrue) {
            userProgress.setCorrect_attempts(userProgress.getCorrect_attempts() + 1);
            userService.updateExperience(username, 1L);
        } else {
            userProgress.setIncorrect_attempts(userProgress.getIncorrect_attempts() + 1);
        }

        userProgress.setLast_attempt_date(new Date());

        userProgressRepository.save(userProgress);
        return userProgress;
    }
}
