package jee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="EncodingFilter")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 处理请求乱码
     HttpServletRequest httpRequest=(HttpServletRequest) req;
     HttpServletResponse httpResponse= (HttpServletResponse) resp;
     httpRequest.setCharacterEncoding("UTF-8");

     httpResponse.setCharacterEncoding("UTF-8");
     httpResponse.setContentType("text/html;charset=utf-8");
     chain.doFilter(req,resp);

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器:"+this.getClass().getName() +" 初始化完成!");
    }

}
