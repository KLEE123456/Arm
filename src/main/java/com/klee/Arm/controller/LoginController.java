package com.klee.Arm.controller;

import com.klee.Arm.pojo.Emp;
import com.klee.Arm.service.LoginService;
import com.klee.Arm.utils.Md5Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping(value = "/doLogin/*")
public class LoginController{
    @Autowired
    private LoginService loginService;
    /**
     * 登录控制器方法
     * @param model
     * @param emp
     * @param session
     * @return
     */
    @RequestMapping(value = "login")
    public String login(Model model, Emp emp, HttpSession session){
        if(emp.getEid()==0||emp.getPassword()==null){

            model.addAttribute("msg","请先进行登录!");
            return "login";
        }
        String empPwd = emp.getPassword();
        emp.setPassword(Md5Encrypt.MD5(empPwd));
        Emp emp1=loginService.login(emp);
        if (emp1!=null){
            session.setAttribute("userMsg",emp1);
            return "back";
        }
        else {
            model.addAttribute("eid",emp.getEid());
            model.addAttribute("msg","雇员编号或密码错误!");
            return "login";
        }
    }
}
