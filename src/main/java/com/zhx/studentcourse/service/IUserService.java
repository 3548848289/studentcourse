package com.zhx.studentcourse.service;

import com.zhx.studentcourse.pojo.StudentCourse;
import com.zhx.studentcourse.pojo.User;

import java.util.List;

public interface IUserService {

    //根据id查找用户
    User getUserById(int id);
    //根据账号查找用户
    User getUserByUsername(String username);
    //用户注册
    int userRegister(User user,Object obj);


}
