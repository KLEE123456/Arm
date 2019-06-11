package com.klee.Arm.interceptor;

import com.klee.Arm.pojo.Emp;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url=request.getRequestURI();
        if (url.indexOf("login")!=-1){
            return  true;
        }
        else if(url.indexOf("register")!=-1){
            return true;
        }
        else if (url.indexOf("toRegister")!=-1){
            return true;
        }
        else  if (url.indexOf("checkEid")!=-1){
            return true;
        }
        else  if (url.indexOf("srand")!=-1){
            return true;
        }
        else {
            HttpSession session=request.getSession();
            Emp emp=(Emp) session.getAttribute("userMsg");
            if (emp==null){
                request.setAttribute("msg","您还没有进行登录,请先登录!");
                request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
                return  false;
            }
            else {
                return true;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
