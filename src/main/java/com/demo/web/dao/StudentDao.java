package com.demo.web.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;

import com.demo.web.model.Student;
import java.sql.*;



public class StudentDao {
	
	public Student getStudent(int studentId) {
		Student a = new Student();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker?allowPublicKeyRetrieval=true&amp;useSSL=false&amp;serverTimezone=UTC", "webstudent", "webstudent");
			Statement st = con.createStatement();
			ResultSet  rs = st.executeQuery("select * from student where studentId=" + studentId);
			if (rs.next()) {
				a.setId(rs.getInt("id"));
				a.setFirstName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				a.setEmail(rs.getString("email"));
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
		
		return a;
	}
	
//	public Student getStudent(String theStudentId) throws Exception{
//			
//			Student theStudent = null;
//			
//			Connection myConn = null;
//			PreparedStatement myStmt = null;
//			ResultSet myRs = null;
//			int studentId;
//			
//			try {
//				//convert student id to int
//				studentId = Integer.parseInt(theStudentId);
//				
//				//get connection to database
//				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker?allowPublicKeyRetrieval=true&amp;useSSL=false&amp;serverTimezone=UTC", "webstudent", "webstudent");
//				
//				//create sql to get selected student
//				String sql = "select * from student where id=?";
//				
//				//create prepared statement
//				myStmt = myConn.prepareStatement(sql);
//				
//				//set params
//				myStmt.setInt(1, studentId);
//				
//				//execute statement
//				myRs = myStmt.executeQuery();
//				
//				//retrieve data from result set row
//				if (myRs.next()) {
//					String firstName = myRs.getString("first_name");
//					String lastName = myRs.getString("last_name");
//					String email = myRs.getString("email");
//					
//					//use the studentId during construction
//					theStudent = new Student(studentId, firstName, lastName, email);
//				}
//				else {
//					throw new Exception("Could not find student id: " + studentId);
//				}
//				return theStudent;
//			}
//			finally {
//				//clean JDBC objects
//				close(myConn, myStmt, myRs);
//			}
//			
//		}
//	
//	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
//			
//			try {
//				if (myRs != null) {
//					myRs.close();
//				}
//				
//				if (myStmt != null) {
//					myStmt.close();
//				}
//				
//				if (myConn != null) {
//					myConn.close(); // Doesn't really close it...just puts back in connection pool
//				}
//			}
//			catch(Exception exc) {
//				exc.printStackTrace();
//			}
//		
//		}

}
