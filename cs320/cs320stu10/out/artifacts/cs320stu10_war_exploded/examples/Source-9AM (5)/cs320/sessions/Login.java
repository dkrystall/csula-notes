package cs320.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sessions/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet( HttpServletRequest request,
	        HttpServletResponse response ) throws ServletException, IOException
	    {
	        response.setContentType( "text/html" );
	        PrintWriter out = response.getWriter();
	        out.println( "<html>" );
	        out.println( "<head><title>Login</title></head>" );
	        out.println( "<body>" );

	        out.println( "<form action='Login' method='post'>" );
	        out.println( "Username: <input type='text' name='username' /> <br />" );
	        out.println( "Password: <input type='password' name='password' /> <br />" );
	        out.println( "<input type='submit' name='login' value='Login' /> <br />" );
	        out.println( "</form>" );

	        out.println( "</body></html>" );
	    }

	protected void doPost( HttpServletRequest request,
	        HttpServletResponse response ) throws ServletException, IOException
	    {
	        if( request.getParameter( "username" ).equals( "john" )
	            && request.getParameter( "password" ).equals( "1!" ) )
	        {
	            request.getSession().setAttribute( "user", "John Doe" );
	            response.sendRedirect( "Members" );
	        }
	        else
	            response.sendRedirect( "Login" );
	    }

}
