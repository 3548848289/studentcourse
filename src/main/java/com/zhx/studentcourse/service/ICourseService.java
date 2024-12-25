package com.zhx.studentcourse.service;

import com.zhx.studentcourse.pojo.Course;
import com.zhx.studentcourse.pojo.Teacher;

import java.util.List;


public interface ICourseService {

    Course getCourseById(int courseId);

    List<Course> getAll(Teacher teacher);

    List<Course> getUnSelectCourse(int stuId);

    int updateCourseImg(Course course);
}
