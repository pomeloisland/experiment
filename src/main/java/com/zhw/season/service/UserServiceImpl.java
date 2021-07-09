package com.zhw.season.service;

import com.zhw.season.dao.UserMapper;
import com.zhw.season.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    //调用dao层的操作,设置一个set接口,方便spring管理
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }

}
