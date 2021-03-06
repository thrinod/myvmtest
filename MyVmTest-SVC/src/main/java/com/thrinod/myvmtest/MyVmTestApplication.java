package com.thrinod.myvmtest;

import com.thrinod.myvmtest.dao.EmployeeRepository;
import com.thrinod.myvmtest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=false)
@ComponentScan(basePackages = "com.thrinod")
public class MyVmTestApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MyVmTestApplication.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyVmTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		File myObj = new File("C:\\Users\\K R Thrinod\\Downloads\\EmpTestData.txt");
//		FileWriter myWriter = new FileWriter(myObj);
//		BufferedWriter bw = new BufferedWriter(myWriter);
//
//		for (int i = 0; i < 400000; i++) {
//			bw.write("thrinod kr " + new Random().ints(15,80).findAny().getAsInt());
//			bw.newLine();
//			bw.write("vm ware "+ new Random().ints(15,80).findAny().getAsInt());
//			bw.newLine();
//			bw.write("Dell "+ new Random().ints(15,80).findAny().getAsInt());
//			bw.newLine();
//		}
//		myWriter.close();

	}
}
