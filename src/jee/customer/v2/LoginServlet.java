package jee.customer.v2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//用户登录，使用自身数据库验证
//servlet url映射
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //首先判断字符串是否为空
        if(username!=null && password!=null
            && !username.isEmpty() && !password.isEmpty()){

            boolean bSuccess = false; //验证结果
            //根据用户名查找账号
            User user = userService.findByUsername(username);
            if(user!=null) {
                //验证密码
                if (user.getPassword().equals(password))
                    bSuccess = true;
                 else  bSuccess = false;

            }else {
                bSuccess = false;
            }
            //登录成功
            if (bSuccess){
                //将用户对象存在session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                //判断用户类型
                if (user.getRole()==WebCts.ROLE_ADMIN){
                    response.sendRedirect("/lab06/admin");
                }else if (user.getRole()==WebCts.ROLE_USER){
                    response.sendRedirect("/lab06/user");
                }
            }
            else {
                //
                request.setAttribute("msg", "用户名或者密码错误,请重新输入");
                request.getRequestDispatcher("/view/login.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //只处理POST请求
    }
}
