package com.klee.Arm.controller;

import com.klee.Arm.pojo.Dep;
import com.klee.Arm.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/dep/*")
public class DepController {
    @Autowired
    private DepService depService;
    @RequestMapping(value = "findDeps")
    public  String  findDeps(Model model){
        List<Dep> depList = depService.findDep();
        model.addAttribute("depList",depList);
        return "dept/dept_list";
    }
}
