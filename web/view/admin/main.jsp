<%@ page import="jee.customer.v2.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台主页</title>
</head>
<body>
<%@include file="/view/inc/header.jsp" %>
<ul>
    <li>
        <a href="/lab06/admin?action=list">用户管理</a>
    </li>
    <li><a href="/lab06/ticket">票据管理</a> </li>
    <li><a href="/lab06/user?action=view">个人中心</a> </li>
</ul>

</body>
</html>