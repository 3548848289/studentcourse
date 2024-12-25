package com.zhx.studentcourse.service.impl;


import com.zhx.studentcourse.dao.IStudentDao;
import com.zhx.studentcourse.pojo.Student;
import com.zhx.studentcourse.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;

    @Override
    public List<Student> getAll(Student student) {
        return studentDao.getAll(student);
    }


    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public Student getStudentBySno(String sno) {
        return studentDao.getStudentBySno(sno);
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }
}
