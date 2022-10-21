package partA;
import java.sql.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		
		String Q = "3"; 
		
	if (Q == "1") {
		try {
			//Get connection
			Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","universityDB0021","abhi2002**");
			Statement myS=myConn.createStatement();
			//Query
			ResultSet resultSet = myS.executeQuery("SELECT * FROM student");			//Display
			while(resultSet.next()) {
				System.out.println(resultSet.getString("ID")+"  "+resultSet.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	if (Q == "2") {
		String stmt = "SELECT dept_name, count(student.ID), count(instructor.ID) FROM department join student using(dept_name) join instructor using(dept_name) GROUP BY dept_name ORDER BY dept_name ASC;";
		
		listDepartments(stmt);
		
	}
	
	if (Q == "3") {
		String stmt = "SELECT classroom.room_number AS 'class room' FROM classroom JOIN section USING(building) WHERE building=? AND capacity > 30 AND (SELECT COUNT(course_id) FROM section WHERE building = ?"
				+ " AND year = 2012 AND semester = 'Spring') = 0";
	    Q3_query(stmt);
		
	}
	
	}
	
	public static void listDepartments(String stmt)
	{
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","abhi2002**");
			
			Statement s  = conn.createStatement();
			
			String Q2_query = stmt;
					
			ResultSet resultSet = s.executeQuery(Q2_query);
			//Display
			while(resultSet.next()) {
				System.out.println(resultSet.getString("dept_name")+"  "+resultSet.getString("count(student.ID)")+" "+resultSet.getString("count(instructor.ID)"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void Q3_query(String stmt){
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","abhi2002**");
			
			PreparedStatement s  = conn.prepareStatement(stmt);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the bulding name");
			
			String building = scan.nextLine();
			s.setString(1, building);
			s.setString(2, building);
			scan.close();
					
			ResultSet resultSet = s.executeQuery();
			//Display
			while(resultSet.next()) {
				System.out.println(resultSet.getString("class room"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
