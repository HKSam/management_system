package jee.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HandleDataServlet", urlPatterns = {"/register"})
public class HandleDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String username=request.getParameter("username");
   String password=request.getParameter("password");
   String email=request.getParameter("email");
   String cellphone=request.getParameter("cellphone");
   String place=request.getParameter("place");
   String comment=request.getParameter("comment");
   response.getWriter().println("姓名："+username+";密码："+password+
           ";email:"+email+";手机号码:"+cellphone+";居住地:"+place+";备注:"+comment);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
