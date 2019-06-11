package com.klee.Arm.controller;

import com.klee.Arm.pojo.Emp;
import com.klee.Arm.service.EmpService;
import com.klee.Arm.utils.FileUpload;
import com.klee.Arm.utils.Md5Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping(value = "/emp/*")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 管理员列表
     * @param model
     * @return
     */
    @RequestMapping(value = "findEmp")
    public String findEmp(Model model){
        List<Emp> empList = empService.findEmp();
        model.addAttribute("empList",empList);
        return "admin/admin_list";
    }

    /**
     * 编辑界面渲染
     * @param eid
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "XREmp")
    public String xREmp(int eid, Model model, HttpSession session){
        Emp emp = empService.xREmp(eid);
        session.setAttribute("password",emp.getPassword());
        model.addAttribute("emp",emp);
        return "emp/emp_edit";
    }

    /**
     * 雇员编辑
     * @param emp
     * @param uploadfile
     * @param request
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "editEmp")
    public String editEmp(Emp emp, List<MultipartFile> uploadfile, HttpServletRequest request,HttpSession session,Model model){
        FileUpload.fileUpload(uploadfile,emp,request);
        //拿到用户编辑后的密码，比较是否进行了更改
        String password=emp.getPassword();
        int rows;
        //如果没有进行进行更改,不需要对密码进行md5加密
        if (password.equals(session.getAttribute("password"))){
           rows=empService.editEmp(emp);
        }
        //如果用户更改了,则对密码进行md5加密
        else {
            emp.setPassword(Md5Encrypt.MD5(password));
            rows=empService.editEmp(emp);
        }
        //判断rows是否大于0
        if (rows>0){
            return  "forward:findEmp.action";
        }
        else {
            model.addAttribute("errorMsg","编辑失败,请于管理员联系!");
            return "emp/emp_edit";
        }
    }

    /**
     * 雇员编号检测
     * @param eid
     * @return
     */
    @RequestMapping(value = "checkEid")
    @ResponseBody
    public String checkEid(int eid){
        Emp emp = empService.xREmp(eid);
        if (emp==null){
            return "true";
        }
        else {
            return "false";
        }
    }

    /**
     * 新增管理员
     * @param emp
     * @return
     */
    @RequestMapping(value = "addAdm")
    public String addAdm(Emp emp,List<MultipartFile> uploadfile,Model model,HttpServletRequest request){
        FileUpload.fileUpload(uploadfile,emp,request);
        String password=emp.getPassword();
        emp.setPassword(Md5Encrypt.MD5(password));
        int rows=empService.addAdm(emp);
        if (rows>0){
            return "forward:findEmp.action";
        }
        else {
            model.addAttribute("addError","添加失败,请于管理员联系!");
            return "admin/admin_add";
        }
    }
}
