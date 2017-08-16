

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;



public class Password_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String user=req.getParameter("user");
		String password=req.getParameter("password");
		if(user.equals("rajat")&&password.equals("bansal"))
		{
			JOptionPane.showMessageDialog(null, "You Have Sucessfully Login");
			res.sendRedirect("user.html");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Account Or Password");
		}
	}

}
