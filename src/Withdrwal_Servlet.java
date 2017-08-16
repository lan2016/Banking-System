
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Withdrwal_Servlet extends HttpServlet {
	Connection con;
	ResultSet rs;
	String s21,s;
	double a,b,c;
public void init(ServletConfig sc)
{
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession hs=request.getSession();
String s=(String)hs.getAttribute("account");
System.out.println("account no is"+s);
String amount=request.getParameter("amount");
 a=Double.parseDouble(amount);
 PrintWriter pw=response.getWriter();
try
{
	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 rs=st.executeQuery("select * from SBIBANKDATA3");
	 while(rs.next())
	 {
		 if(s.equals(rs.getString("s22")))
		 {
		 s21=rs.getString("s21");
		b=Double.parseDouble(s21);
	 }
	 }
}
catch(Exception e)
{
	System.out.println(e);
}
if(b>a)
{
	

	c=b-a;
	try
	{
		
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rs=st.executeQuery("select * from SBIBANKDATA3");	
			 String updateemp="update SBIBANKDATA3 set s21='"+c+"' where s22='"+s+"'";	
             int d=st.executeUpdate(updateemp);
             
	
		 response.setContentType("text/html");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Withdrawl Amount</title>");
			pw.println("</head>");
			pw.println("<body bgcolor='gray'>");
		 pw.println("<p>Account Balance is..."+s21+"Rs"+"</p>");
			pw.println("<p>Withdrawl is Succesfull...)</p>");
			//pw.println("<p>Withdrawl is Succesfull...)</p>");
			pw.println("<p>Your Balance is"+" "+c+"</p>");
			pw.println("<p>Your Session HAs Expired...)</p>");
			
			pw.println("<a href='login.html'>Click Here</a><p>To Login...)</p>");
			
			pw.println("</body>");
			pw.println("</html>");
		
			

	}
	catch(Exception e)
	{
		
	}
	
	System.out.println(c);
	
}
	

else{
	System.out.println("insufficient balance");
	response.setContentType("text/html");
	pw.println("<html>");
	pw.println("<head>");
	pw.println("<title>Withdrawl Amount</title>");
	pw.println("</head>");
	pw.println("<body bgcolor='gray'>");
	pw.println("<p>You Have Insufficient Balance...)</p>");
	pw.println("<p>Your Session Has Expired...)</p>");
	pw.println("<a href='login.html'>Click Here</a><p>To Login...)</p>");
	pw.println("</html>");
	pw.println("</body>");

}

	}
	public void destroy(){

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
