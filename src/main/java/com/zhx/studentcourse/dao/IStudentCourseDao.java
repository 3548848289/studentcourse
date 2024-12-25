package com.zhx.studentcourse.dao;

import com.zhx.studentcourse.pojo.Student;
import com.zhx.studentcourse.pojo.StudentCourse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("studentCourseDao")
public interface IStudentCourseDao {
    //获取所有选课记录（可以带条件）
    List<StudentCourse> getAll(StudentCourse studentCourse);
    //学生选课
    int selectCourse(StudentCourse studentCourse);

   /* List<Student> getStudentsByCourseId(int id);*/
    int updateScore(List<StudentCourse> list);
}
