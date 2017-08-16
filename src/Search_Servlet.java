import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.sql.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Search_Servlet extends HttpServlet 
{
	Connection con;
	int a,l,d;
	ResultSet rs;
	String s22="bansal";
	String s23="12";
	String account,password;
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
	
		
		 account=req.getParameter("account");
	 password=req.getParameter("Password");
		System.out.println(password);
		a=Integer.parseInt(account);
		l=	a=Integer.parseInt(account);
		
		try
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
 rs=st.executeQuery("select * from SBIBANKDATA3");
 

			while(rs.next())
			{
				
				System.out.println(account+"="+rs.getString("s22"));
	System.out.println(password+"="+rs.getString("s23"));
				if(account.equals(rs.getString("s22"))&&password.equals(rs.getString("s23")))
				{
					s22=rs.getString("s22");
					s23=rs.getString("s23");;
					System.out.println("Account found");
					req.setAttribute("account", account);
					JOptionPane.showMessageDialog(null,"Account Found");
					RequestDispatcher rd=req.getRequestDispatcher("next");
					rd.forward(req, res);
					
				}
				}
			System.out.println(s22+"+"+s23);
		//	System.out.println(account+"+"+password);
			if(s22.equals(account)&&s23.equals(password))
				
			{
				System.out.println("Invalid Account Or Password!!");
			}
			
				else
				{
				
					System.out.println("Account  not found");
					JOptionPane.showMessageDialog(null,"Account not Found");
					res.sendRedirect("login.html");

					//d++;
				}	
			//	System.out.println("a is"+d);
				//System.out.println(rs.getString("s22"));
			
		//	}
			
		}
	
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		/*try{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			 rs=st.executeQuery("select * from SBIBANKDATA3");
		rs.last();
		int b=Integer.parseInt(rs.getString("s22"));
		int c=l-b;
		System.out.println("c is ="+c);
		if( b==d)
		{
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}*/
	}
//	System.out.println(a);
		
	public void destroy()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
