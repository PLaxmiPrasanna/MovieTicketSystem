package com.cg.omts.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.util.CustomObjectInputStream;

import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public interface IUserService {
	
	/*******************************
	 * @description Method to get movie details 
	 * @author Laxmi Prasanna Pujari
	 *  
	 * @param movieId
	 * @return Movie
	 * @throws OMTSException
	 */

	public Movie getMovieDetails(int movieId) throws OMTSException;
	
	/*******************************
	 * @description Method to generate ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @param ticket
	 * @return int
	 * @throws OMTSException
	 */
	public int generateTicket(Ticket ticket) throws OMTSException;
	
	/*******************************
	 * @description Method to allocate seat
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param selectedSeatsList
	 * @param screenId
	 * @return int
	 * @throws OMTSException
	 */
	
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException;
	
	/*******************************
	 * @description Method to assign seats to tickets
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @param seatsList
	 * @return int
	 * @throws OMTSException
	 */
	
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException;
	
	/*******************************
	 * @description Method to set ticket status
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @param status
	 * @return int
	 * @throws OMTSException
	 */
	
	public int setTicketStatus(int ticketId, String status) throws OMTSException;	//s
	
	/*******************************
	 * @description Method to add transaction
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param transaction
	 * @param ticketId
	 * @param userId
	 * @return int
	 * @throws OMTSException
	 */
	
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException;//s
	
	/*******************************
	 * @description Method to add booking
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param booking
	 * @param ticketId
	 * @param transactionId
	 * @return int
	 * @throws OMTSException
	 */
	
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException;//s
	
	/*******************************
	 * @description Method to set seat status
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param seatId
	 * @param status
	 * @return int
	 * @throws OMTSException
	 */
	
	public int setSeatStatus(int seatId, String status) throws OMTSException;//s
	
	/********************************
	 * @description Methods to delete booking details
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	
	public int deleteBookingDetails(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Methods to get seats my ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to delete allocated seats
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	
	public int deleteAllocatedSeats(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to delete seat details
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param seatList
	 * @return int
	 * @throws OMTSException
	 */
	
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException;
	
	/********************************
	 * @description Method to get transaction details
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return Transaction
	 * @throws OMTSException
	 */
	public Transaction getTransactionDetails(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to delete transaction 
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	
	public int deleteTransaction(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to cancel ticket
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param ticketId
	 * @return int
	 * @throws OMTSException
	 */
	
	public int cancelTicket(int ticketId) throws OMTSException;
	
	/********************************
	 * @description Method to get current balance
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param transaction
	 * @return int
	 * @throws OMTSException
	 */
	
	public int getCurrentBalance(Transaction transaction) throws OMTSException;
	
	/********************************
	 * @description Method to refund after cancellation
	 * @author Laxmi Prasanna Pujari
	 * 
	 * @param transaction
	 * @param currentBalance
	 * @return int
	 * @throws OMTSException
	 */
	
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException;

	
	/*****
	 * @description Method to return seat price
	 * @author Supriya M
	 * 
	 * @param seatId
	 * @return Seat
	 * @throws OMTSException
	 */
	public Seat getSeatPrice(int screenId) throws OMTSException;
	
	/*****
	 * @description Method to return screen details
	 * @author Supriya M
	 * 
	 * @param theatreId
	 * @return List<Screen>
	 * @throws OMTSException
	 */
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException;
	
	/*****
	 * @description Method to return Theatres in city
	 * @author Supriya M
	 * 
	 * @param city
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	public List<Integer> getTheatresByCity(String city) throws OMTSException;
	
	/*****
	 * @description Method to get all movies
	 * @author Supriya M
	 * 
	 * @return List<Movie>
	 * @throws OMTSException
	 */
	public List<Movie> getAllMovies() throws OMTSException;
	
	/*****
	 * @description Method to return Booking details
	 * @author Supriya M
	 * 
	 * @param ticketId
	 * @return Booking
	 * @throws OMTSException
	 */
	public Booking getBookingDetails(int ticketId) throws OMTSException;
	
	/*****
	 * @description Method to return Shows
	 * @author Supriya M
	 * 
	 * @param screenId
	 * @param theatreId
	 * @param movieId
	 * @return List<Show>
	 * @throws OMTSException
	 */
	public List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException;
	
	/*******************************
	 * @description Method to get theatre Id's
	 * @author Supriya M
	 *  
	 * @param movieId
	 * @return List<Integer>
	 * @throws OMTSException
	 */
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException;//s
	
	/*******************************
	 * @description Method to get Theatre Names
	 * @author Supriya M
	 * 
	 * @param theatreIdList
	 * @return List<String>
	 * @throws OMTSException
	 */
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException;
	
	/*******************************
	 * @description Method to get Movie Names
	 * @author Supriya M
	 * 
	 * @param theatreIdList
	 * @return List<Movie>
	 * @throws OMTSException
	 */
	public List<Movie> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException;

	/*******
	 @Description : To validate payment
	 @author  : Ashutosh
	 @param : accountNo, cvv, password
	 @return : Boolean(true or false)
	 @Exception : throws OMTSException
	********/
	public boolean validatePayment(int accountNo,int cvv,String password) throws OMTSException;
	
	/*******
	 @Description : To get Seat Availabilty
	 @author  : Ashutosh
	 @param : seatId
	 @return : Seat object
	 @Exception : throws OMTSException
	********/
	public Seat seatAvailability(int seatId) throws OMTSException;
	
	/*******
	 @Description : To get Ticket
	 @author  : Ashutosh
	 
	 @param : ticketId
	 @return : Ticket object
	 @Exception : throws OMTSException
	********/
	public Ticket getTicket(int ticketId) throws OMTSException;

	public String getScreenName(int screenId) throws OMTSException;
	
	public String getShowName(int showId) throws OMTSException;
	
	int getTransactionIdByBookingId(int bookingId) throws OMTSException;
	
	int getTicketIdByBookingId(int bookingId) throws OMTSException;

	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException;

	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException;
	
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException;
	
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException;

	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException;

	public int deleteTicketFromUser(int ticketId) throws OMTSException;

	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public List<String> getScreenNameByTheatre(List<Integer> theatreIdList) throws OMTSException;

	public int getSeatsAvailable(int screenId) throws OMTSException;

	public Screen getScreen(int screenId) throws OMTSException;
	
}
