package com.dashboard.service;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dashboard.model.EmailConfig;
import com.dashboard.model.Otp;
import com.dashboard.model.User;
import com.dashboard.repository.OtpRepository;

@Service
public class OtpService {

	@Resource
	private OtpRepository otpRepository;
	
	@Resource
	private EmailService emailService;
	
	@Value("${otp.email.enabled:true}")
	private boolean emailEnabled;
	
	@Value("${otp.sms.enabled:false}")
	private boolean smsEnabled;
	
	public boolean generateOtp(String entity, String entityType, User user) {
		Otp otp = new Otp(entity, entityType, user);
		otpRepository.generate(otp);
		email(otp);
		return true;
		
	}
	
	private void email(Otp otp) {
		EmailConfig config = new EmailConfig(Arrays.asList(otp.getEmail()), null, 
				null, "OTP generated for "+otp.getEntityType()+" #" + otp.getEntity(), otp.getEntityType() + " OTP is " + otp.getOtp());
		emailService.sendEmail(config);
	}
	
	public boolean verify(String entity, String entityType, int otp) {
		return otpRepository.verify(entity,entityType, otp);
	}
}
