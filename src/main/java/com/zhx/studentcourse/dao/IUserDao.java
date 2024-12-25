package com.zhx.studentcourse.dao;

import com.zhx.studentcourse.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userDao")
public interface IUserDao {
    //根据id查找用户
    User getUserById(int id);
    //根据账号查找用户
    User getUserByUsername(String username);
    //用户注册
    int userRegister(User user);
}
