package com.ispan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ispan.model.AuthUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
    AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bcryptEncoder, AuthUserDetailsService userDeatilService) throws Exception {
    	return http.getSharedObject(AuthenticationManagerBuilder.class)
    			.userDetailsService(userDeatilService)
    			.passwordEncoder(bcryptEncoder)
    			.and()
    			.build();
    }
	
	@Primary @Bean
	public AuthUserDetailsService userDetailsService() {
		return new AuthUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return 
		  http
		  .authorizeHttpRequests()
		  .requestMatchers(HttpMethod.GET, "/users/**").authenticated()
		  .requestMatchers(HttpMethod.GET).permitAll()
		  .requestMatchers(HttpMethod.POST, "/users/**").authenticated()
		  .requestMatchers(HttpMethod.POST).permitAll()
		  .anyRequest().authenticated()
		  .and()
		  .rememberMe().tokenValiditySeconds(86400).key("remember-Me")
		  .and()
		  .cors().disable()
		  .csrf().disable()
		  .formLogin().loginPage("/login/page")
		  .defaultSuccessUrl("/login/welcome")
		  .and()
		  .build();
	}
	
}