package com.zhx.studentcourse.pojo;
import lombok.Data;

@Data
public class Student {

    private int stuId;
    private String stuSno;
    private String stuName;
    private int stuDepId;
    private String stuDepName;

    public Student(){

    }

    public Student(String stuSno,String stuName,int stuDepId){
        this.stuSno = stuSno;
        this.stuName = stuName;
        this.stuDepId = stuDepId;
    }

}
