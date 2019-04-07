<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix ="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
	<h2>List Page</h2>
	<h4>welcome <shiro:principal/></h4>
	
	<shiro:hasRole name="user">
	<div>
		<a href="/user">user</a>
	</div>
	</shiro:hasRole>
	<shiro:hasRole name="admin">
	<div>
		<a href="/admin">admin</a>
	</div>
	</shiro:hasRole>
	<br/>
	<br/>
	<div>
		<a href="/adminPortal">admin portal</a>
	</div>
	
	<a href="/logout">logout</a>
</body>
</html>