package com.zhx.studentcourse.service;




import com.zhx.studentcourse.pojo.StudentCourse;

import java.util.List;


public interface IStudentCourseService {
    List<StudentCourse> getAll(StudentCourse studentCourse);

    int selectCourse(StudentCourse studentCourse);

    int updateScore(List<StudentCourse> list);
}
