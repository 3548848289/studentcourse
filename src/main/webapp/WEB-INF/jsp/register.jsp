<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>用户登录</title>
  <link href="css/s1.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="header.jsp"%>
<div id="register">
  <h3>用户注册</h3>
  <form action="register" method="post">
    <table>
      <tr>
        <td>账号</td>
        <td><input type="text" name="userName" required placeholder="请输入学号或工号"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="userPassword" required></td>
      </tr>
      <tr>
        <td>类型</td>
        <td>
          <select name="userType">
            <option>学生</option>
            <option>教师</option>
          </select>
        </td>
      </tr>
    <%--  <tr>
        <td>学号/工号</td>
        <td><input type="text" name="no" required></td>
      </tr>--%>
      <tr>
        <td>姓名</td>
        <td><input type="text" name="name" required></td>
      </tr>
      <tr>
        <td>院系</td>
        <td>
          <select name="depId">
            <c:forEach items="${departments}" var="dep">
              <option value="${dep.depId}">${dep.depName}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="注册">
          <input type="reset" value="重置">
        </td>
      </tr>
    </table>
  </form>
</div>
<span style="color: red;align-content: center">${msg}</span>
</body>
</html>
