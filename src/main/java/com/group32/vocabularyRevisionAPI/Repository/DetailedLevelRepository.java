package com.group32.vocabularyRevisionAPI.Repository;

import com.group32.vocabularyRevisionAPI.Model.DetailedLevel;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevelKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailedLevelRepository extends JpaRepository<DetailedLevel, DetailedLevelKey> {
    @Query("SELECT MAX(dl.ID.levelID) FROM DetailedLevel dl WHERE dl.ID.username = :username")
    Long getCurrentLevelByUsername(@Param("username") String username);
}

