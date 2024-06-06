package com.group32.vocabularyRevisionAPI.Repository;

import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Model.UserProgress;
import com.group32.vocabularyRevisionAPI.Model.UserProgressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, UserProgressKey> {
    @Query("SELECT up FROM UserProgress up WHERE up.user.username = :username")
    List<UserProgress> findAllUserProgressByUsername(String username);
}
