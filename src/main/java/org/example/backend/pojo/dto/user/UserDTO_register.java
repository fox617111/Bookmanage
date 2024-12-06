package org.example.backend.pojo.dto.user;

import lombok.Data;

@Data
public class UserDTO_register {
    private String username;
    private String password;
    private String email;
}
