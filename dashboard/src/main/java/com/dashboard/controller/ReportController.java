package com.dashboard.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.service.ReportService;

@RestController
public class ReportController {

	@Resource
	private ReportService reportService;
	
	@GetMapping("/reports/salesreports/pos")
	public List<Map<String, Object>> getSalesReportByPos(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy'T'HH:mm:ss") Date fromDate,
													@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy'T'HH:mm:ss") Date toDate ) 
													throws ParseException {
		return reportService.getSalesReportByPos(fromDate, toDate);
	}
	
	@GetMapping("/reports/salesreports/product")
	public List<Map<String, Object>> getSalesReportByProduct(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy'T'HH:mm:ss") Date fromDate,
													@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy'T'HH:mm:ss") Date toDate ) 
													throws ParseException {
		return reportService.getSalesReportByProduct(fromDate, toDate);
	}
	
	@GetMapping("/reports/salesreports/summary")
	public List<Map<String, Object>> getSalesSummaryReport(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy'T'HH:mm:ss") Date fromDate,
													@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy'T'HH:mm:ss") Date toDate ) 
													throws ParseException {
		return reportService.getSalesSummaryReport(fromDate, toDate);
	}
}
