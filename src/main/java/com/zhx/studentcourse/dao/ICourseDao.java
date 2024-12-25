package com.zhx.studentcourse.dao;

import com.zhx.studentcourse.pojo.Course;
import com.zhx.studentcourse.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository("courseDao")
public interface ICourseDao {
    //根据id查找课程
    Course getCourseById(int courseId);
    //获取所有课程（可以根据教师id或院系进行查询）
    List<Course> getAll(Teacher teacher);
    //获取学生可选择的课程
    List<Course> getUnSelectCourse(@Param("stuId")int stuId);
    //根据课程id更新课程当前人数（+1）
    int updateCurrentNums(@Param("courseId")int courseId);

    int updateCourseImg(Course course);
}
