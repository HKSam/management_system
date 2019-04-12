<%@ page import="jee.customer.v2.Ticket" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hevean
  Date: 2019/3/17
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>中山领航科技有限公司客服系统</title>
</head>
<%
    //获取票据数据库
   List<Ticket> ticketList =
            (List<Ticket>) request.getAttribute("ticketList");
%>

<body>
<%@include file="/view/inc/header.jsp" %>
<h2>票据列表</h2>
<a href="/lab06/ticket?action=create">添加新票据</a><br /><br />

<%
    if(ticketList.size() == 0)
    {
        out.println("目前系统没有任何票据!<p>");
    }
    else
    {
%>
<table border="1" cellspacing="0"><tr><th>序号</th><th>主题</th><th>客户名称
</th><th>类型</th><th>金额</th><th>操作</th></tr>
    <%
            //按照指定格式输出表单信息
            for(Ticket ticket : ticketList)
            {
                out.println("<tr>");
                out.println("<td>Ticket #" + ticket.getId() +"</td>");
                out.println("<td>" + ticket.getSubject() +"</td>");
                out.println("<td>"+ ticket.getCustomerName() +"</td>");
                out.println("<td>"+ ticket.getTicketType() +"</td>");
                out.println("<td>"+ ticket.getMoney() +"</td>");
                out.println("<td><a href=\"/lab06/ticket?action=view&ticketId="
                        +ticket.getId() +"\">详情</a>");
                out.println("<a href=\"/lab06/ticket?action=delete&ticketId="
                        +ticket.getId() +"\">删除</a></td>");
                out.println("</tr>");
            }
        }
    %>
</table>
<%@include file="/view/inc/footer.jsp"%>
</body>
</html>

