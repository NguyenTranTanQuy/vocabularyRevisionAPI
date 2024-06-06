package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.UserProgress.UserProgressConverter;
import com.group32.vocabularyRevisionAPI.Model.UserProgress;
import com.group32.vocabularyRevisionAPI.Service.UserProgressService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user-progress")
public class UserProgressController {
    private final UserProgressService userProgressService;

    public UserProgressController(UserProgressService userProgressService) {
        this.userProgressService = userProgressService;
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseData addUserProgress(@RequestParam String username, @RequestParam Long vocabularyID, @RequestParam boolean isTrue) {
        UserProgress userProgress = userProgressService.addUserProgress(username, vocabularyID, isTrue);
        ResponseData responseData = new ResponseData();
        if(userProgress != null) {
            responseData.setStatus(200);
            responseData.setMessage("Added user progress successfully");
            responseData.setData(UserProgressConverter.toDTO(userProgress));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username " + username + " or vocabulary ID " + vocabularyID + " does not exists!");
        }
        return responseData;
    }

}
