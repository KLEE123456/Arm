package com.klee.Arm.controller;

import com.klee.Arm.pojo.Details;
import com.klee.Arm.service.DetailsService;
import com.klee.Arm.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/details/*")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;
    @RequestMapping(value = "findDetail")
    public String findDetail(Model model){
        List<Details> detailsList = detailsService.findDetail();
        System.out.println(detailsList);
        model.addAttribute("detailsList",detailsList);
        return "res/res_prebuy";
    }
    @RequestMapping(value = "addDetail")
    public String addDetail(Model model, List<MultipartFile> fileupload, Details details, HttpServletRequest request){
        if (!fileupload.isEmpty()&&fileupload.size()>0){
            for (MultipartFile file:fileupload){
                String dirPath=request.getServletContext().getRealPath("/upload/det/");
                File filePath=new File(dirPath);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                String newFilename=Math.random()*100+".jpg";
                details.setPhoto("upload/det/"+newFilename);
                try{
                    file.transferTo(new File(dirPath+"/"+newFilename));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        int rows = detailsService.addDetail(details);
        if (rows>0){
            return "forward:findDetail.action";
        }
        else {
            model.addAttribute("error","Add failed!");
            return "res/res_add";
        }
    }
    @RequestMapping(value = "delDetals")
    public String delDetals(int[] ridArray, HttpServletResponse response) throws IOException {
        int rows = detailsService.delDetails(ridArray);
        if (rows>0){
            return "forward:findDetail.action";
        }
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("<script>alert('删除失败!');location.href='/details/findDetail.action'</script>");
            out.flush();
            out.close();
            return "";
        }
    }
    @RequestMapping(value = "findDetById")
    public  String findDetById(int did,Model model){
        Details details = detailsService.findDetById(did);
        model.addAttribute("details",details);
        return "res/res_edit";
    }
    @RequestMapping(value = "editDetail")
    public String editDetail(Details details,List<MultipartFile> fileupload,HttpServletRequest request,Model model) {
        if (!fileupload.isEmpty()&&fileupload.size()>0){
            for (MultipartFile file:fileupload){
                String dirPath=request.getServletContext().getRealPath("/upload/det/");
                File filePath=new File(dirPath);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                String newFilename=Math.random()*100+".jpg";
                details.setPhoto("upload/det/"+newFilename);
                try{
                    file.transferTo(new File(dirPath+"/"+newFilename));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        int rows = detailsService.editDetail(details);
        if (rows>0){
            return "forward:findDetail.action";
        }
        else {
            model.addAttribute("errorMsg","编辑失败!");
            return "res/res_edit";
        }
    }
}
