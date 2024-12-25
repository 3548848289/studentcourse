package com.zhx.studentcourse.service.impl;

import com.zhx.studentcourse.dao.IStudentDao;
import com.zhx.studentcourse.dao.ITeacherDao;
import com.zhx.studentcourse.dao.IUserDao;
import com.zhx.studentcourse.pojo.Student;
import com.zhx.studentcourse.pojo.Teacher;
import com.zhx.studentcourse.pojo.User;
import com.zhx.studentcourse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IStudentDao studentDao;
    @Autowired
    private ITeacherDao teacherDao;


    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public int userRegister(User user,Object obj) {
        if(user.getUserType().equals("学生")&&(obj instanceof Student)){
            Student student  = (Student) obj;
            //先添加学生
            if(studentDao.insertStudent(student)>0){
                //添加学生成功添加用户
                return userDao.userRegister(user);
            }
        }else if(user.getUserType().equals("教师")&&(obj instanceof Teacher)){
            Teacher teacher  = (Teacher) obj;
            //先添加教师
            if(teacherDao.insertTeacher(teacher)>0){
                //添加成功后添加用户
                return userDao.userRegister(user);
            }
        }
        return -1;
    }
}
