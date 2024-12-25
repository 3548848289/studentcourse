package com.zhx.studentcourse.service;



import com.zhx.studentcourse.pojo.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll(Student student);

    void updateStudent(Student student);

    Student getStudentBySno(String sno);

    //添加学生
    int insertStudent(Student student);
}
