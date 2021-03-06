package com.klee.Arm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.klee.Arm.pojo.Emp;
import com.klee.Arm.service.EmpService;
import com.klee.Arm.utils.FileUpload;
import com.klee.Arm.utils.Md5Encrypt;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    public String findEmp(Model model,Integer pageNum){
        List<Emp> empList = empService.findAdm(pageNum);
        PageInfo pageInfo=new PageInfo(empList);
        model.addAttribute("empList",empList);
        model.addAttribute("pageInfo",pageInfo);
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
    public String xREmp(int eid, Model model, HttpSession session,String method,Integer pageNum){
        Emp emp = empService.xRAdm(eid);
        session.setAttribute("password",emp.getPassword());
        session.setAttribute("pageNum",pageNum);
        model.addAttribute("emp",emp);
        if (method==null){
            //回填到雇员编辑界面
            return "emp/emp_edit";
        }
        else {
            //回填到管理员编辑界面
            return "admin/admin_edit";
        }
    }

    /**
     * 管理员、雇员编辑
     * @param emp
     * @param uploadfile
     * @param request
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "editEmp")
    public String editEmp(Emp emp, List<MultipartFile> uploadfile, HttpServletRequest request,Model model,String method,HttpSession session){
        FileUpload.fileUpload(uploadfile,emp,request);
        //拿到session中的页码
        Integer pageNum=(Integer) session.getAttribute("pageNum");
        //拿到用户编辑后的密码，比较是否进行了更改
        String password=emp.getPassword();
        int rows;
        //如果没有进行进行更改,不需要对密码进行md5加密
        if (password.equals(session.getAttribute("password"))){
           rows=empService.editAdm(emp);
        }
        //如果用户更改了,则对密码进行md5加密
        else {
            emp.setPassword(Md5Encrypt.MD5(password));
            rows=empService.editAdm(emp);
        }
        //判断rows是否大于0
        if (rows>0){
            //如何修改的是登录雇员，则应该对存放登录雇员的session的值进行同步更改
            Emp emp1=(Emp) session.getAttribute("userMsg");
            if (emp.getEid()==emp1.getEid()){
                session.setAttribute("userMsg",emp);
            }
            if (method==null){
                //转发到雇员列表
                return  "forward:findEmps.action?pageNum="+pageNum;
            }
            else {
                //转发到管理员列表
                return "forward:findEmp.action?pageNum="+pageNum;
            }
        }
        else {
            if (method.equals("adminEdit")){
                model.addAttribute("errorMsg","编辑失败,请于管理员联系!");
                //返回到管理员编辑界面
                return "admin/admin_edit";
            }
            else {
                model.addAttribute("errorMsg","编辑失败,请于管理员联系!");
                //返回到雇员编辑界面
                return "emp/emp_edit";
            }

        }
    }

    /**
     * 编号检测
     * @param eid
     * @return
     */
    @RequestMapping(value = "checkEid")
    @ResponseBody
    public String checkEid(int eid){
        Emp emp = empService.xRAdm(eid);
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
            return "forward:findEmp.action?pageNum=1";
        }
        else {
            model.addAttribute("addError","添加失败,请于管理员联系!");
            return "admin/admin_add";
        }
    }

    /**
     * 雇员列表
     * @param model
     * @return
     */
    @RequestMapping(value = "findEmps")
    public  String  findEmps(Model model,Integer pageNum){
        List<Emp> empList = empService.findEmp(pageNum);
        PageInfo pageInfo=new PageInfo(empList);
        model.addAttribute("empList",empList);
        model.addAttribute("pageInfo",pageInfo);
        return "emp/emp_list";
    }

    /**
     * 新增雇员
     * @param emp
     * @param uploadfile
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "addEmps")
    public String addEmps(Emp emp,List<MultipartFile> uploadfile,Model model,HttpServletRequest request){
        FileUpload.fileUpload(uploadfile,emp,request);
        String password = emp.getPassword();
        emp.setPassword(Md5Encrypt.MD5(password));
        int rows = empService.addEmp(emp);
        if (rows>0){
            return "forward:findEmps.action?pageNum=1";
        }
        else {
            model.addAttribute("addError","添加失败,请于管理员联系!");
            return "emp/emp_add";
        }
    }

    /**
     * 管理员删除
     * @param eid
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "delAdm")
    public String delAdm(int eid, HttpServletResponse response,Integer pageNum) throws IOException {
        int rows = empService.delEmp(eid);
        if (rows>0){
            return "forward:findEmp.action?pageNum="+pageNum;
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("<script>alert('删除失败!');location.href='/emp/findEmp.action?pageNum="+pageNum+"'</script>");
            out.flush();
            out.close();
            return "";
        }
    }

    /**
     * 雇员删除
     * @param eid
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "delEmp")
    public String delEmp(int eid, HttpServletResponse response,Integer pageNum) throws IOException {
        int rows = empService.delEmp(eid);
        if (rows>0){
            return "forward:findEmps.action?pageNum="+pageNum;
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("<script>alert('删除失败!');location.href='/emp/findEmps.action?pageNum="+pageNum+"'</script>");
            out.flush();
            out.close();
            return "";
        }
    }

    /**
     * 查找eid
     * @param model
     * @return
     */
    @RequestMapping(value = "findEid")
    public String findEid(Model model,String method){
        //获取到最大的雇员的编号
        int eid = empService.findEid();
        System.out.println(eid);
        //创建新增雇员编号
        eid=eid+1;
        model.addAttribute("eid",eid);
        if (method==null){
            return "admin/admin_add";
        }
        else {
            return "emp/emp_add";
        }
    }

}
