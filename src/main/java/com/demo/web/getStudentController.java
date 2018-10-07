package com.demo.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.web.dao.StudentDao;
import com.demo.web.model.Student;

/**
 * Servlet implementation class getStudentController
 */
public class getStudentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentId  = Integer.parseInt(request.getParameter("studentId"));
		StudentDao dao = new StudentDao();
		Student a1 = dao.getStudent(studentId);
		request.setAttribute("student", a1);
		RequestDispatcher rd = request.getRequestDispatcher("showStudent.jsp");
		rd.forward(request, response);
		
		
	}

}
