package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.Folder.FolderConverter;
import com.group32.vocabularyRevisionAPI.DTO.Folder.FolderDTO;
import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Service.FolderService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/folder")
public class FolderController {
    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping(path = "/all")
    public ResponseData getAllFolderByUsername(@RequestParam String username) {
        List<FolderDTO> folderDTOList = folderService.getAllFolderByUsername(username).stream().map(FolderConverter::toDTO).toList();
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("Get all folder of user successfully");
        responseData.setData(Collections.singletonList(folderDTOList));
        return responseData;
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseData addFolder(@RequestBody Folder folder, @RequestParam String username) {
        Folder folder_ = folderService.addFolder(folder.getFolder_name(), folder.getDescription(), username);
        ResponseData responseData = new ResponseData();
        if(folder_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Added level successfully");
            responseData.setData(FolderConverter.toDTO(folder_));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username " + username + " does not exists!");
        }
        return responseData;
    }

    @PutMapping(path = "/")
    @ResponseBody
    public ResponseData updateFolder(@RequestBody Folder folder, @RequestParam String username) {
        Folder folder_ = folderService.updateFolder(folder, username);

        ResponseData responseData = new ResponseData();
        if(folder_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Updated folder successfully");
            responseData.setData(FolderConverter.toDTO(folder_));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The folder ID " + folder_.getFolderID() + " or username "+ username + " does not exists!");
        }

        return responseData;
    }
}
