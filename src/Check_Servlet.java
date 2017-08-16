import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class Check_Servlet extends HttpServlet {
	ResultSet rs;
	Connection con;
String s22="rajat",s23="12";
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
		String account=(String)hs.getAttribute("account");
		String password=req.getParameter("password");
		PrintWriter pw=res.getWriter();
		try
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//	 
			rs=st.executeQuery("select * from SBIBANKDATA3");
			 while(rs.next())
			 {
				 if(account.equals(rs.getString("s22")))
				 {
			
				
					 
				 if(password.equals(rs.getString("s23")))
						 {
					 s22=rs.getString("s22");
					 s23=rs.getString("s23");
					 res.setContentType("text/html");
					pw.println("<html>");
					pw.println("<head>");
					pw.println("<style></style>");
			
					pw.println("</head>");
					pw.println("<body bgcolor='green'>");
					pw.println("<fieldset>");
					pw.println("<legend><font color='pink' size='10px'>Personal Information</font></legend>");
					
					pw.println("<table border='2px'width='100%' cellpadding='10' >" );
					pw.println("<tr><td bgcolor='red'>First Name</td><td bgcolor='blue'>"+rs.getString("s1")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Middle Name</td><td bgcolor='blue'>"+rs.getString("s2")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Last Name</td><td bgcolor='blue'>"+rs.getString("s3")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Father Name</td><td bgcolor='blue'>"+rs.getString("s4")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Mother Name</td><td bgcolor='blue'>"+rs.getString("s5")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>DOB</td><td bgcolor='blue'>"+rs.getString("s7")+"-"+rs.getString("s6")+"-"+rs.getString("s8")+"</td></tr>");
					
					//pw.println("<tr><td>First Name</td><td>"+rs.getString("s7")+"</td></tr>");
				//	pw.println("<tr><td>First Name</td><td>"+rs.getString("s8")+"</td></tr>");
					pw.println("<tr bgcolor='red'><td>Gender</td><td bgcolor='blue'>"+rs.getString("s9")+"</td></tr>");
					pw.println("<tr bgcolor='red'><td>Present Adress</td><td bgcolor='blue'>"+rs.getString("s10")+"</td></tr>");
					pw.println("<tr bgcolor='red'><td>Corrospondence Adress</td><td bgcolor='blue'>"+rs.getString("s11")+"</td></tr>");
					pw.println("<tr bgcolor='red'><td>Contact No</td><td bgcolor='blue'>"+rs.getString("s12")+"</td></tr>");
					pw.println("<tr bgcolor='red'><td>Email Id</td><td bgcolor='blue'>"+rs.getString("s13")+"</td></tr>");
					pw.println("<tr bgcolor='red'><td>UID No</td><td bgcolor='blue'>"+rs.getString("s14")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>PAN No</td><td bgcolor='blue'>"+rs.getString("s15")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Marital Status</td><td bgcolor='blue'>"+rs.getString("s16")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Occupation</td><td bgcolor='blue'>"+rs.getString("s17")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Gross Income</td><td bgcolor='blue'>"+rs.getString("s18")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Previous Account No</td><td bgcolor='blue'>"+rs.getString("s19")+"</td></tr>");
					pw.println("<tr><td bgcolor='red'>Nominess  Name</td><td bgcolor='blue'>"+rs.getString("s20")+"</td></tr>");
					pw.println("</table>");
					
					pw.println("</fieldset>");
					pw.println("<fieldset>");
					pw.println("<legend><font color='pink' size='10px'>Account Information</font></legend>");
					pw.println("<table border='2px'width='100%' cellpadding='10' >" );
					pw.println("<tr bgcolor='red'><td>Account No.</td><td bgcolor='blue'>"+rs.getString("s22")+"</td></tr>");
					pw.println("<tr bgcolor='red'><td>Account Balance</td><td bgcolor='blue'>"+rs.getString("s21")+"Rs</td></tr>");
					pw.println("<tr bgcolor='red'><td>Account Password </td><td bgcolor='blue'>"+rs.getString("s23")+"</td></tr>");
					pw.println("</table>");
					pw.println("</fieldset>");
					pw.println("<body>");
					pw.println("</html>");
					
					
						 }
				
			 }
			 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(s22+s23);
		if(s22.equals(account)&&s23.equals(password))
		{
			System.out.println(s22+s23);
		}
		else
		{
		JOptionPane.showMessageDialog(null, "Invalid Password");
		res.sendRedirect("check.html");
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
