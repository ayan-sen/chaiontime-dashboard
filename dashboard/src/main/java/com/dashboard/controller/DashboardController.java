//package com.dashboard.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class DashboardController {
//
//		
//	@RequestMapping("/hello")
//    public List<Map<String, Object>> index() {
//		
//		List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT ID,NAME FROM users");
//		
//        return users;
//        
//        
//    }
//	
//}
