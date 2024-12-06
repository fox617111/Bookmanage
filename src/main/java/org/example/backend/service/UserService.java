package org.example.backend.service;

import org.example.backend.pojo.dto.user.UserDTO_login;
import org.example.backend.pojo.dto.user.UserDTO_register;
import org.example.backend.pojo.vo.UserVO;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param userDTOLogin
     */
    UserVO login(UserDTO_login userDTOLogin);

    /**
     * 用户注册
     * @param userDTORegister
     */
    void register(UserDTO_register userDTORegister);

    /**
     * 获取用户信息
     * @param userVO 
     * @return
     */
    List<UserVO> getInfo(UserVO userVO);

    /**
     * 更新用户信息
     * @param userVO
     */
    void update(UserVO userVO);

    /**
     * 获取个人信息
     * @return
     */
    UserVO getUserInfo();

    /**
     * 删除用户
     */
    void deleteUser(UserVO userVO);

    /**
     * 添加用户
     * @param userVO
     */
    void addUser(UserVO userVO);
}
