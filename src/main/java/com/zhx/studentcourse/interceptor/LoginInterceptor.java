package com.zhx.studentcourse.interceptor;

import com.zhx.studentcourse.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            System.out.println("---通过登录拦截器检查---当前用户="+user.getUserName());
            return true;
        }else{
            System.out.println("---未通过登录拦截器检查---用户未登录");
            request.setAttribute("msg","您尚未登录，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("-------Login Interceptor postHandle-----");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("-------Login Interceptor afterCompletion-----");
    }
}
