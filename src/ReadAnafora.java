import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class ReadAnafora extends HttpServlet {								

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException 
	{
		//get the LinkAnaforas from the ServletContext + cast!!!
		LinkAnaforas newLink = (LinkAnaforas) getServletContext().getAttribute("linkAtt");
		
		//to servlet leei ston browser na kalesei to neo url
		response.sendRedirect(newLink.getLinkAnaforas());
    }
}





