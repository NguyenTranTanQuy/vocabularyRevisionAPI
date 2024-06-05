package com.group32.vocabularyRevisionAPI.DTO.UserProgress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProgressDTO {
    private String username;
    private Long vocabularyID;
    private int correct_attempts;
    private int incorrect_attempts;
    private Date last_attempt_date;
}
