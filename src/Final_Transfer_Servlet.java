import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class Final_Transfer_Servlet extends HttpServlet  {
	Connection con;
	double a,b,c,d,h;
	ResultSet rs;
	String s21,s221;
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
		String otheraccount=(String)hs.getAttribute("otheraccount");
		String account=(String)hs.getAttribute("account");
		String amount=req.getParameter("amount");
		a=Double.parseDouble(amount);
		 PrintWriter pw=res.getWriter();
		try
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rs=st.executeQuery("select * from SBIBANKDATA3");
			 while(rs.next())
			 {
				 if(account.equals(rs.getString("s22")))
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
		try
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rs=st.executeQuery("select * from SBIBANKDATA3");
			 while(rs.next())
			 {
				 if(otheraccount.equals(rs.getString("s22")))
				 {
				 s221=rs.getString("s21");
				d=Double.parseDouble(s221);
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
			h=d+a;
			try
			{
				
				Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 rs=st.executeQuery("select * from SBIBANKDATA3");	
					 String updateemp="update SBIBANKDATA3 set s21='"+c+"' where s22='"+account+"'";	
		             int e=st.executeUpdate(updateemp);
		             String updateemp1="update SBIBANKDATA3 set s21='"+h+"' where s22='"+otheraccount+"'";	
		             int f=st.executeUpdate(updateemp1);

		             if(e>0&&f>0)
		             {
		            	 res.setContentType("text/html");
		     			pw.println("<html>");
		     			pw.println("<head>");
		    			
		     			pw.println("<title>Amount Transfer</title>");
		     			pw.println("</head>");
		    			
		     			pw.println("<body bgcolor='gray'>");
		     		 pw.println("<p>Account Balance is..."+s21+"Rs"+"</p>");
		     			pw.println("<p>Transfer is Succesfull...)</p>");
		     			//pw.println("<p>Withdrawl is Succesfull...)</p>");
		     			pw.println("<p>"+a+""+"Rs Transferred To Account NO."+""+otheraccount+"</p>");
		     			pw.println("<p>Your Balance is"+" "+c+"rs"+"</p>");
		     			pw.println("<p>Your Session Has Expired...)</p>");
		     			
		     			pw.println("<a href='login.html'>Click Here</a><p>To Login...)</p>");
		     			
		     			pw.println("</body>");
		     			pw.println("</html>");
		     		
		             }
		             else
		             {
		            	 
		             }
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
				}
		else
		{
			System.out.println("insufficient balance");
			res.setContentType("text/html");
			pw.println("<html>");
			pw.println("<head>");
			
			pw.println("<title>Amount Transfer</title>");
			pw.println("<head>");
			
			pw.println("<body bgcolor='gray'>");
			pw.println("<p>You Have Insufficient Balance...)</p>");
			pw.println("<p>Your Session HAs Expired...)</p>");
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
