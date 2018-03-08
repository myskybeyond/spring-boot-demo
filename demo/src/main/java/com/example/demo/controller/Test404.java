package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test404 {
	
	@RequestMapping("error404")
	public String error404(){
		return "404";
	}
	
	@RequestMapping("error500")
	public String error500(){
		return "500";
	}
}
