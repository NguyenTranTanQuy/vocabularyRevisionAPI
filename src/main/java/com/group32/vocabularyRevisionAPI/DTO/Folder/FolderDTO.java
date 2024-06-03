package com.group32.vocabularyRevisionAPI.DTO.Folder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FolderDTO {
    private Long folderID;
    private String folder_name;
    private String description;
}
