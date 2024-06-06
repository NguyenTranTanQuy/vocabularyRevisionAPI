package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.Folder.FolderConverter;
import com.group32.vocabularyRevisionAPI.DTO.Folder.FolderDTO;
import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Service.FolderService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/folder")
public class FolderController {
    private final FolderService folderService;

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping(path = "/all")
    public ResponseData getAllFolderByUsername(@RequestParam String username) {
        List<Folder> folderList = folderService.getAllFolderByUsername(username);
        ResponseData responseData = new ResponseData();
        if(folderList != null) {
            List<FolderDTO> folderDTOList = folderList.stream().map(FolderConverter::toDTO).toList();
            responseData.setStatus(200);
            responseData.setMessage("Get all folder of user successfully");
            responseData.setData(Collections.singletonList(folderDTOList));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username " + username + " does not exists!");
        }

        return responseData;
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseData addFolder(@RequestBody Folder folder, @RequestParam String username) {
        Folder folder_ = folderService.addFolder(folder.getFolder_name(), folder.getDescription(), username);
        ResponseData responseData = new ResponseData();
        if(folder_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Added folder successfully");
            responseData.setData(FolderConverter.toDTO(folder_));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username " + username + " does not exists!");
        }
        return responseData;
    }

    @GetMapping(path = "/{folderID}")
    public ResponseData getFolder(@PathVariable("folderID") Long folderID) {
        Folder folder = folderService.getFolder(folderID);
        ResponseData responseData = new ResponseData();
        if(folder != null) {
            responseData.setStatus(200);
            responseData.setMessage("Got folder successfully");
            responseData.setData(FolderConverter.toDTO(folder));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The folder ID " + folderID + " does not exists!");
        }
        return responseData;
    }

    @PutMapping(path = "/")
    @ResponseBody
    public ResponseData updateFolder(@RequestBody Folder folder) {
        Folder folder_ = folderService.updateFolder(folder);

        ResponseData responseData = new ResponseData();
        if(folder_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Updated folder successfully");
            responseData.setData(FolderConverter.toDTO(folder_));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The folder ID " + folder_.getFolderID() + " does not exists!");
        }

        return responseData;
    }

    @DeleteMapping(path = "/{folderID}")
    @ResponseBody
    public ResponseData deleteFolder(@PathVariable("folderID") Long folderID) {
        Folder folder = folderService.deleteFolder(folderID);
        ResponseData responseData = new ResponseData();
        if(folder != null) {
            responseData.setStatus(200);
            responseData.setMessage("Deleted a folder successfully");
            responseData.setData(FolderConverter.toDTO(folder));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The folder ID " + folderID + " does not exists!");
        }

        return responseData;
    }
}
