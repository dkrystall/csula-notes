package cs320.guestbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GuestBook/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// This servlet expects a parameter with the name 'id' to passed
		// Also, we assume the existence of a list of posts
		int id = Integer.parseInt(request.getParameter("id"));		
		
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		if (entries != null){
			for (GuestBookEntry entry : entries)
				if (entry.getId() == id){
					entries.remove( entry );
					break;
				}					
		}
		
		response.sendRedirect("GuestBookServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
