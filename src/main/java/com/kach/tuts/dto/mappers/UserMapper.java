package com.kach.tuts.dto.mappers;

import com.kach.tuts.dto.UserDTO;
import com.kach.tuts.models.User;

public class UserMapper {
    public static UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO(user.getId(), user.getUsername());
        return dto;
    }
}
