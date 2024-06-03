package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.Level.LevelConverter;
import com.group32.vocabularyRevisionAPI.DTO.Level.LevelDTO;
import com.group32.vocabularyRevisionAPI.Model.DetailedLevel;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Service.DetailedLevelService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/detailed-level")
public class DetailedLevelController {
    private final DetailedLevelService detailedLevelService;

    public DetailedLevelController(DetailedLevelService detailedLevelService) {
        this.detailedLevelService = detailedLevelService;
    }

    @GetMapping(path = "/{username}")
    public ResponseData getCurrentLevel(@PathVariable("username") String username) {
        ResponseData responseData = new ResponseData();
        Level level = detailedLevelService.getCurrentLevel(username);
        if (level != null) {
            responseData.setStatus(200);
            responseData.setMessage("Get current level of User successfully");
            responseData.setData(LevelConverter.toDTO(level));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username "+ username + " doesn't exists!");
        }

        return  responseData;
    }

//    @PostMapping(path = "/level-up")
//    @ResponseBody
//    public ResponseData levelUp(@RequestParam String username) {
//        DetailedLevel detailedLevel = detailedLevelService.levelUp(username);
//        ResponseData responseData = new ResponseData();
//
//        if (detailedLevel != null) {
//            responseData.setStatus(200);
//            responseData.setMessage("Level up for user successfully");
//            responseData.setData(LevelConverter.toDTO(detailedLevel));
//        } else {
//            responseData.setStatus(300);
//            responseData.setMessage("The username "+ username + " doesn't exists!");
//        }
//
//        return responseData;
//    }
}
