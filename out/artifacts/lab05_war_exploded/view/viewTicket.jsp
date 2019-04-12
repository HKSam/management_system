<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加票据</title>
</head>
<body>
<%@include file="/view/inc/header.jsp" %>
<i>Ticket #${ticketId}: ${ticket.subject}</i><br/><br/>
<i><strong>客户姓名:</strong> ${ticket.customerName}</i>

<p><strong>票据种类:</strong> ${ticket.ticketType}
<p>
<p><strong>总金额:</strong>  ${ticket.money}<p>

    <b><strong>内容:</strong> ${ticket.body}<br/><br/>

        <a href="/lab06/ticket">返回票据列表 </a>
        <%@include file="/view/inc/footer.jsp" %>
</body>
</html>