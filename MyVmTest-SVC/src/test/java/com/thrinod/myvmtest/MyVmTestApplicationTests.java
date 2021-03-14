package com.thrinod.myvmtest;

import com.thrinod.myvmtest.controller.MainController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyVmTestApplicationTests {

	@Autowired
	private MainController controller;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	ResourceLoader resourceLoader;

	@Test
	public void testAppWorking() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Working");
	}
	@Test
	public void getFileStatus() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/employee/file/status?fileId=1",
				String.class)).contains("File Not Found");
	}


	@Test
    public void uploadFile() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		Resource resource = resourceLoader.getResource("classpath:EmpTestData.txt");
		body.add("file", resource);
		HttpEntity<MultiValueMap<String, Object>> requestEntity	= new HttpEntity<>(body, headers);
		ResponseEntity<String> response =this.restTemplate.exchange(
				"http://localhost:" + port + "/employee/file/upload",
				HttpMethod.POST,
				requestEntity,String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		System.out.println(response.getBody());
		assertThat(response.getBody()).contains("Uploaded successfully");
    }

}
