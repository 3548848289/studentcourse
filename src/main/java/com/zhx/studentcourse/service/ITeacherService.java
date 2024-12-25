package com.zhx.studentcourse.service;



import com.zhx.studentcourse.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ITeacherService {
    //查找所有教师
    List<Teacher> getAll(Teacher teacher);

    //添加教师
    int insertTeacher(Teacher teacher);

    Teacher getTeacherByNo(String no);
}
