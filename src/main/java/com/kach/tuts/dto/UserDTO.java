package com.kach.tuts.dto;

import com.kach.tuts.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    Long id;
    String username;
    String firstName;
    String lastName;
    String patronymic;

    public UserDTO(User user) {
        id = user.getId();
        username = user.getUsername();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        patronymic = user.getPatronymic();
    }
}
