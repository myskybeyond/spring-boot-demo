package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafDemo {

	private Logger logger = LogManager.getLogger(ThymeleafDemo.class);
    /**
     * 测试thymeleaf
     * @return
     */
    @RequestMapping(value = "/thymeleaf",method = RequestMethod.GET)
    public String hello(Model model) {
        logger.info("info");
        logger.error("error");
        logger.debug("debug");
        logger.warn("warn");
    	model.addAttribute("name", "Dear");
        return "index";
    }
}
