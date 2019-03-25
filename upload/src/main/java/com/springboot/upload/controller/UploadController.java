package com.springboot.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 上传文件控制器
 * 直接上传到服务器
 */

@Controller
public class UploadController {
    //指定一个临时路径作为上传目录
    private static String UPLOAD_FOLDER = "E:/temp/";

    //遇到http：//localhost：8080，则跳转到upload.html
    @GetMapping("/")
    public String index(){
        return "/upload";
    }

    @PostMapping("/upload")
    public String filUpload(@RequestParam("file")MultipartFile srcFile, RedirectAttributes redirectAttributes){
        if(srcFile.isEmpty()){
            redirectAttributes.addFlashAttribute("message","请选择一个文件");
            return "redirect:upload_status";
        }
        //选择了文件，开始进行上传操作
        try{
            //根据srcFile得大小，准备一个字节数组
            byte[] bytes = srcFile.getBytes();
            //拼接上传路径
            Path path= Paths.get(UPLOAD_FOLDER+srcFile.getOriginalFilename());
            //最重要得一步，将源文件写入目标地址
            Files.write(path,bytes);
            //将文件上传成功得信息写入message
            redirectAttributes.addFlashAttribute("message","文件上传成功！"+srcFile.getOriginalFilename());

        }catch (IOException e){
            e.printStackTrace();
        }
        return "/redirect:upload_status";
    }

    //匹配upload_status页面
    @GetMapping("/upload_status")
    public String uploadStatusPage(){
        return "upload_status";
    }
}
