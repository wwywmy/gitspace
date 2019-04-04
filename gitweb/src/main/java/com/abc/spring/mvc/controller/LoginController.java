package com.abc.spring.mvc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String login() {
		
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String login(@RequestParam("username")String username,@RequestParam("password")String password) {
		logger.info("username={}",username);
		logger.info("password={}",password);
		
		
		
		Subject currentUser = SecurityUtils.getSubject();


        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                logger.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                logger.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                logger.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        logger.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
		
		//return "list";
        return "redirect:/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list() {
		
		
		return "list";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	private String user() {
		
		
		return "user";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	private String admin() {
		
		
		return "admin";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	private String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		return "redirect:/login";
	}
	
	
	
	
}
