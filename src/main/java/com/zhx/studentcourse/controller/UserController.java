package com.zhx.studentcourse.controller;

import com.zhx.studentcourse.pojo.*;
import com.zhx.studentcourse.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IStudentCourseService studentCourseService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IDepartmentService departmentService;

    @PostMapping("login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            RedirectAttributes model,
                            Model model1,
                            HttpSession session) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            //账号和密码都一致
            if (user.getUserPassword().equals(password)) {
                session.setAttribute("user", user);
                model.addFlashAttribute("msg", "登录成功");
                if (user.getUserType().equals("学生")) {
                    return "redirect: student_main";
                } else if (user.getUserType().equals("教师")) {
                    return "redirect: teacher_main";
                } else {
                    //管理员
                    return "admin/main";
                }
            }
        }
        model1.addAttribute("msg", "账号或密码错误，登录失败");
        return "index";
    }

    @PostMapping("register")
    public String userRegister(@ModelAttribute User user,
                               @RequestParam String depId,
                               @RequestParam String name,
                               RedirectAttributes model,
                               HttpSession session) {
        try {
            Object obj = null;
            if (user.getUserType().equals("学生")) {
                obj = new Student(user.getUserName(), name, Integer.parseInt(depId));
            } else {
                obj = new Teacher(user.getUserName(), name, Integer.parseInt(depId));
            }
            if (userService.userRegister(user, obj) > 0) {
                //注册成功，由于注册时提交的用户数据没有id，需要根据账号从数据库重新查询
                User u = userService.getUserByUsername(user.getUserName());
                //将用户对象存入session
                session.setAttribute("user", u);
                if (user.getUserType().equals("学生")) {
                    model.addFlashAttribute("msg", "登录成功");
                    return "redirect: student_main";
                }
                return "main";
            }
        } catch (Exception e) {
            model.addFlashAttribute("msg", "发生了异常：" + e.getMessage());
            return "redirect:startRegister";
        }
        model.addAttribute("msg", "注册失败");
        return "register";
    }

    @GetMapping("/startRegister")
    public String startRegister(Model model) {
        List<Department> departments = departmentService.getAll();
        model.addAttribute("departments", departments);
        return "register";
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        //退出登录需要销毁session
        session.invalidate();
        return "index";
    }
    @GetMapping("/teacher_main")
    public String teacher_main(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Teacher teacher = teacherService.getTeacherByNo(user.getUserName());
        session.setAttribute("teacher",teacher);
        List<Course> courseList = courseService.getAll(teacher);
        model.addAttribute("courseList",courseList);
        return "teacher/main";

    }



    @GetMapping("/student_main")
    public String student_main(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        Student student = studentService.getStudentBySno(user.getUserName());
        //获取该生可选的所有课程
        List<Course> courseList = courseService.getUnSelectCourse(student.getStuId());
        //获取学生选课记录
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStuId(student.getStuId());
        List<StudentCourse> studentCourseList = studentCourseService.getAll(studentCourse);
        if (session.getAttribute("msg") != null) {
            model.addAttribute("msg", session.getAttribute("msg"));
        }
        model.addAttribute("courseList", courseList);
        model.addAttribute("studentCourseList", studentCourseList);
        session.setAttribute("student", student);
        return "student/main";
    }
}
