
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import javax.swing.JOptionPane;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;


public class Deposit_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	ResultSet rs;
	String s1,s23,s21;
	String account,amount;
	double d,t;
public void init(ServletConfig sc)
{
	try
	{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
System.out.println("inid init");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}

protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	HttpSession hs=req.getSession();
		System.out.println("inside posy");
	account=req.getParameter("account");
	System.out.print(account);
	amount=req.getParameter("amount");
	System.out.print(amount);
	try
	{
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rs=st.executeQuery("select * from SBIBANKDATA3");
		 while(rs.next())
		 {
			 if(account.equals(rs.getString("s22")))
			 {
				s23=rs.getString("s22"); 
				s21=rs.getString("s21");
			 //=rs.getString("s21");
			//b=Double.parseDouble(s21);
		 }
		 }
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	if(account.equals(s23))
	{
	 d=Double.parseDouble(amount);
	 t=Double.parseDouble(s21);
	 System.out.println(d+t);
	try
	{
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rs=st.executeQuery("select * from SBIBANKDATA3");
		
		 String updateemp="update SBIBANKDATA3 set s21='"+(d+t)+"' where s22='"+account+"'";	
         int f=st.executeUpdate(updateemp);
         System.out.println(f+"Succesfully Deposited");
         PrintWriter pw=res.getWriter();
        // 
         if(f>0)
         {
         hs.setAttribute("a", account);
         System.out.println("account is="+account);
         hs.setAttribute("amount", d);
         System.out.println("amount is="+d);
         hs.setAttribute("tamount",(d+t));
         System.out.println("taccount is="+(d+t));
         res.sendRedirect("deposit_output.html");
 		         }	
 	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	else
	{
		JOptionPane.showConfirmDialog(null, "Invalid Account No.");
	}
}
}