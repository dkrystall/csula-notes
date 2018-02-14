<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Adder</title>
</head>
<body>



	
	<%
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		int num1 = 0, num2 = 0;
		
		if (a != null && a.trim().length() > 0 &&
		    b != null && b.trim().length() > 0){
			
			num1 = Integer.parseInt( a );
			num2 = Integer.parseInt( b );
			
		}
	%>
<h2>
	The sum of 
	<%= num1 %>
	and 
	<%= num2 %>
	is: 
	<%= num1 + num2 %>
</h2>

<form>
	A: <input type="text" name="a" /> <br />
	B: <input type="text" name="b" /> <br />
	<input type="submit" value="Add" />
</form>

</body>
</html>






