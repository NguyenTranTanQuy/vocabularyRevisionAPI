package com.group32.vocabularyRevisionAPI.DTO.DetailedLevel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailedLevelDTO {
    private String username;
    private Long levelID;
    private Date created_at;
}
