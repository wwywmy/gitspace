package com.abc.spring.mvc.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroRealm extends AuthenticatingRealm {

	private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("com.abc.spring.mvc.shiro.ShiroRealm.doGetAuthenticationInfo token={}",token);
		
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		String username= usernamePasswordToken.getUsername();
		
		AuthenticationInfo authenticationInfo = null;
		
		if("abc".equals(username)) {
			Object principal = username;
			//Object credentials = "123456";
			Object credentials = "e10adc3949ba59abbe56e057f20f883e";//123456 -md5->	e10adc3949ba59abbe56e057f20f883e
			String realmName = getName();
			authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, realmName);
		} else {
			throw new UnknownAccountException("用户不存在！");
		}
		
		return authenticationInfo;
	}

}
