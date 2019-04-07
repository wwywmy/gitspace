package com.abc.spring.mvc.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionsBuilder {
	
	public LinkedHashMap<String,Object> buildFilterChainDefinitions(){
		
		LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();
		
		map.put("/login", "anon");
		map.put("/**", "authc");
		
		return map;
	}
}
