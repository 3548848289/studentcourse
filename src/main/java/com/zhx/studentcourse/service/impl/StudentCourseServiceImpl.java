package com.zhx.studentcourse.service.impl;


import com.zhx.studentcourse.dao.ICourseDao;
import com.zhx.studentcourse.dao.IStudentCourseDao;
import com.zhx.studentcourse.pojo.StudentCourse;
import com.zhx.studentcourse.service.ICourseService;
import com.zhx.studentcourse.service.IStudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
//开启事务
@Transactional
@Service("studentCourseService")
public class StudentCourseServiceImpl implements IStudentCourseService {
    @Autowired
    private IStudentCourseDao studentCourseDao;
    @Autowired
    private ICourseDao courseDao;

    @Override
    public List<StudentCourse> getAll(StudentCourse studentCourse){
        return studentCourseDao.getAll(studentCourse);
    }

    @Override
    public int selectCourse(StudentCourse studentCourse) {
        //首先向选课表添加一条选课记录
        if(studentCourseDao.selectCourse(studentCourse)>0){
            int result = 0;
            //添加成功后更新课程表的当前人数
            if(courseDao.updateCurrentNums(studentCourse.getCourseId())>0){
                return result;
            }
        }
        return 0;
    }

    @Override
    public int updateScore(List<StudentCourse> list) {
        return studentCourseDao.updateScore(list);
    }
}
