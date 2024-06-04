package com.group32.vocabularyRevisionAPI.Repository;

import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabularyListsRepository extends JpaRepository<VocabularyLists, Long> {
    @Query("SELECT vl FROM VocabularyLists vl WHERE vl.folder.folderID = :folder_id")
    List<VocabularyLists> findAllVocabularyListsByFolderID(@Param("folder_id") Long folderID);
}

