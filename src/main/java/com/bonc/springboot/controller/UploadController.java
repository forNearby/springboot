package com.bonc.springboot.controller;

import com.bonc.springboot.entity.CommonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiush
 * @description
 * @create 2023-01-17 14:37
 */
@Controller
public class UploadController {

    @Autowired
    CommonConfig commonConfig;

    //访问http://localhost//upload_pre 显示upload.html页面
    @GetMapping("/upload_pre")
    public String uploadPre() { // 通过model可以实现内容的传递
        return "upload";
    }

    //upload
    @PostMapping("/upload")
    @ResponseBody
//    @RequestPart(value = "file")
    public Object upload(String name, @RequestPart(value = "file")MultipartFile photo) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (photo != null) {    // 现在有文件上传
            map.put("photo-name", photo.getOriginalFilename());
            //文件类型 content-type: "image/png",
            map.put("content-type", photo.getContentType());
            //文件大小
            map.put("photo-size", photo.getSize());

            //文件路径  位置 + 文件名
            String filePath = commonConfig.getFileUploadPath() + photo.getOriginalFilename();
            //文件路径
            map.put("photo-path", filePath);
            File saveFile = new File(filePath);
            // 文件保存
            photo.transferTo(saveFile);
            return map;
        } else {
            return "nothing";
        }
    }
}

