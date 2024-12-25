<%--
  Created by IntelliJ IDEA.
  User: 36413
  Date: 2023/12/3
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <link href="css/s2.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../header.jsp" %>
<h1>网站首页</h1>
欢迎您,${sessionScope.user.userName}，您的用户类型${sessionScope.user.userType}<br>
教师信息：${sessionScope.teacher}<br>
<a href="loginOut">退出登录</a>
<hr>
<h3>课程学生</h3>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>学号</th>
        <th>姓名</th>
        <th>院系</th>
        <th>选课时间</th>
        <th>成绩</th>
    </tr>
    </thead>
    <form action="updateScore" method="post">
        <c:forEach items="${studentCourseList}" var="studentCourse" varStatus="status">
            <tr>
              <td>
                <input type="number"  name="scores[${status.index}].id"    value="${studentCourse.id}" readonly>
              </td>
              <td>
              <input type="number" min="0" max="100" name="scores[${status.index}].stuSno" readonly value="${studentCourse.stuSno}">
              </td>
                <td>${studentCourse.stuName}</td>
                <td>${studentCourse.stuDepartment}</td>
                <td>${studentCourse.createTime}</td>
                <td>
                    <input type="number" min="0" max="100" name="scores[${status.index}].courseScore"
                           value="${studentCourse.courseScore}">
                </td>
            </tr>
        </c:forEach>
      <br>
      <input type="submit" value="提交">
    </form>
</table>
</body>
</html>
