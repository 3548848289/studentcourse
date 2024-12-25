package com.zhx.studentcourse.dao;

import com.zhx.studentcourse.pojo.Course;
import com.zhx.studentcourse.pojo.Department;
import com.zhx.studentcourse.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("departmentDao")
public interface IDepartmentDao {
    List<Department> getAll();
}
