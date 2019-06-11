package com.klee.Arm.utils;

import com.klee.Arm.pojo.Emp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * 文件上传类
 */
public class FileUpload {
    public static void fileUpload(List<MultipartFile> uploadfile, Emp emp, HttpServletRequest request){
        if (!uploadfile.isEmpty()&&uploadfile.size()>0){
            for (MultipartFile file:uploadfile){
                String dirPath=request.getServletContext().getRealPath("/upload/emp/");
                File filePath=new File(dirPath);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                String newFilename=emp.getEid()+".jpg";
                emp.setPhoto("upload/emp/"+newFilename);
                try{
                    file.transferTo(new File(dirPath+"/"+newFilename));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
