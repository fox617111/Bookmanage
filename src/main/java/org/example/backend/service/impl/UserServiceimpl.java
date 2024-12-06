package org.example.backend.service.impl;



import org.example.backend.mapper.UserMapper;
import org.example.backend.pojo.dto.user.UserDTO_login;
import org.example.backend.pojo.dto.user.UserDTO_register;
import org.example.backend.pojo.vo.UserVO;
import org.example.backend.service.UserService;
import org.example.backend.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceimpl implements UserService {

    private UserMapper usermapper;
    @Autowired
    public UserServiceimpl(UserMapper usermapper) {
        this.usermapper = usermapper;
    }
    @Override
    public UserVO login(UserDTO_login userDTOLogin) {
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(userDTOLogin,userVO);
        UserVO newuserVO=usermapper.login(userVO);
        newuserVO.setLogin_time(LocalDateTime.now());
        usermapper.update(newuserVO);
        return newuserVO;

    }

    @Override
    public void register(UserDTO_register userDTORegister) {
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(userDTORegister,userVO);
        usermapper.register(userVO);

    }

    @Override
    public List<UserVO> getInfo(UserVO userVO) {
        System.out.println(userVO.getEmail());
        System.out.println(userVO.toString());
        List<UserVO> userVOList=usermapper.selectList(userVO);
        return userVOList;
    }

    @Override
    public void update(UserVO userVO) {
        usermapper.update(userVO);
    }

    @Override
    public UserVO getUserInfo() {
        Map<String, Object> map= ThreadLocalUtil.get();
        int id= (int) map.get("id");
        UserVO userVO=new UserVO();
        userVO.setUser_id(id);
        return usermapper.select(userVO);
    }

    @Override
    public void deleteUser(UserVO userVO) {
        usermapper.delete(userVO);

    }

    @Override
    public void addUser(UserVO userVO) {
        usermapper.insert(userVO);
    }


}
