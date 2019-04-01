package com.abc.spring.mvc.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	private String index() {
		
		logger.info("com.abc.spring.mvc.IndexController.index 当前时间:{}",new Date());
		
		return "springmvc";
	}
	
	
	
	@RequestMapping(value = "/unauth", method = RequestMethod.GET)
	private String unauth() {
		
		
		return "unauth";
	}
	
	
	
}
