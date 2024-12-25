package com.zhx.studentcourse.service.impl;

import com.zhx.studentcourse.dao.ITeacherDao;
import com.zhx.studentcourse.pojo.Teacher;
import com.zhx.studentcourse.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherDao teacherDao;

    @Override
    public List<Teacher> getAll(Teacher teacher) {
        return teacherDao.getAll(teacher);
    }

    @Override
    public int insertTeacher(Teacher teacher) {
       return teacherDao.insertTeacher(teacher);
    }

    @Override
    public Teacher getTeacherByNo(String no) {
        return teacherDao.getTeacherByNo(no);
    }
}
