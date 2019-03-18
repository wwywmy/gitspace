package com.abc.spring.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.spring.mvc.entity.PayMch;
import com.abc.spring.mvc.service.PayMchService;

@Controller
@RequestMapping("/payMch")
public class PayMchController {

	private static Logger logger = LoggerFactory.getLogger(PayMchController.class);
	
	@Autowired
	private PayMchService payMchService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	private Object list() {
		
		logger.info("com.abc.spring.mvc.PayMchController.index ");
		
		List<PayMch> list = payMchService.getList();
		
		logger.info(list.toString());
		
		return list;
	}
}
