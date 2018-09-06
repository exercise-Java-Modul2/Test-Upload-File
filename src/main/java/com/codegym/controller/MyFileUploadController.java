package com.codegym.controller;


import com.codegym.model.MyUploadForm;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class MyFileUploadController {

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver	= new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSizePerFile(10000000);
        return multipartResolver;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String uploadOneFileHandler(Model model) {
        MyUploadForm myUploadForm = new MyUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
        return "uploadOneFile";
    }

    @RequestMapping(value = "/uploadOneFile", method = RequestMethod.POST)
    public ModelAndView uploadOneFileHandlerPOST(@ModelAttribute("myUploadForm")MyUploadForm myUploadForm) {
        System.out.println("a = " + myUploadForm.getDescription());

        String path = "C:\\Users\\syphan\\IdeaProjects\\test-uploadfile-image\\src\\main\\webapp\\resource\\uploads\\";

        CommonsMultipartFile[] commonsMultipartFiles = myUploadForm.getFileDatas();
        try {
            for (CommonsMultipartFile multipartFile : commonsMultipartFiles) {
                FileCopyUtils.copy(multipartFile.getBytes(), new File(path + multipartFile.getOriginalFilename()));
                System.out.println(multipartFile.getOriginalFilename());
            }
        } catch (IOException e) {
            return new ModelAndView("/success");
        }
        return new ModelAndView("/success");
    }
}
