import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Login_Servlet extends HttpServlet 
{
	Connection con;
	ResultSet rs;
	String s1;
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

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String account=(String)req.getAttribute("account");
		System.out.println(account);
		try
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rs=st.executeQuery("select * from SBIBANKDATA3");
			 while(rs.next())
			 {
				 if(account.equals(rs.getString("s22")))
				 {
				 s1=rs.getString("s1");
			 }
			 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		hs.setAttribute("account", account);
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>User Authentication</title>");
	//String s1="rajat";
		pw.println("<link rel='stylesheet' type='text/css' href='login1.css'>");

		pw.println("</head>");
		pw.println("<body >");
		pw.println("<img src='img.jpeg' width='1350px' height='117px'>");
		pw.println("<marquee bgcolor='grey' class='test'><p ><b>Welcome To" +" "+  s1 +  "<b></p></marquee>");
		pw.println("<div class='main'><imge src='internet-banking.jpg' width='1100px' height='500px' class='image'/></div>");
		pw.println("<div id=main>");
		pw.println("<a href='test.html'><div class='common one'>CASH WITHDRWAL</div></a>");
		pw.println("<a href='transfer.html'><div class='common two'>Fund Transfer</div></a>");
		pw.println("<a href='check.html'><div class='common three'>Check Profile</div></a>");
		pw.println("<a href='delete.html'><div class='common four'>Remove Account</div></a>");
		pw.println("</div>");
		pw.println("<div class='button'><ul>");
		pw.println("<li><a href='login.html''>SIGN OUT</a></li>");
		pw.println("</ul></div>");
	
		pw.println("</body>");
		
		pw.println("</html>");
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
