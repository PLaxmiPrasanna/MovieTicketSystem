package com.cg.omts.dao;

import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Theatre;
import com.cg.omts.exceptions.OMTSException;

public interface IAdminDao {
	public List<Theatre> getTheatreDetails() throws OMTSException;
	public  int addTheatre(Theatre theatre) throws OMTSException;
	public int deleteTheatre(int id) throws OMTSException;
}
