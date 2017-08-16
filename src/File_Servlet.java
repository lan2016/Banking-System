
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class File_Servlet extends HttpServlet {
    
	public File_Servlet()
	{
		System.out.println("Inside File_Servlet");
	}
    	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs=req.getSession();
		String account=(String)hs.getAttribute("account");
		String password=(String)hs.getAttribute("password");
		//setContentType("html/text");
		PrintWriter pw=res.getWriter();
		//pw.println("<html>");
		//pw.println("<body>");
		//pw.println("Account No="+account);
		//pw.println("Password="+password);
		//pw.println("");
		//pw.println("</body>");
		//pw.println("</html>");
		//pw.println("save this file for furher login account");
		//pw.println("<html>");
		///pw.println("<body>");
		//pw.println("<script>");
	//pw.println("alert('You Have succesfully Inserted Your data')");
	//	pw.println("alert('Account No='+account)");
		//pw.println("alert('Password='+Password)");
		//pw.println("window.location('index.html;')");
		//pw.println("</script>");
		//pw.println("</body>");
//		pw.println("</html>");	
	
	res.sendRedirect("index.html");	
	}

}
