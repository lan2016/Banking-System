

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Output_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			HttpSession hs=request.getSession();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from SBIBANKDATA3 ");
		while(rs.next())
		{
			if(rs.getString("s22").equals((String)hs.getAttribute("account")))
			{
				Blob b=rs.getBlob(24);
				System.out.println("2");
				byte b1[]=new byte[(int)b.length()];
				System.out.println("3");
				b1=b.getBytes(1,(int)b.length());
				System.out.println("4");
				System.out.println("image length="+b.length());
				System.out.println("5");
				FileOutputStream fos=new FileOutputStream("x1.jpg");
				System.out.println("6");
				fos.write(b1);
				fos.close();
			}
		}
	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	/*	String account=(String)hs.getAttribute("account");
		String password=(String)hs.getAttribute("password");
		response.setContentType("html/text");
		PrintWriter pw=response.getWriter();
		pw.println("Account No="+account);
		pw.println("Password="+password);
		pw.println("");
		
		pw.println("save this file for furher login account");
		
	}*/

}
}
