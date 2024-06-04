package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;
import com.group32.vocabularyRevisionAPI.Repository.VocabularyListsRepository;
import com.group32.vocabularyRevisionAPI.Repository.VocabularyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VocabularyService {
    private final VocabularyRepository vocabularyRepository;
    private final VocabularyListsRepository vocabularyListsRepository;

    public VocabularyService(VocabularyRepository vocabularyRepository, VocabularyListsRepository vocabularyListsRepository) {
        this.vocabularyRepository = vocabularyRepository;
        this.vocabularyListsRepository = vocabularyListsRepository;
    }

    public List<Vocabulary> getAllVocabularyByVocabularyListID(Long vocabularyListID) {
        VocabularyLists vocabularyLists = vocabularyListsRepository.findById(vocabularyListID).orElse(null);
        if(vocabularyLists == null) return null;

        return vocabularyRepository.findAllVocabularyByVocabularyListID(vocabularyListID);
    }

    public Vocabulary addVocabulary(Long vocabularyListID, Vocabulary vocabulary) {
        VocabularyLists vocabularyLists = vocabularyListsRepository.findById(vocabularyListID).orElse(null);
        if(vocabularyLists == null) return null;

        vocabulary.setVocabularyLists(vocabularyLists);
        vocabularyRepository.save(vocabulary);
        return vocabulary;
    }
}
