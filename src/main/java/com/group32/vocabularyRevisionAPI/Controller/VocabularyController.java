package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.Vocabulary.VocabularyConverter;
import com.group32.vocabularyRevisionAPI.DTO.Vocabulary.VocabularyDTO;
import com.group32.vocabularyRevisionAPI.Model.Vocabulary;
import com.group32.vocabularyRevisionAPI.Service.VocabularyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/vocabulary")
public class VocabularyController {
    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping(path = "/all")
    public ResponseData getAllVocabularyByVocabularyListID(@RequestParam Long vocabularyListID) {
        List<Vocabulary> vocabularyList = vocabularyService.getAllVocabularyByVocabularyListID(vocabularyListID);
        ResponseData responseData = new ResponseData();
        if(vocabularyList != null) {
            List<VocabularyDTO> vocabularyDTO = vocabularyList.stream().map(VocabularyConverter::toDTO).toList();
            responseData.setStatus(200);
            responseData.setMessage("Get all vocabulary successfully");
            responseData.setData(Collections.singletonList(vocabularyDTO));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The vocabulary list ID: " + vocabularyListID + " does not exists!");
        }
        return responseData;
    }
}
