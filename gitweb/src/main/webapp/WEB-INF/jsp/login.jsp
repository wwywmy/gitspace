<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<h2>Login Page</h2>
	
	<form action="/login" method="post">
		<ul>
			<li><label>username</label><input type="text" id="username" name="username" value="admin"/></li>
			<li><label>password</label><input type="password" id="password" name="password" value="123456"/></li>
		</ul>
		<input type="submit" value="login"/>
	</form>
</body>
</html>