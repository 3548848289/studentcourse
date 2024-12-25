package com.zhx.studentcourse.dao;



import com.zhx.studentcourse.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("teacherDao")
public interface ITeacherDao {
    //查找所有教师
    List<Teacher> getAll(Teacher teacher);

    Teacher getTeacherByNo(String no);

    //添加教师
    int insertTeacher(Teacher teacher);
}
