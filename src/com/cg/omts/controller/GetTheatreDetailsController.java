package com.cg.omts.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

@WebServlet("/GetTheatreDetails")
public class GetTheatreDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String theatreCity = request.getParameter("theatreCity");
		IAdminService adminService = new AdminServiceImpl();
		ArrayList<Theatre> getTheatres;
		try {
			getTheatres = adminService.getTheatreDetails(theatreCity);
			ServletContext context=getServletContext();  
			Movie movie = (Movie) context.getAttribute("movieDto");  
			Screen screen = (Screen) context.getAttribute("screen");
			context.setAttribute("movie", movie);
			context.setAttribute("screen",screen);
			displayTheatreDetails(request, response, getTheatres);
		} catch (OMTSException e) {
			
			e.printStackTrace();
		}
		
		
	
	}
	
	protected void displayTheatreDetails(HttpServletRequest request, HttpServletResponse response, ArrayList<Theatre> getTheatres) throws ServletException, IOException {
	
		request.setAttribute("theatreDetails", getTheatres); 
		request.getRequestDispatcher("selectTheatreId.jsp").forward(request, response);
	}

}
