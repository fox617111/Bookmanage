package org.example.backend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.backend.pojo.vo.UserVO;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username} and password=#{password}")
    UserVO login(UserVO userVO);

    @Insert("INSERT INTO users(username,password,email) VALUES(#{username},#{password},#{email})")
    void register(UserVO userVO);

    void update(UserVO userVO);

    List<UserVO> selectList(UserVO userVO);

    UserVO select(UserVO userVO);

    void delete(UserVO userVO);

    void insert(UserVO userVO);
}
