package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.User.UserConverter;
import com.group32.vocabularyRevisionAPI.Model.User;
import com.group32.vocabularyRevisionAPI.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final UserService userService;
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(path = "/")
    @ResponseBody
    public ResponseData resetPassword(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email) {
        boolean isSuccess = userService.resetPassword(username, password, email);

        ResponseData responseData = new ResponseData();
        if (isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Reset password successfully!");
        }
        else {
            responseData.setStatus(400);
            responseData.setMessage("Username or email is wrong!");
        }

        return responseData;
    }

    @PostMapping(path = "/sign-in")
    @ResponseBody
    public ResponseData signIn(
            @RequestParam String username,
            @RequestParam String password) {
        boolean isSuccess = userService.signIn(username, password);

        ResponseData responseData = new ResponseData();
        if (isSuccess) {
            responseData.setStatus(200);
            responseData.setMessage("Sign in successfully");
        }
        else {
            responseData.setStatus(400);
            responseData.setMessage("Wrong username or password!");
        }

        return responseData;
    }

    @PostMapping(path = "/sign-up")
    @ResponseBody
    public ResponseEntity<ResponseData> addAccount(@RequestBody User user) {
        User user_ = userService.addUser(user);
        ResponseData responseData = new ResponseData();

        if(user_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Added account successfully");
            responseData.setData(UserConverter.toDTO(user_));
        } else {
            responseData.setStatus(301);
            responseData.setMessage("The username "+ user.getUsername() + " does exists!");
        }

        return ResponseEntity.ok(responseData);
    }
}
