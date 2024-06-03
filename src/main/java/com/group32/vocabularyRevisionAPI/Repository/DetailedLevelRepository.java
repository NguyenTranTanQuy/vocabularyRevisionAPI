package com.group32.vocabularyRevisionAPI.Repository;

import com.group32.vocabularyRevisionAPI.Model.DetailedLevel;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevelKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface DetailedLevelRepository extends JpaRepository<DetailedLevel, DetailedLevelKey> {
    @Procedure(name="getCurrentLevelByUsername")
    Long getCurrentLevelByUsername(String username);
}
