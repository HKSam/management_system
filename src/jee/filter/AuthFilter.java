package jee.filter;

import jee.customer.v2.WebCts;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        HttpServletResponse resp=(HttpServletResponse)response;
        HttpServletRequest req=(HttpServletRequest)request;

        HttpSession session =req.getSession();
        if(session.getAttribute(WebCts.LOGIN_USER)==null){
            System.out.println("发现非法访问");
            resp.sendRedirect("/lab06/login.jsp");

        }
        else{
            System.out.println("用户已经登录");
            chain.doFilter(request,response);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println(this.getClass().getName()+"启动成功!");
    }
    @Override
    public void destroy() { }
}
