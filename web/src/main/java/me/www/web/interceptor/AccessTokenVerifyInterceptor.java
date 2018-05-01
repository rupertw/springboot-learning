package me.www.web.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: www
 * @date: 2018/5/1 17:12
 * @description: SpringMVC拦截器（可用于实现权限认证）
 */
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        /* // token
        String accessToken = request.getParameter("token");
        if (StringUtils.isNotBlank(accessToken)) {
            // 验证
            ValidationModel v = validationService.verifyAccessToken(accessToken);
            // 时间过期
 
            // 用户验证
            if (v != null) {
                User user = userService.findById(v.getUid());
                if (user != null) {
                    request.setAttribute(CommonConst.PARAM_USER, user);
                    LOG.info("AccessToken SUCCESS ...  user:" + user.getUserName() + " - " + accessToken);
                    flag = true;
                }
            }
        }*/
        if (!flag) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("AccessToken ERROR");
        }

        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
