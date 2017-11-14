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
	
	@GetMapping("/reports/salesreport")
	public List<Map<String, Object>> getSalesReport(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") Date fromDate,
													@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") Date toDate ) 
													throws ParseException {
		return reportService.getSalesReport(fromDate, toDate);
	}
}
