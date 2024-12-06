package org.example.backend.pojo.dto.user;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class UserDTO_info {
    private String username;
    private String nickname;
    private String role;
    private String personality;//性格
    private String personal_description;//个人描述
    private LocalTime birthday;
    private String phone_number;
    private String email;
    private String avatar_url;
    private Boolean sex;
}
