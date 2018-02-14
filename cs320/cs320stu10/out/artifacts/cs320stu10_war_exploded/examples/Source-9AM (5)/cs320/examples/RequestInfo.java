package cs320.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/examples/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	response.setContentType( "text/html" );
	        PrintWriter out = response.getWriter();
	        out.println( "<html>" );
	        out.println( "<head><title>Display Request Info</title></head>" );
	        out.println( "<body>" );

	        out.println( "<b>Request Method</b>: " + request.getMethod() + "<br>" );
	        out.println( "<b>Request URI</b>: " + request.getRequestURI() + "<br>" );
	        out.println( "<b>Context Path</b>: " + request.getContextPath()
	            + "<br>" );
	        out.println( "You are from: " + request.getRemoteAddr() + "<br>" );

	        boolean isGzipSupported = request.getHeader( "Accept-Encoding" )
	            .indexOf( "gzip" ) >= 0;

	        if( isGzipSupported )
	            out.println( "Yes, gzip is supported. <br>" );
	        else
	            out.println( "No, gzip is not supported. <br>" );

	        out.println( "</body></html>" );
	    }

	    protected void doPost( HttpServletRequest request,
	        HttpServletResponse response ) throws ServletException, IOException
	    {
	        doGet( request, response );
	    }

}
