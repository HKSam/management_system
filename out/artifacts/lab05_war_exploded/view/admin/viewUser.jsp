<%@ page import="jee.customer.v2.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
</head>
<body>
<%@include file="/view/inc/header.jsp" %>
<i>用户ID #${userId}: ${user.id}</i><br/><br/>
<i><strong>用户名:</strong> ${user.username}</i>

<p><strong>密码:</strong> ${user.password}
<p>
<p><strong>注册IP:</strong>  ${user.registerIp}<p>

<b><strong>注册时间:</strong> ${user.registerDate}<br/><br/>
<p><strong>状态:</strong>  ${user.status}<p>
<p><strong>角色:</strong>  ${user.role}<p>
        <a href="/lab06/admin?action=list">返回用户列表 </a>
        <%@include file="/view/inc/footer.jsp" %>
</body>
</html>