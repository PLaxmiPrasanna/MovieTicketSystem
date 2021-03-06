package com.cg.omts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.omts.dto.Screen;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;


@WebServlet("/DeleteScreenServlet")
public class DeleteScreenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		IAdminService adminService = new AdminServiceImpl();
		
		ArrayList<Screen> displayDetails;
		try {
			displayDetails = adminService.getScreenDetailsToDelete();
			HttpSession session = request.getSession();
			session.setAttribute("displayDetails", displayDetails);
			System.out.println("In do get method of delete screen servlet "+ displayDetails);
			request.getRequestDispatcher("deleteScreen.jsp").forward(request, response);
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int screenId = Integer.parseInt(request.getParameter("screenId"));
		IAdminService adminService = new AdminServiceImpl();
		try {
			adminService.deleteScreen(screenId);
			PrintWriter out = response.getWriter();
			out.println("Successfully deleted the screen with ID: "+ screenId);
		} catch (OMTSException e) {
			
			e.printStackTrace();
		}
	}

}
