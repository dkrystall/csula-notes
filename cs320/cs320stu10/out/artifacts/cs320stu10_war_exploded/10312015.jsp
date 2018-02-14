<%--
  Created by IntelliJ IDEA.
  User: dkrystall
  Date: 10/31/15
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hi jsp</title>
</head>
<body>
  <h2>The sum of A and B is
    <%
      int first = 0;
      int second = 0;
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    if (a != null && b != null){
    first = Integer.parseInt(a);
    second = Integer.parseInt(b);
    }
    int total = first+second;
    %>
    total
  </h2>
  <br>
  <form>
    A:<input type="text" name="a"/><br/>
  B:<input type="text" name="b"/><br/>
  <input type="submit" name="add"/><br/>
  </form>
</body>
</html>
