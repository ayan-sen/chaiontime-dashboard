package com.dashboard.service;

import java.util.Arrays;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dashboard.model.Sms;
import com.dashboard.model.SmsDetails;
import com.dashboard.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SmsService {
	
	@Value("${chaiontime.sms.api}")
	private String smsApiUrl;

	@Value("${chaiontime.sms.authKey}")
	private String smsAuthKey;
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(SmsService.class);
	
	public void sendSms(SmsDetails smsDetails) {
		
		Sms sms = new Sms(Arrays.asList(smsDetails));
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String payload = objectMapper.writeValueAsString(sms);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
			headers.add("authkey", smsAuthKey);
			
			HttpEntity<?> httpEntity = new HttpEntity<Object>(payload, headers);
			Object response = restTemplate.exchange(smsApiUrl, HttpMethod.POST, httpEntity, Object.class);
			
		} catch (Exception e) {
			logger.error("Exception occurred in sms service.", e);
		}
	}
	
	public void sendSms(User user, String message) {
		SmsDetails smsDetails = new SmsDetails(message, Arrays.asList(user.getPhone()));
		sendSms(smsDetails);
	}
	
	public void sendSms(String userId, String message) throws ObjectNotFoundException {
		User user = userService.getById(userId);
		SmsDetails smsDetails = new SmsDetails(message, Arrays.asList(user.getPhone()));
		sendSms(smsDetails);
	}

}
