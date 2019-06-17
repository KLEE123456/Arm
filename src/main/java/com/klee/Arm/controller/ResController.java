package com.klee.Arm.controller;

import com.github.pagehelper.PageInfo;
import com.klee.Arm.pojo.Res;
import com.klee.Arm.pojo.ResType;
import com.klee.Arm.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String findRes(Model model, Integer pageNum, String resName,HttpSession session,String method){
        //点击办公用品列表时,将session中的resNames赋值为null
        if (method!=null){
            session.setAttribute("resNames",null);
        }
        Map<String,Object> map=new HashMap<>();
        String resNames=(String) session.getAttribute("resNames");
        if (resName!=null){
            //将查询的内容放入session中
            session.setAttribute("resNames",resName);
            map.put("resName",resName);
        }
        else {
            //如果前端没有resName传过来，我们从session中取resName
            map.put("resName",resNames);
        }
        List<Res> resList = resService.findRes(pageNum,map);
        PageInfo pageInfo=new PageInfo(resList);
        model.addAttribute("resList",resList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("resName",resName);
        return "res/res_list";
    }
}
