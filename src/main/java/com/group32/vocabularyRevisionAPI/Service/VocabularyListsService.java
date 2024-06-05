package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;
import com.group32.vocabularyRevisionAPI.Repository.FolderRepository;
import com.group32.vocabularyRevisionAPI.Repository.VocabularyListsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VocabularyListsService {
    private final VocabularyListsRepository vocabularyListsRepository;
    private final FolderRepository folderRepository;
    private final VocabularyService vocabularyService;

    public VocabularyListsService(VocabularyListsRepository vocabularyListsRepository, FolderRepository folderRepository, VocabularyService vocabularyService) {
        this.vocabularyListsRepository = vocabularyListsRepository;
        this.folderRepository = folderRepository;
        this.vocabularyService = vocabularyService;
    }

    public List<VocabularyLists> getAllVocabularyListsByFolderID(Long folderID) {
        Folder folder = folderRepository.findById(folderID).orElse(null);
        if(folder == null) return null;

        return vocabularyListsRepository.findAllVocabularyListsByFolderID(folderID);
    }

    public VocabularyLists addVocabularyList(Long folderID, String list_name, String description, List<Vocabulary> vocabularyList) {
        VocabularyLists vocabularyLists = new VocabularyLists();
        vocabularyLists.setList_name(list_name);
        vocabularyLists.setDescription(description);
        Folder folder = folderRepository.findById(folderID).orElse(null);
        if(folder == null) return null;
        vocabularyLists.setFolder(folder);
        vocabularyListsRepository.save(vocabularyLists);
        Long vocabularyListID = folder.getVocabularyLists().get(folder.getVocabularyLists().size() - 1).getVocabularyListID();

        for (Vocabulary vocabulary : vocabularyList) {
            vocabularyService.addVocabulary(vocabularyListID, vocabulary);
        }
        return vocabularyLists;
    }

    public VocabularyLists updateVocabularyList(VocabularyLists vocabularyLists, List<Vocabulary> vocabularyList) {
        return null;
    }
}
