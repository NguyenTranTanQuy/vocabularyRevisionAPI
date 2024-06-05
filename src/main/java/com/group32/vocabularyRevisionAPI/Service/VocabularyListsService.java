package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;
import com.group32.vocabularyRevisionAPI.Repository.FolderRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import com.group32.vocabularyRevisionAPI.Repository.VocabularyListsRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VocabularyListsService {
    private final VocabularyListsRepository vocabularyListsRepository;
    private final FolderRepository folderRepository;
    private final VocabularyService vocabularyService;
    private final UserRepository userRepository;

    public VocabularyListsService(VocabularyListsRepository vocabularyListsRepository, FolderRepository folderRepository, VocabularyService vocabularyService, UserRepository userRepository) {
        this.vocabularyListsRepository = vocabularyListsRepository;
        this.folderRepository = folderRepository;
        this.vocabularyService = vocabularyService;
        this.userRepository = userRepository;
    }

    public VocabularyLists getVocabularyList(Long vocabularyListID) {
        return vocabularyListsRepository.findById(vocabularyListID).orElse(null);
    }

    public List<VocabularyLists> getAllVocabularyListsByFolderID(Long folderID) {
        Folder folder = folderRepository.findById(folderID).orElse(null);
        if(folder == null) return null;

        return vocabularyListsRepository.findAllVocabularyListsByFolderID(folderID);
    }

    public List<VocabularyLists> getAllVocabularyListsByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) return null;
        List<Folder> folderList = folderRepository.findAllFolderByUsername(username);
        List<VocabularyLists> vocabularyLists = new ArrayList<>();
        for (Folder folder:folderList) {
            vocabularyLists.addAll(vocabularyListsRepository.findAllVocabularyListsByFolderID(folder.getFolderID()));
        }
        return vocabularyLists;
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
