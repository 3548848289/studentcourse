<%--
  Created by IntelliJ IDEA.
  User: 36413
  Date: 2023/12/3
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>上传图片</title>
    <link href="css/s2.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../header.jsp" %>
<h1>上传课程教材图片</h1>
欢迎您,${sessionScope.user.userName}，您的用户类型${sessionScope.user.userType}<br>
教师信息：${sessionScope.teacher}<br>
<a href="loginOut">退出登录</a>
    <form action="uploadCourseBookImg" enctype="multipart/form-data" method="post">
        id：<input type="text" name="courseId" value="${courseId}" readonly><br>
        pic:<input type="file" name="file"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
