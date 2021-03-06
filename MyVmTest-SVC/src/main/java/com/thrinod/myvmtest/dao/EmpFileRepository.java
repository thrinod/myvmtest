package com.thrinod.myvmtest.dao;

import com.thrinod.myvmtest.model.EmpFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpFileRepository extends CrudRepository<EmpFile, Long> {

    @Query("SELECT e from EmpFile e where e.status =:status")
    List<EmpFile> findByStatus(@Param("status") String status);

}
