package com.dashboard.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		     AuthenticationException authException) throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
		response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
	    response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, authorization, file");
	    response.addHeader("Access-Control-Max-Age", "3600");
	    String requestHeaders = request.getHeader("Access-Control-Request-Headers");
	    if(requestHeaders != null) {
	    	response.addHeader("Access-Control-Allow-Headers", requestHeaders);
	    }
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("CHAIONTIME");
	}

}
