package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.User.UserConverter;
import com.group32.vocabularyRevisionAPI.DTO.User.UserDTO;
import com.group32.vocabularyRevisionAPI.Model.Statistics.LearnedVocabularyRanking;
import com.group32.vocabularyRevisionAPI.Model.Statistics.LevelRanking;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseData getAllUsers() {
        List<UserDTO> userDTOList = userService.getAllUsers().stream().map(UserConverter::toDTO).toList();
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("Get all users successfully");
        responseData.setData(Collections.singletonList(userDTOList));
        return responseData;
    }

    @GetMapping(path = "/{username}")
    public ResponseData getUser(@PathVariable("username") String username) {
        ResponseData responseData = new ResponseData();
        User user = userService.getUserByUsername(username);
        if (user != null) {
            responseData.setStatus(200);
            responseData.setMessage("Get user successfully");
            responseData.setData(UserConverter.toDTO(user));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username "+ username + " doesn't exists!");
        }

        return  responseData;
    }

    @PutMapping(path = "/{username}")
    @ResponseBody
    public ResponseData updateUser(@RequestBody User user, @PathVariable("username") String username) {
        User user_ = userService.updateUser(user, username);

        ResponseData responseData = new ResponseData();
        if(user_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Updated user successfully");
            responseData.setData(UserConverter.toDTO(user_));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username " + username + " does not exists!");
        }
        return responseData;
    }

    @PutMapping("/{username}/experience")
    public ResponseData updateExperience(@PathVariable("username") String username, @RequestParam Long experience) {
        User user = userService.updateExperience(username, experience);
        ResponseData responseData = new ResponseData();
        if(user != null) {
            responseData.setStatus(200);
            responseData.setMessage("Updated the experience of user successfully");
            responseData.setData(UserConverter.toDTO(user));
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username " + user.getUsername() + " does not exists!");
        }
        return responseData;
    }

    @GetMapping("/level-ranking")
    public ResponseData getLevelRanking() {
        List<LevelRanking> levelRankingList = userService.getLevelRanking();
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("Got level ranking of user successfully");
        responseData.setData(levelRankingList);
        return responseData;
    }

    @GetMapping("/learned-vocabulary-ranking")
    public ResponseData getLearnedVocabularyRanking() {
        List<LearnedVocabularyRanking> learnedVocabularyRankingList = userService.getLearnedVocabularyRanking();
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("Got learned vocabulary ranking of user successfully");
        responseData.setData(learnedVocabularyRankingList);
        return responseData;
    }
}
