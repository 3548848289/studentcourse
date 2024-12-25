package com.zhx.studentcourse.pojo;
import lombok.Data;
//使用@Data注解，自动生成get、set和toString等方法
@Data
public class User {

    private int id;
    private String userName;
    private String userPassword;
    private String userType;
    private String name;
    private String no;
    private int depId;

}
