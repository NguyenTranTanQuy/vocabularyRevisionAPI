package com.group32.vocabularyRevisionAPI.DTO.VocabularyLists;

import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;

public class VocabularyListsConverter {
    public static VocabularyListsDTO toDTO(VocabularyLists vocabularyLists) {
        if (vocabularyLists == null) return null;

        VocabularyListsDTO vocabularyListsDTO = new VocabularyListsDTO();
        vocabularyListsDTO.setVocabularyListID(vocabularyLists.getVocabularyListID());
        vocabularyListsDTO.setList_name(vocabularyLists.getList_name());
        vocabularyListsDTO.setDescription(vocabularyLists.getDescription());
        return vocabularyListsDTO;
    }

    public static VocabularyLists toEntity(VocabularyListsDTO vocabularyListsDTO) {
        if (vocabularyListsDTO == null) return null;

        VocabularyLists vocabularyLists = new VocabularyLists();
        vocabularyLists.setVocabularyListID(vocabularyListsDTO.getVocabularyListID());
        vocabularyLists.setList_name(vocabularyListsDTO.getList_name());
        vocabularyLists.setDescription(vocabularyListsDTO.getDescription());
        return vocabularyLists;
    }
}
