package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/error")
public class ExceptionController implements ErrorController {

	private final static Logger logger = LogManager.getLogger(ExceptionController.class);

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		logger.info("出错啦！进入自定义错误控制器");
		return "error/error";
	}

	@RequestMapping
	public String error() {
		return getErrorPath();
	}

}
