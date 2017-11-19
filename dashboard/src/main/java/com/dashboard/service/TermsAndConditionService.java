package com.dashboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.dashboard.model.TermsAndCondition;
import com.dashboard.repository.TermsAndConditionRepository;

@Service
public class TermsAndConditionService {

	@Resource
	private TermsAndConditionRepository termsAndConditionRepository;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(TermsAndCondition termsAndCondition) {
		return termsAndConditionRepository.add(termsAndCondition);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public List<TermsAndCondition> getAll() {
		return termsAndConditionRepository.getAll();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Long deleteById(Long id) {
		return termsAndConditionRepository.deleteById(id);
	}
}
