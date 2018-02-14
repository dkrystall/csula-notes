<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions.html" %>
<jsp:useBean id="ba" class="cs320.model.BeanA" />
<jsp:useBean id="bb" class="cs320.model.BeanB" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>ELTest</title>
</head>
<body>
<p>BeanA</p>
<ul>
  <li>id: \${ba.id}</li>
  <li>name: ${ba.name}</li>
  <li>weekdays[1]: ${ba.weekdays[1]}</li>
  <li>weekdays["1"]: ${ba.weekdays["1"]}</li>
  <li>numbers[1]: ${ba.numbers[1]}</li>
  <li>numbers["1"]: ${ba.numbers["1"]}</li>
</ul>
<p>BeanB</p>
<ul>
  <li>bean0.id: ${bb.bean0.id}</li>
  <li>bean0.name: ${bb.bean0.name}</li>
  <li>beans[1].id: ${bb.beans[1].id}</li>
  <li>beans[1].name: ${bb.beans[1].name}</li>
</ul>
<p>2 + 3/2: ${2+3/2}</p>
</body>
</html>
