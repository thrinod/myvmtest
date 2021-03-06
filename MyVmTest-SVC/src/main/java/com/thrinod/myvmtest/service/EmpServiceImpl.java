package com.thrinod.myvmtest.service;

import com.thrinod.myvmtest.dao.EmpFileRepository;
import com.thrinod.myvmtest.dao.EmployeeRepository;
import com.thrinod.myvmtest.model.EmpFile;
import com.thrinod.myvmtest.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    private static final Logger log = LoggerFactory.getLogger(EmpServiceImpl.class);

    public static final String COMPLETED = "COMPLETED";
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmpFileRepository empFileRepository;

    @Transactional (rollbackOn = Exception.class)
    public void startSavingDataForFileId(EmpFile empFile){
        if(COMPLETED.equals(empFile.getStatus())){
            return;
        }
        List<Employee> employees = new ArrayList<>();
        InputStream is = null;
        try {
            BufferedReader  bfReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(empFile.getData())));
            String line = bfReader.readLine();
            while(line != null){
                String[] lineArray = line.trim().split(" ");
                if( lineArray.length ==3){
                    Employee employee = new Employee(lineArray[0] + lineArray[1], Integer.parseInt(lineArray[2]));
//                    employeeRepository.save(employee);
                    employees.add(employee);
                }else  if (lineArray.length ==2){
                    Employee employee = new Employee(lineArray[0] , Integer.parseInt(lineArray[1]));
//                    employeeRepository.save(employee);
                    employees.add(employee);
                }else{
                    throw new Exception("Not In Valid Format");
                }
                log.info(line);
                line =bfReader.readLine();
                log.info(line +"==");
            }
            employeeRepository.saveAll(employees);
            empFile.setStatus(COMPLETED);
        } catch (Exception e) {
            e.printStackTrace();
            empFile.setStatus("FAILED");
        } finally {
            try{
                if(is != null) is.close();
            } catch (Exception ex){

            }
        }
        empFileRepository.save(empFile);
    }

}
