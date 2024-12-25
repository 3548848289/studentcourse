package com.zhx.studentcourse.controller;

import com.zhx.studentcourse.pojo.Course;
import com.zhx.studentcourse.service.ICourseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping("/uploadImg")
    public String startUpload(@RequestParam int courseId, Model model){
        model.addAttribute("courseId",courseId);
        return "teacher/course_img";
    }


    @PostMapping("uploadCourseBookImg")
    public String uploadBookImg(@RequestParam int courseId,
                                @RequestParam MultipartFile file,
                                HttpServletRequest request,
                                Model model){
        if(!file.isEmpty()) {
            String oldName = file.getOriginalFilename();
            //文件实际保存路径
            String realPath = "D:/Java/myProgram/studentcourse/fileUpload/";
            System.out.println(realPath);
            File saveFile = new File(realPath);
            if (!saveFile.isDirectory()) {
                saveFile.mkdir();
            }
            String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."),oldName.length());
            try {
                file.transferTo(new File(saveFile,newName));
                //保存成功
                Course course = new Course();
                course.setCourseId(courseId);
                course.setCourseBookImg(newName);
                courseService.updateCourseImg(course);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "redirect: teacher_main";
    }
}
