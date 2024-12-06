package org.example.backend.controller;

import org.example.backend.pojo.Result;
import org.example.backend.pojo.dto.user.UserDTO_login;
import org.example.backend.pojo.dto.user.UserDTO_register;
import org.example.backend.pojo.vo.UserVO;
import org.example.backend.service.UserService;
import org.example.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody UserDTO_register userDTORegister) {
        userService.register(userDTORegister);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserDTO_login userDTOLogin) {
        UserVO newuservo = userService.login(userDTOLogin);
        if (newuservo == null) {
            return Result.error("用户名或密码错误");
        } else {
            int id = newuservo.getUser_id();
            Map<String, Object> map = Map.of("id", id);
            String token = JwtUtil.genToken(map);
            return Result.success(token);
        }
    }

    @GetMapping
    public Result<List<UserVO>> getInfo(@RequestBody UserVO userVO) {
        List<UserVO> userVOList = userService.getInfo(userVO);
        return Result.success(userVOList);
    }

    @PutMapping
    public Result<String> updateUserInfo(@RequestBody UserVO userVO) {
        userService.update(userVO);
        return Result.success();
    }

    @GetMapping("/info")
    public Result<UserVO> getUserInfo() {
        UserVO userVO = userService.getUserInfo();
        return Result.success(userVO);
    }

    @DeleteMapping
    public Result<String> deleteUser(@RequestBody UserVO userVO) {
        userService.deleteUser(userVO);
    	return Result.success();
    }

    @PostMapping
    public  Result<String> addUser(@RequestBody UserVO userVO) {
    	userService.addUser(userVO);
    	return Result.success();
    }
}