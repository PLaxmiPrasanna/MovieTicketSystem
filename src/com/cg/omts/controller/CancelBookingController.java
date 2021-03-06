package com.cg.omts.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.IUserService;
import com.cg.omts.service.UserServiceImpl;
;

@WebServlet("/CancelBookingController")
public class CancelBookingController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		System.out.println(ticketId+"jnsdd");
		IUserService userService = new UserServiceImpl();
		RequestDispatcher dispatcher = null;
		int isDeletedBooking = 0, isSeatDeleted = 0, isDeletedTransaction = 0, isDeletedSeatDetails = 0, isCancelled = 0, isRefunded = 0, isDeletedUser = 0;;
		List<Integer> seatsList = new ArrayList<Integer>();
		Transaction transaction = null;
		int currentBalance = 0;
		try {
			
			isDeletedBooking = userService.deleteBookingDetails(ticketId);
			seatsList = userService.getSeatsByTicket(ticketId);
			isSeatDeleted = userService.deleteAllocatedSeats(ticketId);
			isDeletedSeatDetails = userService.deleteSeatDetails(seatsList);
			transaction = userService.getTransactionDetails(ticketId);
			isDeletedTransaction = userService.deleteTransaction(ticketId);
			isDeletedUser = userService.deleteTicketFromUser(ticketId);
			isCancelled = userService.cancelTicket(ticketId);
			
			currentBalance = userService.getCurrentBalance(transaction);
			isRefunded = userService.refundAfterCancellation(transaction, currentBalance);
			
			dispatcher = request.getRequestDispatcher("userhome.jsp");
			dispatcher.forward(request, response);
			
		} catch (OMTSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
