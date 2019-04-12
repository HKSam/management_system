<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
</head>
<body>
<%@include file="/view/inc/header.jsp" %>
<form method="POST" action="/lab06/admin?action=create">
    <h2>添加新用户</h2>
    用户名<br/>
    <input type="text" name="username" value="Tracker"><br/><br/>
    密码<br/>
    <input type="password" name="password" value="123"><br/><br/>

    Email地址<br/>
    <input type="text" name="email" value="trace@hotmail.com"><br/><br/>
    类型<br/>
    <select  name="role">
        <option value="0">管理员</option>
        <option value="1">普通用户</option>

    </select>
    <br/><br/>
    <input type="submit" value="提交"/>
</form>
<%@include file="/view/inc/footer.jsp"%>
</body>
</html>