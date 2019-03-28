package com.abc.spring.mvc.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import redis.clients.jedis.Jedis;

@Api(tags = "REDIS")
@Controller
@RequestMapping("/redis")
public class RedisController {

	private static Logger logger = LoggerFactory.getLogger(RedisController.class);


	@ApiOperation(value = "redis index", httpMethod = "GET")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	private Object index() {

		logger.info("com.abc.spring.mvc.RedisController.index ");
		
		Jedis jedis = new Jedis("192.168.9.129", 6379);
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(jedis.ping());
		
		jedis.set("k1", "v1");
		jedis.set("k2", "v2");
		jedis.set("k3", "v3");
		jedis.set("k4", "v4");
		
		String k5 = jedis.get("k5");
		
		buffer.append(k5);
		
		Set<String> set = jedis.keys("*");
		for(String s: set) {
			buffer.append(s+"="+jedis.get(s));
		}
		
		
		//jedis.disconnect();
		
		jedis.close();
		
		return buffer.toString();
	}

}
