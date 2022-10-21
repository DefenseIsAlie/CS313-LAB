package IssueServelet;
import java.util.*;
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
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class IssueServelet
 */
public class IssueServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueServelet() {
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
			int student_id = Integer.parseInt(request.getParameter("s_id"));
			String issue_date = request.getParameter("issue_dt");
			String return_date  = request.getParameter("ret_dt");
			System.out.println(return_date);
			System.out.println(issue_date);
			
			if (issue_date == "" || issue_date == " ") {
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String date = simpleDateFormat.format(new Date());
				System.out.println(date);
				
				issue_date = date;
			}
			
			if (return_date == "" || return_date == " ") {
				String[] tmp = issue_date.split("-");
				return_date = tmp[0] + "-" + tmp[1] + "-" + Integer.toString(Integer.parseInt(tmp[2]) + 15);
			}
			
			Connection con = null;
	 		String url = "jdbc:mysql://localhost:3306/Library"; //MySQL URL and followed by the database name
	 		String username = "universityDB0021"; //MySQL username
	 		String password = "Abhi2002**"; //MySQL password
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	 		System.out.println("Printing connection object "+con);
	 		
	 		PreparedStatement chk_student = con.prepareStatement("select count(*) from student where student_id = ?");
	 		chk_student.setInt(1, student_id);
	 		ResultSet result_chk_student = chk_student.executeQuery();
	 		result_chk_student.next();
	 		System.out.println("getting count");
	 		int num_student = result_chk_student.getInt("count(*)");
	 		System.out.println("size of student count(*) is " + num_student);
	 		chk_student.close();
	 		if (num_student == 0) {
	 			RequestDispatcher rd = request.getRequestDispatcher("IssueResultStudentFail.jsp");
				rd.forward(request, response);
				return;
	 		}
	 		
	 		
	 		PreparedStatement chkid = con.prepareStatement("select count(*) from book where book_id = ?");
	 		chkid.setInt(1, book_id);
	 		ResultSet result_chk = chkid.executeQuery();
	 		result_chk.next();
	 		System.out.println("getting count");
	 		int size = result_chk.getInt("count(*)");
	 		System.out.println("size of count(*) is " + size);
	 		chkid.close();
	 		
	 		if (size == 0) {
	 			RequestDispatcher rd = request.getRequestDispatcher("IssueResultFail.jsp");
				rd.forward(request, response);
	 		}else {
	 		
			//Prepared Statement to add student data
			PreparedStatement st = con.prepareStatement("insert into issue values(?, ?,?,?)");
	 		st.setInt(2,book_id);
			st.setInt(1,student_id);
			st.setString(3, issue_date);
			st.setString(4, return_date);
			int result=st.executeUpdate();

			//Checks if insert is successful.If yes,then redirects to Result.jsp page 
			if(result>0)
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("IssueResult.jsp");
				rd.forward(request, response);
			}
	 		
	 		}
	 		
		
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
