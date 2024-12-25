package com.zhx.studentcourse.service.impl;

import com.zhx.studentcourse.dao.ICourseDao;
import com.zhx.studentcourse.pojo.Course;
import com.zhx.studentcourse.pojo.Teacher;
import com.zhx.studentcourse.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseDao ICourseDao;

    @Override
    public Course getCourseById(int courseId) {
        return ICourseDao.getCourseById(courseId);
    }

    @Override
    public List<Course> getAll(Teacher teacher) {
        return ICourseDao.getAll(teacher);
    }

    @Override
    public List<Course> getUnSelectCourse(int stuId) {
        return ICourseDao.getUnSelectCourse(stuId);
    }

    @Override
    public int updateCourseImg(Course course) {
        return ICourseDao.updateCourseImg(course);
    }
}
