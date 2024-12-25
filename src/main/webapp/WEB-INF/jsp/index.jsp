<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>用户登录</title>
  <link href="css/s1.css" rel="stylesheet" type="text/css">
  <!-- 可以使用Bootstrap来增强样式和响应式设计 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container mt-5" id="login">
  <h3 class="text-center">用户登录</h3>
  <form action="login" method="post">
    <fieldset>
      <legend>登录信息</legend>
      <div class="mb-3">
        <label for="username" class="form-label">账号</label>
        <input type="text" id="username" name="username" class="form-control" required>
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">密码</label>
        <input type="password" id="password" name="password" class="form-control" required>
      </div>

      <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-primary">登录</button>
        <button type="reset" class="btn btn-secondary ms-2">重置</button>
      </div>

      <div class="text-center mt-3">
        <a href="startRegister">还没有账号？点击注册</a>
      </div>
    </fieldset>

    <div class="text-center mt-2">
      <span style="color: red;">${msg}</span>
    </div>
  </form>
</div>

<!-- Optional JavaScript -->
<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>
</html>
