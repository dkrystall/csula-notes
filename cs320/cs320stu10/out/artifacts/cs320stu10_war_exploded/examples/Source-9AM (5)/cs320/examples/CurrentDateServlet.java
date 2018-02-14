package cs320.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/examples/CurrentDateServlet")
public class CurrentDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		if (context.getAttribute("pageCounter") == null){
			context.setAttribute("pageCounter", 0);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		// Get a reference to the current pageCounter value in the application scope
		int currentCount = (int) context.getAttribute("pageCounter");
		
		currentCount++;
		
		// Update the value of pageCounter in the application scope
		context.setAttribute("pageCounter", currentCount);
		
		
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
		out.println("     <h1>Current Date &amp; Time</h1>");
		out.println("     <p>The current date/time is: " + new java.util.Date() + "</p>");
		out.println("</div>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
