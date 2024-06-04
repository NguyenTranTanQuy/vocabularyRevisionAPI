package com.group32.vocabularyRevisionAPI.DTO.Vocabulary;

import com.group32.vocabularyRevisionAPI.DTO.VocabularyLists.VocabularyListsDTO;
import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;

public class VocabularyConverter {
    public static VocabularyDTO toDTO(Vocabulary vocabulary) {
        if (vocabulary == null) return null;

        VocabularyDTO vocabularyDTO = new VocabularyDTO();
        vocabularyDTO.setVocabularyID(vocabulary.getVocabularyID());
        vocabularyDTO.setWord(vocabulary.getWord());
        vocabularyDTO.setDefinition(vocabulary.getDefinition());
        return vocabularyDTO;
    }

    public static Vocabulary toEntity(VocabularyDTO vocabularyDTO) {
        if (vocabularyDTO == null) return null;

        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setVocabularyID(vocabularyDTO.getVocabularyID());
        vocabulary.setWord(vocabularyDTO.getWord());
        vocabulary.setDefinition(vocabularyDTO.getDefinition());
        return vocabulary;
    }
}
