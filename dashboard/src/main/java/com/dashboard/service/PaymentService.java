package com.dashboard.service;

import java.util.Date;

import javax.annotation.Resource;

import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dashboard.model.PaymentLog;
import com.dashboard.model.RequestContext;
import com.dashboard.repository.PaymentRepository;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class PaymentService {
	
	private static final Logger logger = Logger.getLogger(PaymentService.class);

	@Value("${razorpay.api.key}")
	private String apikey;
	
	@Value("${razorpay.api.secretkey}")
	private String secretKey;
	
	@Resource
	private RequestContext requestContext;
	
	@Resource
	private PaymentRepository paymentRepository;
	
	public Payment capture(String paymentId, String amount) {
		try {
			RazorpayClient razorpay = new RazorpayClient(apikey, secretKey);
			JSONObject captureRequest = new JSONObject();
			captureRequest.put("amount", amount); // Amount should be in paise 
			Payment payment = razorpay.Payments.capture(paymentId, captureRequest);
			return payment;
		} catch (RazorpayException e) {
			logger.error("Exception occurred in payment service", e);
		}
		return null;
	}
	
	public Long add(Long orderId, Payment payment) {
		PaymentLog paymentLog = new PaymentLog();
		paymentLog.setOrderId(orderId);
		paymentLog.setUserId(requestContext.getUser().getUserId());
		paymentLog.setMode(payment.get("method"));
		paymentLog.setPaymentDateTime(new Date());
		paymentLog.setAmount(Double.parseDouble(payment.get("amount"))/100);
		paymentLog.setSource("RAZORPAY");
		paymentLog.setSourcePaymentId(payment.get("id"));
		return paymentRepository.add(paymentLog);
	}
}
