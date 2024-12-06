package org.example.backend.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVO {
    Integer user_id;
    private String username;
    private String nickname;
    private String role;
    private LocalDateTime register_time;
    private LocalDateTime login_time;
    private String password;
    private String personality;// 性格
    private String personal_description;// 个人描述
    private LocalDateTime birthday;
    private String phone_number;
    private String email;
    private String avatar_url;
    private Boolean is_active;
    private Boolean sex;

}
