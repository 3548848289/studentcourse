package com.zhx.studentcourse.pojo;

import lombok.Data;

@Data
public class Teacher {

    private int teacherId;
    private String teacherNo;
    private String teacherName;
    private int teacherDepartmentId;
    private String teacherDepartmentName;

    public Teacher() {
    }

    public Teacher(String teacherNo, String teacherName, int teacherDepartmentId) {
        this.teacherNo = teacherNo;
        this.teacherName = teacherName;
        this.teacherDepartmentId = teacherDepartmentId;
    }
}
