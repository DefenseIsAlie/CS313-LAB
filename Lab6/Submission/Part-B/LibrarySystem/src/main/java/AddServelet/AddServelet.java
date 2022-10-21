package AddServelet;
import java.sql.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class AddServelet
 */
public class AddServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {

			/**
			 * Getting the ids
			 */
			int book_id = Integer.parseInt(request.getParameter("book_id"));
			String title = request.getParameter("book_title");
			String category = request.getParameter("book_cat");
			String author  = request.getParameter("book_auth");
			
			Connection con = null;
	 		String url = "jdbc:mysql://localhost:3306/Library"; //MySQL URL and followed by the database name
	 		String username = "universityDB0021"; //MySQL username
	 		String password = "Abhi2002**"; //MySQL password
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	 		System.out.println("Printing connection object "+con);
	 		
	 		PreparedStatement chkid = con.prepareStatement("select count(*) from book where book_id = ?");
	 		chkid.setInt(1, book_id);
	 		ResultSet result_chk = chkid.executeQuery();
	 		result_chk.next();
	 		System.out.println("getting count");
	 		int size = result_chk.getInt("count(*)");
	 		System.out.println("size of count(*) is " + size);
	 		chkid.close();
	 		if (size != 0) {
	 			RequestDispatcher rd = request.getRequestDispatcher("AddResultFail.jsp");
				rd.forward(request, response);
	 		}else {
	 		
			//Prepared Statement to add student data
			PreparedStatement st = con.prepareStatement("insert into book values(?, ?,?,?)");
	 		st.setInt(1,book_id);
			st.setString(2,title);
			st.setString(3,category);
			st.setString(4,author);
			int result=st.executeUpdate();

			//Checks if insert is successful.If yes,then redirects to Result.jsp page 
			if(result>0)
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("AddResult.jsp");
				rd.forward(request, response);
			}
	 		
	 		}
	 		
		
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
