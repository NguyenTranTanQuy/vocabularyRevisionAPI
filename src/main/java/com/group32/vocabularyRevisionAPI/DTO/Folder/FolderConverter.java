package com.group32.vocabularyRevisionAPI.DTO.Folder;


import com.group32.vocabularyRevisionAPI.Model.Folder;

public class FolderConverter {
    public static FolderDTO toDTO(Folder folder) {
        if (folder == null) return null;

        FolderDTO folderDTO = new FolderDTO();
        folderDTO.setFolderID(folder.getFolderID());
        folderDTO.setFolder_name(folder.getFolder_name());
        folderDTO.setDescription(folder.getDescription());
        return folderDTO;
    }

    public static Folder toEntity(FolderDTO folderDTO) {
        if (folderDTO == null) return null;

        Folder folder = new Folder();
        folder.setFolderID(folderDTO.getFolderID());
        folder.setFolder_name(folderDTO.getFolder_name());
        folder.setDescription(folderDTO.getDescription());
        return folder;
    }
}
