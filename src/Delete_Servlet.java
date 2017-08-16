
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class Delete_Servlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PrintWriter pw;
//	ResultSet rs;
	Connection  con;
	String a;
	//private static final long serialVersionUID = 1L;
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
		String account=(String)hs.getAttribute("account");
		System.out.println("no is="+account);
		String password=req.getParameter("password");
		System.out.println("password is"+password);
		PrintWriter pw=res.getWriter();
	
		try
		{
			//Statement st=con.createStatement();
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select * from SBIBANKDATA3");
			 while(rs.next())
			 {
		//	rs.first();
				 if(account.equals(rs.getString("s22")))
				 {
					 a=rs.getString("s23");
				 }
			 }
				 if(password.equals(a))
				 {	//	 {
					System.out.println("enetr kksdnk");
					 //rs.deleteRow();
				 String updateemp="delete from SBIBANKDATA3  where s22='"+account+"'";
				 int v=st.executeUpdate(updateemp);
				 System.out.println(v+"1 row Succesfully deleted");
					res.sendRedirect("delete2.html");
//	}
	//			 }
			 //}
				 }}

		catch(Exception e)
		{
			System.out.println(e);		}
			
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
