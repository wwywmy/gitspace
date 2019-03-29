package com.abc.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.spring.redis.dao.RedisDao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "REDISPool")
@Controller
@RequestMapping("/redisPool")
public class RedisPoolController {

	private static Logger logger = LoggerFactory.getLogger(RedisPoolController.class);

	@Autowired
	private RedisDao redisDao;

	@ApiOperation(value = "redisPool index", httpMethod = "GET")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	private Object index() {

		logger.info("com.abc.spring.mvc.RedisPoolController.index ");
		
		StringBuffer buffer = new StringBuffer();
		
		redisDao.set("k1_spring_redis", "v1_spring_redis");
		redisDao.set("k2_spring_redis", "v2_spring_redis");
		redisDao.set("k3_spring_redis", "v3_spring_redis");
		redisDao.set("k4_spring_redis", "v4_spring_redis");
		
		
		
		
		
		return buffer.toString();
	}
	

}
