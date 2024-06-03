package com.group32.vocabularyRevisionAPI.DTO.Level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LevelDTO {
    private Long levelID;
    private String level_name;
    private int experience;
}
