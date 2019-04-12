package jee.customer.v2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * date: 2019-3-14  第6周实验  用户登录和与JSP传值,数据层分离,JSTL和过滤器
 * author: hevean
 * 修改内容：实现控制器和页面的分离
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    UserService userService = new UserService();

    //处理Get类型HTTP请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //此处无须处理乱码
        String action = request.getParameter("action");
        if (action == null)
            action = "tomain";
        switch (action) {
            case "create":   //添加新的用户记录
                this.toUserForm(request, response);
                break;
            case "view":   //查看用户记录
                this.viewUser(request, response);
                break;
            case "delete":   //删除用户
                this.deleteUser(request, response);
                break;
            case "active":   //激活或者停用
                this.activeUser(request, response);
                break;
            case "tomain":   //跳转到后台主页
                this.tomain(request, response);
                break;
            case "list":        //查看用户列表或者其他信息
            default:
                this.listUsers(request,response);
                break;
        }
    }

    private void activeUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String idString = request.getParameter("userId");
        int id;
        try{
            id = Integer.parseInt(idString);
        }catch (Exception e){
            id=0;   //默认为0
        }
        User user = userService.getUser(id);

        if(user.status==WebCts.ACTIVE) {
            user.setStatus(WebCts.NO_ACTIVE);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/view/admin/viewUser.jsp")
                    .forward(request,response );

        }
        else {
            user.setStatus(WebCts.ACTIVE);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/view/admin/viewUser.jsp")
                    .forward(request,response );

        }


    }

    private void deleteUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

        String idString = request.getParameter("userId");
        int id;
        try{
            id = Integer.parseInt(idString);
        }catch (Exception e){
            id=0;   //默认为0
        }
        User user = userService.delUser(id);
        request.setAttribute("user", user);
        //跳转到查看用户的页面
        request.getRequestDispatcher("/view/admin/viewUser.jsp")
                .forward(request,response );
    }

    private void tomain(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/view/admin/main.jsp")
        .forward(request, response);
    }

    //处理POST类型HTTP请求
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":
                this.createUser(request, response);
                break;
            default:
                response.sendRedirect("admin");
                break;
        }
    }

    //跳转创建用户的界面
    private void toUserForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.getContextPath()获取当前工程路径
        String dstUrl = "/view/admin/addUser.jsp";
        request.getRequestDispatcher(dstUrl).forward(request, response);
    }

    //根据id查看用户详情
    private void viewUser(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户id
        String idString = request.getParameter("userId");
        int id;
        try{
            id = Integer.parseInt(idString);
        }catch (Exception e){
            id=0;   //默认为0
        }
        User user = userService.getUser(id);

        request.setAttribute("user", user);
        //跳转到查看用户的页面
        request.getRequestDispatcher("/view/admin/viewUser.jsp")
                .forward(request,response );
    }

    //用户列表
    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取数据,转发到jsp页面,进行渲染
        request.setAttribute("userList",userService.findAllUsers());
        request.getRequestDispatcher("/view/admin/listUser.jsp").forward(request,response);
 
    }

    //将用户提交的用户数据写入数据库
    private void createUser(HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户提交的数据,填充到user对象
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        String roleStr =request.getParameter("role");
        user.setRole(Integer.parseInt(roleStr));
        user.setEmail(request.getParameter("email"));
        user.setRegisterDate(new Date());
        user.setRegisterIp(request.getRemoteAddr());
        user.setStatus(1); //激活状态

        //调试用
        System.out.println(user);
        userService.addUser(user);
        //重定向到用户详情页面
        response.sendRedirect("admin?action=view&userId=" + user.getId());
    }
}
