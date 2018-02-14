<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Request Info</title>
</head>
<body>
The method of the request: ${pageContext.request.method} <br />
Remote user: ${pageContext.request.remoteUser} <br />
Remote address: ${pageContext.request.remoteAddr} <br />
The value of parameter a: ${param.a} <br />
The value of parameter b: ${param["b"]} <br />
The value of cookie JSESSIONID: ${cookie["JSESSIONID"].value} <br />
</body>
</html>
