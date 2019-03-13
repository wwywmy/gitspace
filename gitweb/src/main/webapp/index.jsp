<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>index</title>
</head>
<body>
	<h2>Hello Git WEB Project</h2>
	<h2><%=new java.util.Date()%></h2>
	<div>local->github->linux server</div>
	<div style="color: #ececec">tomcat 18080</div>
	<div>tomcat 18081</div>
	<div style="color: #ff0000">
		<c:out value="${basePath}" />
	</div>
</body>
</html>
