package com.thrinod.myvmtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=false)
@ComponentScan(basePackages = "com.thrinod")
public class MyVmTestApplication {

	private static final Logger log = LoggerFactory.getLogger(MyVmTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyVmTestApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		File myObj = new File("C:\\Users\\T\\Downloads\\EmpTestData.txt");
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

//	}
}
