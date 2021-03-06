package com.abc.spring.mvc.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Api(tags = "REDISPool")
@Controller
@RequestMapping("/redisPool")
public class RedisPoolController {

	private static Logger logger = LoggerFactory.getLogger(RedisPoolController.class);

	@Autowired
	private JedisPool jedisPool;

	@ApiOperation(value = "redisPool index", httpMethod = "GET")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	private Object index() {

		logger.info("com.abc.spring.mvc.RedisPoolController.index ");
		
		StringBuffer buffer = new StringBuffer();
		
		Jedis jedis = jedisPool.getResource();
		
		jedis.set("k1_spring_redis", "v1_spring_redis");
		jedis.set("k2_spring_redis", "v2_spring_redis");
		jedis.set("k3_spring_redis", "v3_spring_redis");
		jedis.set("k4_spring_redis", "v4_spring_redis");
		
		
		Set<String> set = jedis.keys("*");
		for(String s: set) {
			buffer.append(s+"="+jedis.get(s));
		}
		
		
		//jedis.disconnect();
		
		
		
		return buffer.toString();
	}
	

}
