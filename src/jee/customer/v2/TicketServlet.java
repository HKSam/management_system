package jee.customer.v2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * date: 2019-3-14  第5周实验  用户登录和与JSP传值,数据层分离,EL表达式
 * author: hevean
 * 修改内容：实现控制器和页面的分离
 */
@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {

    TicketService ticketService = new TicketService();

    //处理Get类型HTTP请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //添加下面两行代码用于处理输出乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":   //添加新的票据记录
                this.toTicketForm(request, response);
                break;
            case "view":   //查看票据记录
                this.viewTicket(request, response);
                break;
            case "list":        //查看票据列表或者其他信息
            default:
                this.listTickets(request,response);
                break;
        }
    }

    //处理POST类型HTTP请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":
                this.createTicket(request, response);
                break;
            default:
                response.sendRedirect("ticket");
                break;
        }
    }

    //跳转创建票据的界面
    private void toTicketForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getContextPath()获取当前工程路径
        String dstUrl = "/view/addTicket.jsp";
        request.getRequestDispatcher(dstUrl).forward(request, response);
    }

    //根据id查看票据详情
    private void viewTicket(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        //获取票据id
        String idString = request.getParameter("ticketId");
        int id;
        try{
            id = Integer.parseInt(idString);
        }catch (Exception e){
            id=0;   //默认为0
        }
        Ticket ticket = ticketService.getTicket(id);

        request.setAttribute("ticket", ticket);
        //跳转到查看票据的页面
        request.getRequestDispatcher("/view/viewTicket.jsp")
                .forward(request,response );
    }

    //票据列表
    private void listTickets(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取数据,转发到jsp页面,进行渲染
        request.setAttribute("ticketList", ticketService.findAllTickets());
        request.getRequestDispatcher("/view/listTicket.jsp")
                .forward(request,response);
    }

    //将用户提交的票据数据写入数据库
    private void createTicket(HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户提交的数据,填充到ticket对象
        Ticket ticket = new Ticket();
        ticket.setCustomerName(request.getParameter("customerName"));
        ticket.setSubject(request.getParameter("subject"));
        ticket.setBody(request.getParameter("body"));
        String money = request.getParameter("money");
        ticket.setMoney(Double.parseDouble(money));
        String ticketType = request.getParameter("ticketType");
        ticket.setTicketType(ticketType);
        //调试用
        System.out.println(ticket);

        ticketService.addTicket(ticket);
        //重定向到票据详情页面
        response.sendRedirect("ticket?action=view&ticketId=" + ticket.getId());
    }

}
