package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Repository.UserProgressRepository;
import org.springframework.stereotype.Component;

@Component
public class UserProgressService {
    private final UserProgressRepository userProgressRepository;

    public UserProgressService(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }
}
