package com.abc.spring.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.spring.mvc.entity.PayMch;
import com.abc.spring.mvc.service.PayMchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "支付商户")
@Controller
@RequestMapping("/payMch")
public class PayMchController {

	private static Logger logger = LoggerFactory.getLogger(PayMchController.class);

	@Autowired
	private PayMchService payMchService;

	@ApiOperation(value = "支付商户列表", httpMethod = "GET")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	private Object list() {

		logger.info("com.abc.spring.mvc.PayMchController.index ");

		List<PayMch> list = payMchService.getList();

		logger.info(list.toString());

		return list;
	}

	@ApiOperation(value = "根据id查询支付商户", httpMethod = "GET")
	@RequestMapping(value = "/queryPayMchById", method = RequestMethod.GET)
	@ResponseBody
	private Object queryPayMchById(Integer id) {

		logger.info("com.abc.spring.mvc.PayMchController.queryPayMchById id={} ",id);

		PayMch payMch = payMchService.getPayMchById(id);

		logger.info(payMch.toString());

		return payMch;
	}
}
