package com.abc.spring.mvc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

@Api(tags = "shiro")
@Controller
@RequestMapping("/shiro")
public class ShiroController {

	private static Logger logger = LoggerFactory.getLogger(ShiroController.class);
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	private Object index() {
		logger.info("com.abc.spring.mvc.controller.ShiroController.index");
		StringBuffer buffer = new StringBuffer();
		
		
		return buffer.toString();
	}
	
	@RequestMapping(value = "/quickstart", method = RequestMethod.GET)
	@ResponseBody
	private Object quickstart() {
		StringBuffer buffer = new StringBuffer();
		// The easiest way to create a Shiro SecurityManager with configured
        // realms, users, roles and permissions is to use the simple INI config.
        // We'll do that by using a factory that can ingest a .ini file and
        // return a SecurityManager instance:

        // Use the shiro.ini file at the root of the classpath
        // (file: and url: prefixes load from files and urls respectively):
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.properties");
        SecurityManager securityManager = factory.getInstance();

        // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.  That is outside the scope of this simple quickstart, so
        // we'll just do the bare minimum so you can continue to get a feel
        // for things.
        SecurityUtils.setSecurityManager(securityManager);

        // Now that a simple Shiro environment is set up, let's see what you can do:

        // get the currently executing user:
        Subject currentUser = SecurityUtils.getSubject();

        // Do some stuff with a Session (no need for a web or EJB container!!!)
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            logger.info("Retrieved the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
            //UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
        	//UsernamePasswordToken token = new UsernamePasswordToken("root", "secret");
            //UsernamePasswordToken token = new UsernamePasswordToken("guest", "guest");
            UsernamePasswordToken token = new UsernamePasswordToken("guest", "guest123456");
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

        //test a role:
        if (currentUser.hasRole("schwartz")) {
            logger.info("May the Schwartz be with you!");
        } else {
            logger.info("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level)
        if (currentUser.isPermitted("lightsaber:weild")) {
            logger.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            logger.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            logger.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            logger.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

		// all done - log out!
        currentUser.logout();
        
        return buffer.toString();
	}
}
