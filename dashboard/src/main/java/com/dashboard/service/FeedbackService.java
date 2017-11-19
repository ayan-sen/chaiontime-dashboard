package com.dashboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dashboard.model.Feedback;
import com.dashboard.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Resource
	private FeedbackRepository feedbackRepository;
	
	public Long add(Feedback feedback) {
		return feedbackRepository.add(feedback);
	}

	public List<Feedback> getByUserId(String userId) {
		return feedbackRepository.getByUserId(userId);
	}

	public List<Feedback> getByOrderId(Long id) {
		return feedbackRepository.getByOrderId(id);
	}
}
