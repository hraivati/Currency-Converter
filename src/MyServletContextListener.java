import javax.servlet.*;


public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) 
	{
		//get the context init parameters to find out the link_anaforas
		ServletContext sc = event.getServletContext();
		String linkAnaforas = sc.getInitParameter("link_anaforas");
		
		//make the LinkAnaforas object
		LinkAnaforas l = new LinkAnaforas(linkAnaforas);
		
		//put the LinkAnaforas into the context as an attribute --> ServletContext method setAttribute(String, Object)
		sc.setAttribute("linkAtt", l);
	}

	public void contextDestroyed(ServletContextEvent event) 
	{
		//nothing to do here
	}
}

