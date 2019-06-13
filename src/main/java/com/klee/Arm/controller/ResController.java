package com.klee.Arm.controller;

import com.klee.Arm.pojo.Res;
import com.klee.Arm.pojo.ResType;
import com.klee.Arm.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/res/*")
public class ResController {
    @Autowired
    private ResService resService;
    @RequestMapping(value = "findResType")
    public  String  findResType(Model model){
        List<ResType> resTypeList = resService.findResType();
        model.addAttribute("resTypeList",resTypeList);
        return "type/type_list";
    }
    @RequestMapping(value = "findRes")
    public String findRes(Model model){
        List<Res> resList = resService.findRes();
        model.addAttribute("resList",resList);
        return "res/res_list";
    }
}
