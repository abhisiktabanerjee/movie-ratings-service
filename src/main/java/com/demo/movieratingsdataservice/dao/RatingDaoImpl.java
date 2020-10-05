package com.demo.movieratingsdataservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.demo.movieratingsdataservice.model.Rating;
import com.demo.movieratingsdataservice.model.UserRatings;

@Transactional
@Repository
public class RatingDaoImpl implements RatingDao {
	
	private static final Logger LOGGER = LogManager.getLogger(RatingDaoImpl.class);
	EntityManagerFactory emf;
	@Override
	public UserRatings fetchRating(String userid) {
		final String METHODNAME = "fetchRatingDAO";
		LOGGER.info(METHODNAME + " STARTS"); 
		EntityManager em = emf.createEntityManager();
		UserRatings ratings = new UserRatings();
		List<Rating> result = new ArrayList<>();
		String fetch_rating = "Select * from ratings_data where userid = '"+userid+"'";
		try {
		Query query = em.createNativeQuery(fetch_rating);
		List<Object[]> list = query.getResultList();
		for(Object [] obj : list) {
			Rating rating = new Rating();
			rating.setMovieId(obj[1]==null? "":(String)obj[1]);
			rating.setRating(obj[2]==null ? -1: (Double)obj[2]);
			result.add(rating);			
		}
		ratings.setUserRatings(result);
		}
		catch(Exception e) {
			LOGGER.error("Error in fetching rating from DB with message: " ,e);
		}
		LOGGER.info(METHODNAME + " ENDS"); 
		return ratings;
	}

}
