package com.zhx.studentcourse.controller;

import com.zhx.studentcourse.pojo.Course;
import com.zhx.studentcourse.pojo.StuCourseScores;
import com.zhx.studentcourse.pojo.Student;
import com.zhx.studentcourse.pojo.StudentCourse;
import com.zhx.studentcourse.service.ICourseService;
import com.zhx.studentcourse.service.IStudentCourseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StuCourseController {
    @Autowired
    private IStudentCourseService studentCourseService;
    @Autowired
    private ICourseService courseService;


    @PostMapping("/updateScore")
    public String updateScore(@ModelAttribute StuCourseScores stuCourseScores) {
        List<StudentCourse> scores = stuCourseScores.getScores();
        for(StudentCourse sc: scores){
            System.out.println(sc);
        }
        studentCourseService.updateScore(scores);
        return "redirect: teacher_main";
    }

    @GetMapping("/courseStudent")
    public String courseStudent(@RequestParam  int courseId, Model model, HttpSession session){
        //根据课程id获取课程对象
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourseId(courseId);
        List<StudentCourse> studentCourseList = studentCourseService.getAll(studentCourse);
        model.addAttribute("studentCourseList",studentCourseList);
        return "teacher/course_student";
    }


    @GetMapping("/selectCourse")
    public String selectCourse(@RequestParam int stuId, @RequestParam  int courseId, Model model, HttpSession session){
        Student student = (Student) session.getAttribute("student");
        //根据课程id获取课程对象
       Course course = courseService.getCourseById(courseId);
       //先判断课程人数是否已满
       if(course.getCourseCurrentStuNums()<course.getCourseMaxStuNums()){
           //人数未满
           StudentCourse studentCourse = new StudentCourse();
           studentCourse.setStuId(stuId);
           studentCourse.setCourseId(courseId);
           String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
           studentCourse.setCreateTime(createTime);
           studentCourse.setCourseScore(0);
           //执行选课
           if (studentCourseService.selectCourse(studentCourse)>0){
               model.addAttribute("msg","选课成功");
           }
       }else{
           model.addAttribute("msg","人数已满");
       }
        //获取该生未选的所有课程
        List<Course> courseList = courseService.getUnSelectCourse(student.getStuId());
        //获取学生选课记录
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStuId(student.getStuId());
        List<StudentCourse> studentCourseList = studentCourseService.getAll(studentCourse);
        //利用model传输数据
        model.addAttribute("courseList",courseList);
        model.addAttribute("studentCourseList",studentCourseList);
       return "student/main";
    }
}
