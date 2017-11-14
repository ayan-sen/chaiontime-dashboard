package com.dashboard.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dashboard.repository.ReportRepository;

@Service
public class ReportService {

	@Resource
	private ReportRepository reportRepository;
	
	public List<Map<String, Object>> getSalesReport(Date fromDate, Date toDate) throws ParseException {
		return reportRepository.getSalesReport(fromDate, toDate);
	}
}
