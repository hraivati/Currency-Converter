import java.io.*;
import java.util.*;
import java.text.*;																	
import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.*;
import java.net.*;


public class CurrencyConverter extends HttpServlet {								

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException 
	{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		String amount = request.getParameter("amount");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		
		out.println("<html>" + "<head>" + "<title>Currency Converter results</title>" + "</head>" + "<body>" 
					+ "<h1 align=center>Currency Converter results</h1>" + "<br/>" + "<br/>" + "<br/>" + "<br/>" + "<p>"); 
		
		try {
			double amountD = Double.parseDouble(amount);
			double resultD = 0.0;

			//GET request apo to servlet ston currency converter ths Google
			URL googleUrl = new URL("http://www.google.com/ig/calculator?hl=en&q=1" + from + "=?" + to);
			URLConnection conn = googleUrl.openConnection();

			//Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String inputLine="";
            String mydata="";
			
			while ((inputLine = rd.readLine()) != null) {
				mydata = mydata + inputLine;
			}
			
			//eksagwgh tou epithymhtou arithmou apo to epistrefomeno String
			String delim1 = "[\"]";
            String[] tokens1 = mydata.split(delim1);
                                      
			String delim2 = "[ ]";
			String[] tokens2 = tokens1[3].split(delim2);

			double currencyD = Double.parseDouble(tokens2[0]);
			
			//pollaplasiasmos me amountD giati kalesa prin ton currency converter ths Google gia amount = 1
			resultD = amountD * currencyD;
                                  
			String result = Double.toString(resultD);
			
			//emfanizei to apotelesma sthn othonh			
			out.println(amount + " " + from + " = " + result + " " + to);
								  
			rd.close();	
		}
		
		catch (NumberFormatException e) {
                out.println("Bad number format!!!! Try again...");
        }
		
		out.println("</p>" + "</body>" + "</html>");
    }
}

