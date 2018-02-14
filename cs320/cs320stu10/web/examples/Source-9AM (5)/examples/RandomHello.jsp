<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Random Hello</title>
</head>
<body>


<% if ( Math.random() < 0.5 ){ %>
	<h1>Have a <strong>Great</strong> Day!</h1>
<% } else { %>
	<h1>	Have a <em>lousy</em> day!</h1>
<% } %>

</body>
</html>