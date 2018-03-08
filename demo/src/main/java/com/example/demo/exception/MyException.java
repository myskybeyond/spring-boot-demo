package com.example.demo.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

//@Configuration
public class MyException implements ErrorViewResolver{

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		// TODO Auto-generated method stub
		if(status.equals(HttpStatus.NOT_FOUND)){
			System.out.println("404");
		}
		if(status.equals(HttpStatus.INTERNAL_SERVER_ERROR)){
			System.out.println("500");
		}
		return new ModelAndView("error/404");
	}

}
