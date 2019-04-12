package jee.customer.v2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * date: 2019-3-14  第5周实验  用户登录和与JSP传值,数据层分离,EL表达式
 * author: hevean
 * 修改内容：实现控制器和页面的分离
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    UserService userService = new UserService();

    //处理Get类型HTTP请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null)
            action = "main";
        switch (action) {
            case "update":   //更新个人信息
                this.toUserEditForm(request, response);
                break;
            case "view":   //查看用户记录
                this.viewUser(request, response);
            default:
                this.tomain(request, response);
                break;
        }
    }
    //跳转到用户中心主页
    private void tomain(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/view/user/userCenter.jsp")
                .forward(request, response);
    }


    //修改个人信息
    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        User user = (User)request.getSession().getAttribute(WebCts.LOGIN_USER);
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        userService.updateUser(user);
        //跳转到用户个人信息
        response.sendRedirect("/lab06/user?action=view");
    }



    //处理POST类型HTTP请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "update":   //更新个人信息
                this.update(request, response);
                break;
            default:
                response.sendRedirect("user");
                break;
        }
    }

    private void toUserEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //跳转编辑用户信息页面
        request.getRequestDispatcher("/view/user/editUser.jsp")
                .forward(request,response );
    }

    //根据id查看用户详情
    private void viewUser(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        //跳转到查看用户的页面
        request.getRequestDispatcher("/view/user/viewUser.jsp")
                .forward(request,response );
    }
}
