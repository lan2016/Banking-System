
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
public class Client_Servlet extends HttpServlet {
	Connection con;
	ResultSet rs;
	int i;
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

		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		/*pw.println("<html>");
		pw.println("<body>");
		pw.println("<table border='2px'>");
		pw.println("<tr>");
		
		pw.println("</table >");
		pw.println("</body>");
		pw.println("</html>");*/
		try
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
 rs=st.executeQuery("select * from SBIBANKDATA3");
	res.setContentType("text/html");
	pw.println("<html>");
	pw.println("<body bgcolor='green'>");
	pw.println("<h2><u>SBI CLIENT DATABASE<u></h2>");
	pw.println("<table border='2px' cellpadding='5px' bgcolor='red'>");
	//pw.println("<caption>SBI CLIENT DATABASE</caption");
	pw.println("<tr ><th>ACCOUNT NO.</th><th>NAME</td><th>MIDDLE NAME</th><th>LAST NAME</th><th>FATHER NAME</th><th>MOTHER NAME</th><th>DOB</th><th>GENDER</th><th>PRESENT ADRESS</th><th>CORROSPONDENCE ADRESS</th><th>CONTACT NO</th><th>EMAIL ID</th><th>UID NO </th><th>PAN NO</th><th>MARITAL STATUS</th><th>OCCUPATION</th><th>GROSS INCOME</th><th>PREVIOUS ACCOUNT NO.</th><th>NOMINEES NAME</th><th>BALANCE</th><th>ACCOUNT PASSWORD</th></tr>");
			while(rs.next())
			{
			
				
				//try
				//{
				//Thread.sleep(1000);	
				
				
				pw.println("<tr bgcolor='yellow'>");
				pw.println("<td>"+rs.getString("s22")+"</td><td>"+rs.getString("s1")+"</td><td>"+rs.getString("s2")+"</td><td>"+rs.getString("s3")+"</td><td>"+rs.getString("s4")+"</td><td>"+rs.getString("s5")+"</td><td>"+rs.getString("s7")+"-"+rs.getString("s6")+"-"+rs.getString("s8")+"</td><td>"+rs.getString("s9")+"</td><td>"+rs.getString("s10")+"</td><td>"+rs.getString("s11")+"</td><td>"+rs.getString("s12")+"</td><td>"+rs.getString("s13")+"</td><td>"+rs.getString("s14")+"</td><td>"+rs.getString("s15")+"</td><td>"+rs.getString("s16")+"</td><td>"+rs.getString("s17")+"</td><td>"+rs.getString("s18")+"</td><td>"+rs.getString("s19")+"</td><td>"+rs.getString("s20")+"</td><td>"+rs.getString("s21")+"</td><td>"+rs.getString("s23")+"</td></tr>");
				
				//}
				//catch(InterruptedException e)
			
			//	{
				///	System.out.println(e);
				//}
				}
					
				
			
			
			pw.println("</table>");
			pw.println("</body>");
			pw.println("</html>");


}
		catch(Exception e){
			System.out.println(e);
		}
	}
}