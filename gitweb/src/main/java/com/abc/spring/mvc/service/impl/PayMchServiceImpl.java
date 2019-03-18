package com.abc.spring.mvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.spring.mvc.dao.PayMchDao;
import com.abc.spring.mvc.entity.PayMch;
import com.abc.spring.mvc.service.PayMchService;

@Service
public class PayMchServiceImpl implements PayMchService {

	private static Logger logger = LoggerFactory.getLogger(PayMchServiceImpl.class);
	
	@Autowired
	private PayMchDao payMchDao;
	
	@Override
	public List<PayMch> getList() {
		logger.info("com.abc.spring.mvc.dao.service.impl.PayMchServiceImpl.getList");
		return payMchDao.queryAll(0, 1000);
	}

}
