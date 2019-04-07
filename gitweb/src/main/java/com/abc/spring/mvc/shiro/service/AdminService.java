package com.abc.spring.mvc.shiro.service;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminService {
	
	private static Logger logger = LoggerFactory.getLogger(AdminService.class);
	
	@RequiresRoles(value= {"admin"})
	public void toPortal() {
		logger.info("com.abc.spring.mvc.shiro.service.AdminService.toPortal()");
	}
}
