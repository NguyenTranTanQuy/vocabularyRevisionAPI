package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.User.UserConverter;
import com.group32.vocabularyRevisionAPI.DTO.User.UserDTO;
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
    public ResponseData updateUser(@RequestBody User user) {
        User user_ = userService.updateUser(user);

        ResponseData responseData = new ResponseData();
        if(user_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Updated user successfully");
            responseData.setData(user_);
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The username " + user.getUsername() + " does not exists!");
        }

        return responseData;
    }
}
