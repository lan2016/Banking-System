import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import javax.xml.ws.Response;

import java.sql.*;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
@MultipartConfig

public class Bank_Servlet extends HttpServlet 
{
	int balance=0;
	int id=0;
	Connection con;
	int a=0;
public void init(ServletConfig sc)
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/SBIDATA","root","mysql");
	//	Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	   
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
		HttpSession hs=req.getSession();
String fn=req.getParameter("fn");
if(fn.equals("1"))
{
	String name=req.getParameter("name");
	
	String mname=req.getParameter("mname");
	String lname=req.getParameter("lname");
	String fname=req.getParameter("fname");
	String moname=req.getParameter("moname");
	String month=req.getParameter("month");
	String date=req.getParameter("date");
	System.out.println(date);
	String year=req.getParameter("year");
	String gender=req.getParameter("gender");
	System.out.println(gender);
	String padress=req.getParameter("padress");
	String cadress=req.getParameter("cadress");
	hs.setAttribute("name", name);
	hs.setAttribute("mname", mname);
	hs.setAttribute("lname", lname);
	hs.setAttribute("fname", fname);
	hs.setAttribute("moname", moname);
	hs.setAttribute("month", month);
	hs.setAttribute("date", date);
	hs.setAttribute("year", year);
	hs.setAttribute("gender", gender);
	hs.setAttribute("padress", padress);
     hs.setAttribute("cadress", cadress);
     res.sendRedirect("secondregistration.html");
}
if(fn.equals("2"))
{

	String contact=req.getParameter("contact");
	String email=req.getParameter("email");
	String uid=req.getParameter("uid");
	String pan=req.getParameter("pan");
	String married=req.getParameter("married");
	String occuption=req.getParameter("occuption");
	String income=req.getParameter("income");
	String previous=req.getParameter("previous");
	String nominee=req.getParameter("nominee");
	String name=(String)hs.getAttribute("name");
	String mname=(String)hs.getAttribute("mname");
	String lname=(String)hs.getAttribute("lname");
	String fname=(String)hs.getAttribute("fname");
	String moname=(String)hs.getAttribute("moname");
	String month=(String)hs.getAttribute("month");
	String date=(String)hs.getAttribute("date");
	String year=(String)hs.getAttribute("year");
	String gender=(String)hs.getAttribute("gender");
	String padress=(String)hs.getAttribute("padress");
	String cadress=(String)hs.getAttribute("cadress");
	String password=req.getParameter("password");
	System.out.println(gender);
	int s7=Integer.parseInt(date);
	System.out.println(s7);
	int s8=Integer.parseInt(year);
	long s12=Long.parseLong(contact);
	long s15=Long.parseLong(pan);
	long s14=Long.parseLong(uid);
	long s18=Long.parseLong(income);
	long s19=Long.parseLong(previous);
	//String image=req.getParameter("photo");
    Part image=req.getPart("photo");
	System.out.println("*****");
	System.out.println(image);
	System.out.println("*****");
	
	System.out.println(name+fname+lname+moname+mname+month+s7+s8+gender+padress+cadress+s12+email+s14+s15+married+occuption+s18+s19+nominee+id+balance);
	try
	{
		System.out.println("before values");
		//Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//String insert="insert into SBIBANKDATA3 values('"+name+"','"+mname+"','"+lname+"','"+fname+"','"+moname+"','"+month+"','"+s7+"','"+s8+"','"+gender+"','"+padress+"','"+cadress+"','"+s12+"','"+email+"','"+s14+"','"+s15+"','"+married+"','"+occuption+"','"+s18+"','"+s19+"','"+nominee+"','"+balance+"','"+id+"','"+password+"')";
	//	int a=st.executeUpdate(insert);
		String query="insert into SBIBANKDATA3(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,image)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement st=con.prepareStatement(query);
		st.setString(1,name);
		st.setString(2,mname);
		st.setString(3,lname);
		st.setString(4,fname);
		st.setString(5,moname);
		st.setString(6,month);
		st.setInt(7,s7);
		st.setInt(8,s8);
		st.setString(9,gender);
		st.setString(10,padress);
		st.setString(11,cadress);
		st.setLong(12,s12);
		st.setString(13,email);
		st.setLong(14,s14);
		st.setLong(15,s15);
		st.setString(16,married);
		st.setString(17,occuption);
		st.setLong(18,s18);
		st.setLong(19,s19);
		st.setString(20,nominee);
		st.setInt(21,balance);
		st.setInt(22,id);
		st.setString(23,password);
		System.out.println("after all values insertion");
	//	File f=new File(image);
		//FileInputStream fs=new FileInputStream(f);
		//st.setBinaryStream(24,fs, (int)f.length());
	//System.out.println("image length="+f.length());
	a=st.executeUpdate();
	System.out.println("no of row affected="+a);
	//con.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
		//ResultSet rs=st.executeQuery("select * from SBIBANKDATA3");
		//rs.last();
		/*System.out.println(a+"succesfuully inserted");
		/*rs.last();
		System.out.println(rs.getString("s22"));
		PrintWriter pw=res.getWriter();
		PreparedStatement stmt=con.prepareStatement("update SBIBANKDATA3 set IMAGE=? where s21=id");
		File f=new File(image);
		FileInputStream fs=new FileInputStream(f);
		stmt.setBinaryStream(1,fs, (int)f.length());
	System.out.println("image length="+f.length());
	System.out.println("no of row affected="+stmt.executeUpdate());*/
	try
		{
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select * from SBIBANKDATA3 ");
			rs.last();
	if(a>0)
	{
		System.out.println(rs.getString("s22")+rs.getString("s23"));
		hs.setAttribute("account",rs.getString("s22") );
		hs.setAttribute("password", rs.getString("s23"));	
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
	
		//res.sendRedirect("output.html");
		//res.setContentType("text/html");
		//PrintWriter pw=res.getWriter();
	//pw.
		//JOptionPane.showMessageDialog(null,"You have succesfully inserted your data");
		//res.setContentType("html/text");
		
		//res.sendRedirect("index.html");
		//pw.println("save this file for furher login account");
		//System.out.println("after file");
			//res.sendRedirect("filedownload.html");
	//RequestDispatcher rd=req.getRequestDispatcher("/secondfile");
	//rd.forward(req, res);
	//System.out.println("After dispatcher");
		
	 
	}
	else
	{
		
	}
	}
	catch(Exception e1)
	{
		System.out.println(e1);
	}
	}}


	public void destroy()
	{
		try
		{
		con.close();
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
}
	
}
