package cs320.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GuestBook/AddEntry")
public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void init() throws ServletException {
		ServletContext context = getServletContext();
		if (context.getAttribute("entries") == null)
				context.setAttribute("entries", new ArrayList<GuestBookEntry>());
	}

	private String getName(HttpServletRequest request){
		
		Cookie[] cookies = request.getCookies();
        if( cookies != null )
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "name" ) )
                    return cookie.getValue();
        
		return null;
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
		out.println("<h1>Create Guest Book Entry <small>CS320 GuestBook</small></h1>");
		
		String name = getName(request);
		
		out.println("<form action=\"AddEntry\" method=\"post\">");
		
		if (name == null)
			out.println("  Name: <input type=\"text\" name=\"name\" /> <br />");
		else
			out.println("  Name: <input type=\"text\" name=\"name\" value=\"" + name + "\"/> <br />");
			
		
		out.println("  Message: <textarea name=\"message\"></textarea> <br />");
		out.println("  <input type=\"submit\" value=\"Post\" />");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the name and message from the request
		String name = request.getParameter("name");
		String message = request.getParameter("message");		
		
		// Create a new entry
		GuestBookEntry entry = new GuestBookEntry(name, message);
		
		// Get a reference to the list of entries
		ArrayList<GuestBookEntry> entries = 
			(ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		// Add the new entry to the list
		entries.add( entry );
		
		// Create/update the "name" cookie
		Cookie cookie = new Cookie("name", name);
		response.addCookie( cookie );
		
		response.sendRedirect("GuestBookServlet");
	}

}
