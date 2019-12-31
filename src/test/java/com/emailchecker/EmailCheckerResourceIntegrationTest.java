package com.emailchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.emailchecker.model.EmailRequest;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EmailCheckerServiceApplication.class, 
webEnvironment = WebEnvironment.DEFINED_PORT)
public class EmailCheckerResourceIntegrationTest {
	
    // Test RestTemplate to invoke the APIs.
    private TestRestTemplate restTemplate = new TestRestTemplate();
    
	@Test
    public void testValidEmailCount() throws Exception {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		EmailRequest emailRequest = new EmailRequest();
		List<String> emails = new ArrayList<>();
		emailRequest.setEmails(emails);
		HttpEntity<EmailRequest> request = new HttpEntity<>(emailRequest,headers);
        ResponseEntity<String> responseValue = restTemplate.exchange("http://localhost:9091/email/check", HttpMethod.POST, request,String.class);
        assertEquals("{\"count\":0}", responseValue.getBody().toString());
    }
    
}
