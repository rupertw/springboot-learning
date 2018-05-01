package me.www.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: www
 * @date: 2018/5/1 18:23
 * @description: TODO
 */
@WebFilter(filterName = "loginFilter", urlPatterns = "/*"
        , initParams = {@WebInitParam(name = "exclusions", value = "/myservlet")})
public class MyFilter implements Filter {

    private String[] exclusiveReqUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urlsStr = filterConfig.getInitParameter("exclusions");
        exclusiveReqUrls = urlsStr.split(",");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String url = req.getRequestURI();
        boolean flag = false;
        for (int i = 0; i < exclusiveReqUrls.length; i++) {
            if (url.equals(exclusiveReqUrls[i])) {
                System.out.println("约定不拦截的请求直接放行==>" + url);
                flag = true;
                break;
            }
        }
        if (flag) {
            // 约定不拦截的请求直接放行
            chain.doFilter(request, response);
        } else {
            //进行拦截判断
           /* String userName = (String) session.getAttribute("userStr");
            if (userName != null) {
                chain.doFilter(request, response);//已经登录的请求放行
            } else {
                session.setAttribute("loginFlag", "no");
                res.sendRedirect("Login.jsp");
            }*/
            chain.doFilter(request, response);
        }
    }


    @Override
    public void destroy() {
        System.out.println("过滤器销毁了...");
    }

}
