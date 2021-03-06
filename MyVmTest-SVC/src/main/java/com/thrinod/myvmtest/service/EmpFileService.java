package com.thrinod.myvmtest.service;

import com.thrinod.myvmtest.model.EmpFile;

public interface EmpFileService {

    /**
     * Saves Emp File in DB
     * @param file
     * @return unique fileId
     */
     Long saveFile(EmpFile file);

    /**
     * Get File Processing Status by taking fileId
     * @param file
     * @return Status of processing
     */
     String getFileStatus(Long fileId);
}
