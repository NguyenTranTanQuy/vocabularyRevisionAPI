package com.group32.vocabularyRevisionAPI.Repository;

import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    @Query("SELECT v FROM Vocabulary v WHERE v.vocabularyLists.vocabularyListID = :vocabularyList_id")
    List<Vocabulary> findAllVocabularyByVocabularyListID(@Param("vocabularyList_id") Long vocabularyListID);

    @Procedure(name="findAllUnlearnedVocabularyByUsername")
    List<Vocabulary> findAllUnlearnedVocabularyByUsername(String username);

}
