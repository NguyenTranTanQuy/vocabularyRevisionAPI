package com.group32.vocabularyRevisionAPI.Controller;

import com.group32.vocabularyRevisionAPI.Controller.Model.ResponseData;
import com.group32.vocabularyRevisionAPI.DTO.Level.LevelConverter;
import com.group32.vocabularyRevisionAPI.DTO.Level.LevelDTO;
import com.group32.vocabularyRevisionAPI.Model.Level;
import com.group32.vocabularyRevisionAPI.Service.LevelService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/level")
public class LevelController {
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseData addLevel(@RequestParam String levelName, @RequestParam int experience) {
        Level level = levelService.addLevel(levelName, experience);
        ResponseData responseData = new ResponseData();

        responseData.setStatus(200);
        responseData.setMessage("Added level successfully");
        responseData.setData(level);

        return responseData;
    }

    @GetMapping(path = "/all")
    public ResponseData getAllLevels() {
        List<LevelDTO> levelDTOList = levelService.getAllLevels().stream().map(LevelConverter::toDTO).toList();
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setMessage("Get all levels successfully");
        responseData.setData(Collections.singletonList(levelDTOList));
        return responseData;
    }

    @PutMapping(path = "/")
    @ResponseBody
    public ResponseData updateLevel(@RequestBody Level level) {
        Level level_ = levelService.updateLevel(level);

        ResponseData responseData = new ResponseData();
        if(level_ != null) {
            responseData.setStatus(200);
            responseData.setMessage("Updated level successfully");
            responseData.setData(level_);
        } else {
            responseData.setStatus(300);
            responseData.setMessage("The level ID " + level.getLevelID() + " does not exists!");
        }

        return responseData;
    }
}
