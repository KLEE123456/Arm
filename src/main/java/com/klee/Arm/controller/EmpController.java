package com.klee.Arm.controller;

import com.klee.Arm.pojo.Emp;
import com.klee.Arm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/emp/*")
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping(value = "findEmp")
    public String findEmp(Model model){
        List<Emp> empList = empService.findEmp();
        model.addAttribute("empList",empList);
        return "admin/admin_list";
    }
    @RequestMapping(value = "XREmp")
    public String XREmp(int eid,Model model){
        Emp emp = empService.XREmp(eid);
        model.addAttribute("emp",emp);
        return "emp/emp_edit";
    }
}
