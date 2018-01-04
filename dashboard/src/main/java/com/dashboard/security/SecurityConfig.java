package com.dashboard.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DashboardUserDetailService dashboardUserDetailService;	
	
	@Autowired
	private AppAuthenticationEntryPoint appAuthenticationEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
			.and()
			.cors()
			.configurationSource(corsConfigurationSource())
			.and()
			.csrf()
			.disable()
		    .authorizeRequests().anyRequest().hasAnyRole("ADMIN","USER")
		    .antMatchers("/dashboard/connect").permitAll()
		    .antMatchers("/dashboard/**").hasAnyRole("ADMIN","USER")
		    .and().httpBasic().realmName("CHAIONTIME")
		    .authenticationEntryPoint(appAuthenticationEntryPoint)
		    .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/")
            .permitAll();
	} 
    
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                auth.userDetailsService(dashboardUserDetailService).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("origin", "content-type", "accept", "x-requested-with", "authorization", "file", "x-socketId"));
		configuration.setMaxAge(3600l);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
} 
