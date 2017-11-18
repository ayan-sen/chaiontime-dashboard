package com.dashboard.service;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.dashboard.model.EmailConfig;
import com.dashboard.util.ExpressionEvaluator;

@Service
public class EmailService {

	@Resource
	private JavaMailSender javaMailSender;
	
	@Resource
	private ApplicationContext applicationContext;
	
	private static final Logger logger = Logger.getLogger(EmailService.class);
	
	public void sendEmail(EmailConfig config) {
		
		MimeMessagePreparator preparator = mimeMessage -> {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
			message.setTo(config.getTo().toArray(new String[config.getTo().size()]));
			message.setCc(config.getCc().toArray(new String[config.getCc().size()]));
			message.setBcc(config.getBcc().toArray(new String[config.getBcc().size()]));
			message.setSubject(evaluate(config.getSubject(), config.getModel()));
			message.setText(evaluate(config.getBody(), config.getModel()), true);
		};
		javaMailSender.send(preparator);
	}
	
	public String evaluate(String expression, Map<String, Object> model) {
		if(StringUtils.endsWithIgnoreCase(expression, ".st")) {
			return evaluateFromClassPath(expression, model);
		} else {
			return new ExpressionEvaluator().evaluate(expression, model);
		}
	}
	
	public String evaluateFromClassPath(String expression, Map<String, Object> model) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(applicationContext.getResource("classpath:" + expression).getInputStream());
			return new ExpressionEvaluator().evaluate(scanner.useDelimiter("\\A").next(), model);
		} catch (IOException e) {
			logger.error("Unable to evaluate expression");
		} finally {
			scanner.close();
		}
		return "";
	}
	
}
