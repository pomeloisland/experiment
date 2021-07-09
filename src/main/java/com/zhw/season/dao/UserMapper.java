package com.zhw.season.dao;

import com.zhw.season.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //查询全部用户
    List<User> getAllUser();

    //增加一个用户
    int addUser(User user);

    //删除一个用户
    int deleteUser(int id);

    //更新用户
    int updateUser(User user);

    //查询一个用户
    User getUserById(int id);

    User queryUserByName(@Param("userName") String userName);
}
