<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/cs320stu10"
        user="cs320stu10"
        password="AzlW!6.k"/>

<%-- query --%>
<sql:query var="entries">
    select * from guestbook
</sql:query>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>GuestBook (JSTL SQL)</title>
</head>
<body>

<c:if test="${entries.rowCount == 0}">
    <p>There is no message yet.</p>
</c:if>

<c:if test="${entries.rowCount > 0}">
    <table border="1">
        <tr><th>Id</th><th>Name</th><th>Message</th></tr>
        <c:forEach items="${entries.rowsByIndex}" var="row">
            <tr>
                <c:forEach items="${row}" var="col">
                    <td>${col}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</c:if>

<p><a href="AddComment.jsp">Add Comment</a></p>
</body>
</html>