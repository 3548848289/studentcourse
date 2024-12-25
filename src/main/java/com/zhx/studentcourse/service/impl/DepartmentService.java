package com.zhx.studentcourse.service.impl;

import com.zhx.studentcourse.dao.IDepartmentDao;
import com.zhx.studentcourse.pojo.Department;
import com.zhx.studentcourse.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentDao departmentDao;

    @Override
    public List<Department> getAll() {
        return departmentDao.getAll();
    }
}
