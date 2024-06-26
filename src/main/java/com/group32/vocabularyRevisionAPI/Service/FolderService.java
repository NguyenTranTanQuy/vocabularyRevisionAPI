package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Repository.FolderRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class FolderService {
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    public FolderService(FolderRepository folderRepository, UserRepository userRepository) {
        this.folderRepository = folderRepository;
        this.userRepository = userRepository;
    }

    public Folder getFolder(Long folderID) {
        return folderRepository.findById(folderID).orElse(null);
    }

    public List<Folder> getAllFolderByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null) return null;
        return folderRepository.findAllFolderByUsername(username);
    }

    @Transactional
    public Folder addFolder(String folderName, String description, String username) {
        Folder folder = new Folder();
        folder.setFolder_name(folderName);
        folder.setDescription(description);

        User user = userRepository.findByUsername(username).orElse(null);
        folder.setUser(user);
        folderRepository.save(folder);
        return folder;
    }

    @Transactional
    public Folder updateFolder(Folder folder) {
        Folder folder_ =  folderRepository.findById(folder.getFolderID()).orElse(null);
        if (folder_ == null) return null;

        folder_.setFolder_name(folder.getFolder_name());
        folder_.setDescription(folder.getDescription());
        folderRepository.save(folder_);
        return folder_;
    }

    @Transactional
    public Folder deleteFolder(Long folderID) {
        Folder folder = folderRepository.findById(folderID).orElse(null);
        if (folder == null) return null;
        folderRepository.delete(folder);
        return folder;
    }
}
