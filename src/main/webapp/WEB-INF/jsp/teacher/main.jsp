<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>首页</title>
    <link href="css/s2.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <%@include file="../header.jsp"%>
  <h1>网站首页</h1>
  欢迎您,${sessionScope.user.userName}，您的用户类型${sessionScope.user.userType}<br>
  教师信息：${sessionScope.teacher}<br>
  <a href="loginOut">退出登录</a>
  <hr>
  <h3>我的课程</h3>
  <table>
    <thead>
    <tr>
      <th>课程id</th>
      <th>课程名称</th>
      <th>课程教师</th>
      <th>开课院系</th>
      <th>课程学期</th>
      <th>课程学分</th>
      <th>教材图片</th>
      <th>最大人数</th>
      <th>当前人数</th>
      <th>课程学生</th>
      <th>上传教材图片</th>
    </tr>
    </thead>
    <c:forEach  items="${courseList}" var="course" >
      <tr>
        <td>${course.courseId}</td>
        <td>${course.courseName}</td>
        <td>${course.courseTeacherName}</td>
        <td>${course.courseTeacherDepartment}</td>
        <td>${course.courseTerm}</td>
        <td>${course.courseCredit}</td>
        <td><img src="fileUpload/${course.courseBookImg}" width="100px" height="100px"></td>
        <td>${course.courseMaxStuNums}</td>
        <td>${course.courseCurrentStuNums}</td>
        <td><a href="courseStudent?courseId=${course.courseId}">课程学生</a></td>
        <td><a href="uploadImg?courseId=${course.courseId}">上传教材图片</a></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
