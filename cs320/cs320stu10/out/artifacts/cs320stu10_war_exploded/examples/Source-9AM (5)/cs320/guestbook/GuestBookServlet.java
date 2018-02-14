package cs320.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GuestBook/GuestBookServlet")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		
		// Create an array list of guest book entries
		ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		entries.add(new GuestBookEntry("John", "Hello"));
		entries.add(new GuestBookEntry("Mary", "G'bye"));
		entries.add(new GuestBookEntry("Joe", "Hi"));
		
		// Add the array list to the application scope
		getServletContext().setAttribute("entries", entries);
	}

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
		out.println("<div class=\"container\">");
		
		// Page-Specific Content
		out.println("<h1>Welcome <small>CS320 GuestBook</small></h1>");
		
		out.println("<a class=\"btn btn-primary\" href=\"AddEntry\">Create Post</a>");
		
		// Grab a reference to the list of entries
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		if (entries.size() > 0){
		
		out.println("<table class=\"table table-striped table-bordered table-hover\" >");
		out.println("   <tr>");
		out.println("     <th>Name</th>");
		out.println("     <th>Message</th>");
		out.println("     <th>Actions</th>");		
		out.println("   </tr>");
		
		
		// Iterate over all entries, and add them to the table
		for ( GuestBookEntry entry : entries ){
			out.println("  <tr>");
			out.println("    <td>" + entry.getName() + "</td>");
			out.println("    <td>" + entry.getMessage() + "</td>");
			out.println("    <td>");
			out.println("       <a href=\"EditServlet?id=" + entry.getId() + "\">Edit</a> | ");
			out.println("       <a href=\"DeleteServlet?id=" + entry.getId() + "\">Delete</a>");
			out.println("    </td>");
			out.println("  </tr>");
		}
		
		out.println("</table>");
		}
		else{
			out.println("<h3>There is nothing to display</h3>");
		}
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
