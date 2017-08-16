import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import java.sql.*;
public class Transfer_Servlet extends HttpServlet {
	String s1,s2,s22="hy";
	ResultSet rs;
	Connection con;
	
	private static final long serialVersionUID = 1L;
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		s1=(String)hs.getAttribute("account");
		s2=req.getParameter("otheraccount");
		hs.setAttribute("otheraccount", s2);
		PrintWriter pw=res.getWriter();
		int a=Integer.parseInt(s1);
		int l=	a=Integer.parseInt(s1);
		System.out.println(s1+s2);
		if(s1.equals(s2))
		{
		//	res.sendRedirect("transfer1.html");
			RequestDispatcher rd=req.getRequestDispatcher("transfer1.html");
			 rd.forward(req,res);
		}
		else	
		{	
		try		
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rs=st.executeQuery("select * from SBIBANKDATA3");
			 while(rs.next())
			 {
				 if(s2.equals(rs.getString("s22")))
				 {
					 s22=rs.getString("s22");
					 res.sendRedirect("message.html");
					
					/*res.setContentType("text/html");
					 pw.println("<html>");
					 pw.println("<body>");
					 pw.println("<script>");
					 pw.println("confirm('press ok for transaction')");
					 
					 
						 pw.println("</script>");
						 
					 pw.println("</body>");
					 pw.println("</html>");*/
				 }
				// a--;
			 }
		}
				catch(Exception e)
				{
					
				}
		
				
			//	try{
				//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//	 rs=st.executeQuery("select * from SBIBANKDATA3");
			//	rs.last();
			//	int b=Integer.parseInt(rs.getString("s22"));
				//int c=l-b;
				//System.out.println(c);
		System.out.println(s22);
				if( s22.equals(s2))
				{
					
				}
			
				else
				{
			res.sendRedirect("transfer1.html");
				//RequestDispatcher rd=	 req.getRequestDispatcher("transfer.html");
					// rd.forward(req,res);
				
					}
				
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


