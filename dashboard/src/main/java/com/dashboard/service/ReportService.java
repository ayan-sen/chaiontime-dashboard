package com.dashboard.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dashboard.repository.ReportRepository;

@Service
public class ReportService {

	@Resource
	private ReportRepository reportRepository;
	
	public List<Map<String, Object>> getSalesReportByPos(Date fromDate, Date toDate) throws ParseException {
		List<Object[]> reports = reportRepository.getSalesReportByPos(fromDate, toDate);
		return reports.stream().map(o -> new HashMap<String, Object>(){{put("x", o[0]);put("y", o[1]);}}).collect(Collectors.toList());
	}
	
	public List<Map<String, Object>> getSalesReportByProduct(Date fromDate, Date toDate) throws ParseException {
		List<Object[]> reports = reportRepository.getSalesReportByProduct(fromDate, toDate);
		return reports.stream().map(o -> new HashMap<String, Object>(){{put("x", o[0]);put("y", o[1]);}}).collect(Collectors.toList());
	}
	
	public List<Map<String, Object>> getSalesSummaryReport(Date fromDate, Date toDate) throws ParseException {
		List<Object[]> reports = reportRepository.getSalesSummaryReport(fromDate, toDate);
		return reports.stream().map(o -> new HashMap<String, Object>(){{put("x", o[0]);put("y", o[1]);}}).collect(Collectors.toList());
	}
}
