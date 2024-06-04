package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.Folder.FolderConverter;
import com.group32.vocabularyRevisionAPI.DTO.Folder.FolderDTO;
import com.group32.vocabularyRevisionAPI.DTO.VocabularyLists.VocabularyListsConverter;
import com.group32.vocabularyRevisionAPI.DTO.VocabularyLists.VocabularyListsDTO;
import com.group32.vocabularyRevisionAPI.Model.Folder;
import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Model.VocabularyLists;
import com.group32.vocabularyRevisionAPI.Service.VocabularyListsService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/vocabulary-lists")
public class VocabularyListsController {
    private final VocabularyListsService vocabularyListsService;

    public VocabularyListsController(VocabularyListsService vocabularyListsService) {
        this.vocabularyListsService = vocabularyListsService;
    }

    @GetMapping(path = "/all")
    public ResponseData getAllVocabularyListsByFolderID(@RequestParam Long folderID) {
        List<VocabularyLists> vocabularyLists = vocabularyListsService.getAllVocabularyListsByFolderID(folderID);
        ResponseData responseData = new ResponseData();
        if(vocabularyLists != null) {
            List<VocabularyListsDTO> vocabularyListsDTO = vocabularyLists.stream().map(VocabularyListsConverter::toDTO).toList();
            responseData.setStatus(200);
            responseData.setMessage("Get all folder of user successfully");
            responseData.setData(Collections.singletonList(vocabularyListsDTO));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The folder ID: " + folderID + " does not exists!");
        }

        return responseData;
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseData addVocabularyList(@RequestParam Long folderID, @RequestParam String list_name, @RequestParam String description, @RequestBody List<Vocabulary> vocabularyList) {
        VocabularyLists vocabularyLists = vocabularyListsService.addVocabularyList(folderID, list_name, description, vocabularyList);
        ResponseData responseData = new ResponseData();
        if(vocabularyLists != null) {
            responseData.setStatus(200);
            responseData.setMessage("Added a vocabulary list successfully");
            responseData.setData(VocabularyListsConverter.toDTO(vocabularyLists));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The folder ID: " + folderID + " does not exists!");
        }
        return responseData;
    }
}
