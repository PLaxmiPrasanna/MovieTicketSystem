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

import com.cg.omts.dto.Movie;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

@WebServlet("/DeleteMovieServlet")
public class DeleteMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdminService adminService = new AdminServiceImpl();
		
		ArrayList<Movie> displayDetails;
		try {
			displayDetails = adminService.getMovieDetailsToDelete();
			HttpSession session = request.getSession();
			session.setAttribute("displayDetails", displayDetails);
			System.out.println("In do get method of delete movie servlet "+ displayDetails);
			request.getRequestDispatcher("deleteMovies.jsp").forward(request, response);
		} catch (OMTSException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		
		IAdminService adminService = new AdminServiceImpl();
		try {
			adminService.deleteMovie(movieId);
			PrintWriter out = response.getWriter();
			out.println("Successfully deleted movie with ID: "+ movieId);
		} catch (OMTSException e) {
			
			e.printStackTrace();
		}
				
	}

}
