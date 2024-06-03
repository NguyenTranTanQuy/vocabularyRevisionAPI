package com.group32.vocabularyRevisionAPI.Service;

import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Repository.FolderRepository;
import com.group32.vocabularyRevisionAPI.Repository.UserRepository;
import org.springframework.stereotype.Component;

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

    public List<Folder> getAllFolderByUsername(String username) {
        return folderRepository.findAllFolderByUsername(username);
    }

    public Folder addFolder(String folderName, String description, String username) {
        Folder folder = new Folder();
        folder.setFolder_name(folderName);
        folder.setDescription(description);

        User user = userRepository.findByUsername(username).orElse(null);
        folder.setUser(user);
        folderRepository.save(folder);
        return folder;
    }

    public Folder updateFolder(Folder folder, String username) {
        Folder folder_ =  folderRepository.findById(folder.getFolderID()).orElse(null);
        if (folder_ == null) return null;

        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null) return null;

        folder.setUser(user);
        folderRepository.save(folder);

        return folder;
    }
}
