package com.thrinod.myvmtest.controller;


import com.thrinod.myvmtest.model.EmpFile;
import com.thrinod.myvmtest.service.EmpFileService;
import com.thrinod.myvmtest.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController("/")
public class MainController {
    @Autowired
    private EmpFileService empFileService;

    @Autowired
    private EmpService empService;

    @PostMapping("/employee/file/upload")
    public @ResponseBody
    String hello(@RequestParam("file") MultipartFile file)  throws Exception  {
        EmpFile empFile = new EmpFile();
        empFile.setFileName(file.getName());
        empFile.setData(file.getBytes());
        empFile.setStatus("UPLOADED");
        Long fileId = empFileService.saveFile(empFile);
        ExecutorService executorService =Executors.newFixedThreadPool(1);
        executorService.submit(() ->{
            empService.startSavingDataForFileId(empFile);
        });

        return  "File Id "+fileId+ " Uploaded successfully";
    }

    @GetMapping("/employee/file/status")
    public @ResponseBody String jobStatus(@RequestParam("fileId") String id){
        return empFileService.getFileStatus(Long.parseLong(id));
    }

    @GetMapping("/")
    public @ResponseBody String working(){
        return "Working";
    }

}
