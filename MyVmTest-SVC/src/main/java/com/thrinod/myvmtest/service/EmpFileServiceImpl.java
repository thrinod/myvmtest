package com.thrinod.myvmtest.service;

import com.thrinod.myvmtest.dao.EmpFileRepository;
import com.thrinod.myvmtest.model.EmpFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpFileServiceImpl implements EmpFileService {

    @Autowired
    private EmpFileRepository empFileRepository;

    @Override
    public Long saveFile(EmpFile file){
        EmpFile empFile = empFileRepository.save(file);
        return empFile.getFileId();
    }

    @Override
    public String getFileStatus(Long fileId){
        Optional<EmpFile> empFile =empFileRepository.findById(fileId);
        if(empFile.isPresent()){
            return empFile.get().getStatus();
        }
        return  "File Not Found";
    }

}
