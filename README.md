# My VM Test

## To run MyVmTest-SVC 
1. Open command prompt and run below
   
        mvn spring-boot:run

2. To verify db details open h2 console by using below url

        http://localhost:8080/h2-console
    
    ### Use below Rest API 
    1. API to get File Processing Status by passing fileId
            HTTP Request TYPE :GET
            Url Param : fileId=1
            http://localhost:8080/employee/file/status?fileId=1
    2. API for Uploading File
            HTTP Request TYPE :POST
            form-data : file=location of file 
            http://localhost:8080/employee/file/uploadFile


## To run MyVmUI
1. Open my-vm-ui in command prompt

        npm install
   
2. To Start project
   
        npm start
   
3. Open http://localhost:4200 and Enter email as thrinod@test.com and password as 123456 to login the app

