package com.dashboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.dashboard.model.Feedback;
import com.dashboard.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Resource
	private FeedbackRepository feedbackRepository;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(Feedback feedback) {
		return feedbackRepository.add(feedback);
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public List<Feedback> getByUserId(String userId) {
		return feedbackRepository.getByUserId(userId);
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public List<Feedback> getByOrderId(Long id) {
		return feedbackRepository.getByOrderId(id);
	}
}
