package cs320.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GuestBook/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestBookEntry entry = null;
		
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
			for (GuestBookEntry e : entries){
				if (e.getId() == id){
					entry = e;
					break;
				}
			}
		}catch(Exception e){}
		finally{
			if (entry == null){
				response.sendRedirect("GuestBookServlet");
				return;
			}
		}
		
		
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
		out.println("<h1>Edit Guest Book Entry <small>CS320 GuestBook</small></h1>");
		
		out.println("<form action=\"EditServlet\" method=\"post\">");
		out.println("  Name: <input value=\"" + entry.getName() + "\" type=\"text\" name=\"name\" /> <br />");
		out.println("  Message: <textarea name=\"message\">" + entry.getMessage() + "</textarea> <br />");
		out.println("  <input type=\"hidden\" value=\"" + entry.getId() + "\" name=\"id\" />");
		out.println("  <input type=\"submit\" value=\"Post\" />");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		for (GuestBookEntry entry : entries)
			if (entry.getId() == id){
				entry.name = request.getParameter("name");
				entry.message = request.getParameter("message");
				break;
			}
		
		response.sendRedirect("GuestBookServlet");
	}

}









