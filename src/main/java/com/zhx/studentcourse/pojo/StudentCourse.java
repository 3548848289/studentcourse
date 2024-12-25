package com.zhx.studentcourse.pojo;
import lombok.Data;

@Data
public class StudentCourse {

    private int id;
    private int stuId;
    private String stuSno;
    private String stuName;
    private String stuDepartment;
    private int courseId;
    private String courseName;
    private int courseTeacherId;
    private String courseTeacherName;
    private String teacherDepartment;
    private float courseCredit;
    private String createTime;
    private float courseScore;

    public StudentCourse() {
    }

    public StudentCourse(int id, int stuId, String stuSno, String stuName, String stuDepartment, int courseId, String courseName, int courseTeacherId, String courseTeacherName, String teacherDepartment, float courseCredit, String createTime, float courseScore) {
        this.id = id;
        this.stuId = stuId;
        this.stuSno = stuSno;
        this.stuName = stuName;
        this.stuDepartment = stuDepartment;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTeacherId = courseTeacherId;
        this.courseTeacherName = courseTeacherName;
        this.teacherDepartment = teacherDepartment;
        this.courseCredit = courseCredit;
        this.createTime = createTime;
        this.courseScore = courseScore;
    }
}
