
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.*;

import java.io.*;
 public class Deposit_Output_Servlet extends HttpServlet
 {
	 HttpSession hs;
	 String account;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	System.out.println("inside the deposit");
 hs=req.getSession();
 System.out.println("output is"+req.getAttribute("a"));
 account=(String)req.getAttribute("a");
System.out.println(account);
//double amount=(double)req.getAttribute("amount");
//double tamount=(double)req.getAttribute("tamount");
PrintWriter pw=res.getWriter(); 
System.out.println("amount"+account+"tamount");
 	res.setContentType("html/text");
	
	pw.println("STATE BAN OF INDIA");
	pw.println("Account No :"+account);
//	pw.println("Deposited Amount:"+amount+"rs");
	//pw.println("Total balance:"+tamount+"rs");
	pw.println("Thanks for Using Sbi Services");

	}
	}
