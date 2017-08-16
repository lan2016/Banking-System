

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Doutput_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		{
			HttpSession hs=request.getSession();
			String c=(String)hs.getAttribute("a");
			System.out.println(hs.getAttribute("a"));
			Double a=(Double)hs.getAttribute("amount");
			System.out.println(a);
		Double b=(Double)hs.getAttribute("tamount");
		System.out.println(b);
		PrintWriter pw=response.getWriter(); 
		//System.out.println("amount"+account+"tamount");
		 	response.setContentType("html/text");
			
			pw.println("STATE BANK OF INDIA");
			pw.println("Account No :"+c);
		pw.println("Deposited Amount:"+a+"rs");
		pw.println("Total balance:"+b+"rs");
			pw.println("Thanks for Using Sbi Services");
		}
		
	}

}
