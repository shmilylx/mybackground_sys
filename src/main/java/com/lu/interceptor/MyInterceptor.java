package com.lu.interceptor;

import com.lu.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getRequestURI();
        if(requestURI.indexOf("login")!=-1||requestURI.indexOf("loginCheck")!=-1||requestURI.indexOf("clearSession")!=-1){
            return true;
        }else {
            HttpSession httpSession = httpServletRequest.getSession();
            UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
            System.out.println("111"+userInfo);
            if(userInfo==null){
                return false;
            }else {
                return true;
            }
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
