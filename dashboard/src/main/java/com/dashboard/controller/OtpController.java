package com.dashboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.service.OtpService;

@RestController
public class OtpController {

	@Resource
	private OtpService otpService;
	
	@PostMapping("/verify/otp")
	public ResponseEntity<Map<String, Object>> verifyOtp(@RequestBody Map<String, Object> map) {
		String entityId = (String) map.get("entityId");
		int otp = (Integer) map.get("otp");
		boolean verified = otpService.verify(entityId, otp);
		if(verified) {
			return new ResponseEntity<>(new HashMap<String, Object>(){{put("message", "OTP verification successful");
																	put("id", entityId);}}, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new HashMap<String, Object>(){{put("message", "OTP verification unsuccessful");
																	put("id", entityId);}}, HttpStatus.UNAUTHORIZED);
		}
	}
}
