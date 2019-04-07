package com.abc.spring.mvc.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroAuthRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(ShiroAuthRealm.class);
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("com.abc.spring.mvc.shiro.ShiroAuthRealm.doGetAuthenticationInfo token={}",token);
		
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		String username= usernamePasswordToken.getUsername();
		
		AuthenticationInfo authenticationInfo = null;
		
		if("admin".equals(username)) {
			Object principal = username;
			//Object credentials = "123456";
			Object credentials = "e10adc3949ba59abbe56e057f20f883e";//123456 -md5->	e10adc3949ba59abbe56e057f20f883e
			String realmName = getName();
			authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, realmName);
		} else if("user".equals(username)) {
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

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("com.abc.spring.mvc.shiro.ShiroAuthRealm.doGetAuthorizationInfo principals={}",principals);
		
		Object primaryPrincipal = principals.getPrimaryPrincipal();
		
		Set<String> roles = new HashSet<String>();
		roles.add("user");
		
		if("admin".equals(primaryPrincipal)) {
			roles.add("admin");
		}
		
		AuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);
		
		return authorizationInfo;
	}

}
