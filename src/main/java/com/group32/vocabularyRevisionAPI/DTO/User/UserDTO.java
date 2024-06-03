package com.group32.vocabularyRevisionAPI.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private Date dob;
    private Date created_at;
}
