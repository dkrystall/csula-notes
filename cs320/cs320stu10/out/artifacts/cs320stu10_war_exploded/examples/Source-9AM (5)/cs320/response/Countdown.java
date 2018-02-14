package cs320.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 10;

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html>" );
        out.println( "<head><title>Countdown</title></head>" );
        out.println( "<body>" );

        if( count > 0 )
        {
            out.println( "<h1>" + count + "</h1>" );
            --count;
            response.setHeader( "Refresh", "1" );
        }
        else
            out.println( "<h1>Rocket Launched!</h1>" );

        out.println( "</body></html>" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}
