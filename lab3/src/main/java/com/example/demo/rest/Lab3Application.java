package com.example.demo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.rest.filter.TokenFilter;

@SpringBootApplication
public class Lab3Application {

	@Bean
	public FilterRegistrationBean filterJwt() {
		FilterRegistrationBean filterRb = new FilterRegistrationBean();
		filterRb.setFilter(new TokenFilter());
		filterRb.addUrlPatterns("/private");
		filterRb.addUrlPatterns("/v1/products/{id}");
		filterRb.addUrlPatterns("/v1/products/");
		filterRb.addUrlPatterns("/v1/products/deleteAll");
		filterRb.addUrlPatterns("/v1/products/count");
		return filterRb;

	}

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

}
