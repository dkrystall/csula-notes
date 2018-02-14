package cs320.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/examples/SimplePageCounter")
public class SimplePageCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static int counter = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Cervantes, Albert - cs320stu100</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div  class=\"container\">");
		
		// Page Specific Content
		out.println("<div class=\"jumbotron\">");
		out.println("     <h1>Page Request Counter</h1>");
		out.println("     <p>This page displays the number of times it has been served</p>");
		out.println("</div>");
		
		out.println("<h3>This page has been viewed: " + ++counter + " time(s).</h3>");
		
		
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
