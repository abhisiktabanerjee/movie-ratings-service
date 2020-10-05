package com.demo.movieratingsdataservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.movieratingsdataservice.dao.RatingDao;
import com.demo.movieratingsdataservice.model.UserRatings;

@Service
public class RatingServiceImpl implements RatingService {
	
	private static final Logger LOGGER = LogManager.getLogger(RatingServiceImpl.class);
	
	@Autowired
	private RatingDao dao ;
	
	@Override
	public UserRatings fetchRating(String userid) {
		// TODO Auto-generated method stub
		final String METHODNAME = "fetchRatingService";
		LOGGER.info(METHODNAME + " STARTS");
		LOGGER.info("User ID received is {} ", userid);
		UserRatings ratings= new UserRatings();
		try {
		ratings = dao.fetchRating(userid);
		}
		catch(Exception e) {
			LOGGER.error("Failed in fetching ratings from DAO with error {} :", e);
		}
		LOGGER.info(METHODNAME + "ENDS");
		return ratings;

	}

}
