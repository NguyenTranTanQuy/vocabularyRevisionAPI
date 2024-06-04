package com.group32.vocabularyRevisionAPI.DTO.User;

import com.group32.vocabularyRevisionAPI.Model.User;

public class UserConverter {
    public static UserDTO toDTO(User user) {
        if (user == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirst_name(user.getFirst_name());
        userDTO.setLast_name(user.getLast_name());
        userDTO.setEmail(user.getEmail());
        userDTO.setDob(user.getDob());
        userDTO.setCreated_at(user.getCreated_at());
        userDTO.setExperience(user.getExperience());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) return null;

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFirst_name(userDTO.getFirst_name());
        user.setLast_name(userDTO.getLast_name());
        user.setEmail(userDTO.getEmail());
        user.setDob(userDTO.getDob());
        user.setCreated_at(userDTO.getCreated_at());
        user.setExperience(userDTO.getExperience());
        return user;
    }
}
