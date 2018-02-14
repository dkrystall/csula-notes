package cs320.lab2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs320.homework1.HW1User;

@WebServlet("/Lab2/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void init() throws ServletException {
		
		ArrayList<HW1User> users = new ArrayList<HW1User>();
		
		// Pre-populate the users list with some dummy data
		users.add( new HW1User("John Doe", "john@doe.com", "1!") );
		users.add( new HW1User("Mary Doe", "mary@doe.com", "2@") );
		users.add( new HW1User("Joe Boxer", "joe@boxer.com", "3#") );
		
		// Add the array of Users to the global scope
		this.getServletContext().setAttribute("HW1Users", users);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html>" );
        out.println( "<head><title>Register</title></head>" );
        out.println( "<body>" );

        out.println("<h1>New User Registration</h1>");
        
        // This only exists AFTER a doPost executes, and there IS an error with 'name'
        String nameError = (String) request.getAttribute("nameError");
        String name = request.getParameter("name");
        
        out.println("<form action=\"Register\" method=\"post\">");
        
        out.println("   Name : <input type=\"text\" name=\"name\" value=\"" 
        					+  (nameError == null && name != null ?  name : "")
        					+ "\" /> <br />");
        if (request.getAttribute("nameError") != null)
        		out.println(request.getAttribute("nameError") + "<br />");
        
        out.println("   E-mail : <input type=\"text\" name=\"email\" /> <br />");
        
        out.println("   Password : <input type=\"password\" name=\"password\" /> <br />");
        
        out.println("   <input type=\"submit\" value=\"Register\" />");
        out.println("</form>");
        
        	out.println("<h1>Existing Users</h1>");
        	out.println("<table>");
        	out.println("<tr>");
        	out.println("  <th>Name</th> <th>E-mail</th> <th>Password</th>");
        	out.println("</tr>");
        	
        	// Print a row for every User
        	ArrayList<HW1User> users = (ArrayList<HW1User>) getServletContext().getAttribute("HW1Users");
        	
        	for (HW1User user : users){
        		out.println("<tr>");
        		out.println("<td>" + user.getName() + "</td>");
        		out.println("<td>" + user.getEmail() + "</td>");
        		out.println("<td>" + user.getPassword() + "</td>");
        		out.println("<tr>");
        	}
        	
        	out.println("</table>");

        out.println( "</body></html>" );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean isNameValid = false;
		boolean isEmailValid = false;
		boolean isPasswordValid = false;
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Valdiate Name
		if(name.trim().length() > 0){
			isNameValid = true;
		}
		else{
			isNameValid = false;
			request.setAttribute("nameError", "Error: Name cannot be empty!");
		}
		
		// Validate Email
		if(email.trim().length() > 0){
			isEmailValid = true;
		}
		else{
			isEmailValid = false;
			request.setAttribute("emailError", "Error: Email cannot be empty!");
		}
		
		
		
		if (isNameValid && isEmailValid && isPasswordValid){
			ArrayList<HW1User> users = (ArrayList<HW1User>) getServletContext().getAttribute("HW1Users");
			users.add(new HW1User(name, email, password));
			
			// In Homework 1, if you get here, redirect the User to Login
			// because they've successfully registered
		}			
		
		doGet(request, response);
	}

}






