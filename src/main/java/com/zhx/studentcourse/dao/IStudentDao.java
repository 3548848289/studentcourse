package com.zhx.studentcourse.dao;


import com.zhx.studentcourse.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository("studentDao")
public interface IStudentDao {
    //查找所有学生
    List<Student> getAll(Student student);
    //更新学生
    void updateStudent(Student student);
    //根据学号查找学生
    Student getStudentBySno(String sno);
    //添加学生
    int insertStudent(Student student);
}
