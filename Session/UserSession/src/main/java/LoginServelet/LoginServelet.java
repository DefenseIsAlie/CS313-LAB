package LoginServelet;
import java.sql.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServelet
 */
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get parameters
		String user_id = request.getParameter("u_id");
		String user_password = request.getParameter("password");
		
		Connection con = null;
 		String url = "jdbc:mysql://localhost:3306/UserBase"; //MySQL URL and followed by the database name
 		String username = "universityDB0021"; //MySQL username
 		String password = "Abhi2002**"; //MySQL password
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		try {
			PreparedStatement chk_pwd = con.prepareStatement("SELECT count(*) FROM user WHERE user.id=? and user.password=?");
			chk_pwd.setString(1, user_id);
			chk_pwd.setString(2, user_password);
			ResultSet result = chk_pwd.executeQuery();
			result.next();
			int count = Integer.parseInt(result.getString(1));
			
			if (count == 1) {
				response.setContentType("text/html");
				PrintWriter pwriter = response.getWriter();
				
				HttpSession session = request.getSession();
				session.setAttribute("user_name",user_id);
				session.setAttribute("user_password",password);
				pwriter.print("<h1>Welcome to your session " + user_id + "</h1>");
				pwriter.print("<a>Your session id is "+session.getId()+"</a>");
				pwriter.close();
			}else {
				response.setContentType("text/html");
				PrintWriter pwriter = response.getWriter();
				pwriter.print("<h1>Failed to authenticate you!!!</h1>");
				pwriter.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
