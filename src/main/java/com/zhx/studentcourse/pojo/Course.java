package com.zhx.studentcourse.pojo;

import lombok.Data;

@Data
public class Course {
    private int courseId;
    private String courseName;
    private int courseTeacherId;
    private String courseTeacherName;
    private String courseTeacherDepartment;
    private float courseCredit;
    private String courseTerm;
    private int courseMaxStuNums;
    private int courseCurrentStuNums;
    private String courseBookImg;

}
