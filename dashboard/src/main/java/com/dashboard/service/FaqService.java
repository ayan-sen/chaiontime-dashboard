package com.dashboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.dashboard.model.Faq;
import com.dashboard.repository.FaqRepository;

@Service
public class FaqService {

	@Resource
	private FaqRepository faqRepository;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(Faq faq) {
		return faqRepository.add(faq);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public List<Faq> getAll() {
		return faqRepository.getAll();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Long deleteById(Long id) {
		return faqRepository.deleteById(id);
	}

	public Long update(Faq faq) {
		return faqRepository.update(faq);
	}
}
