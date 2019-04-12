<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="jee.customer.v2.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%--使用JSTL标签库--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>中山领航科技有限公司客服系统</title>
</head>
<body>
<%@include file="/view/inc/header.jsp" %>
<h2>用户列表</h2>
<a href="/lab06/admin?action=create">添加新用户</a><br /><br />
<table border="1" cellspacing="0">

    <tr><th>序号</th><th>用户名</th><th>密码
</th><th>Email</th><th>注册时间</th> <th>注册IP</th>  <th>角色</th> <th>状态</th><th>操作</th></tr>
   <c:forEach items="${userList}" var="user" varStatus="s">
       <tr>
           <td># ${user.id}</td>
           <td>${user.username}</td>
           <td>${user.password}</td>
           <td>${user.email}</td>
           <td>
               <fmt:formatDate value="${user.registerDate}" pattern="yyyy年MM月dd日 hh:mm:ss"/>
           </td>
           <td>${user.registerIp}</td>
           <td>${user.role==0?"管理员":"普通用户"}</td>
           <td>${user.status==0?"未激活":"激活"}</td>
           <td>
               <a href="/lab06/admin?action=view&userId=${user.id}">详情</a>
               <a href="/lab06/admin?action=delete&userId=${user.id}">删除</a>
               <a href="/lab06/admin?action=active&userId=${user.id}">${user.status==0?"激活":"停用"}</a>
           </td>
       </tr>
   </c:forEach>
</table>
<%@include file="/view/inc/footer.jsp"%>
</body>
</html>

