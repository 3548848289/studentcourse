package com.zhx.studentcourse.service;

import com.zhx.studentcourse.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IDepartmentService {
    List<Department> getAll();
}
