package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.project.bean.Category;
import com.project.bl.AdminBL;

public class RemoveCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(RemoveCategoryServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BasicConfigurator.configure();
 	    logger.info("remove category working!!");
		
		response.setContentType("text/html");
		PrintWriter out = null;
		HttpSession session=request.getSession(false);
		AdminBL admin=new AdminBL();
		String cName = request.getParameter("cname");
		try {
		boolean status=	admin.deleteCategory(cName);
		if(status){
			response.sendRedirect("admin.jsp");
		}else{
			//Call Error Page
		}
		} catch (ClassNotFoundException | SQLException e) {
			//request.setAttribute("errorMessage", "error deleting category");
		//request.getRequestDispatcher("error404error.jsp").include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
