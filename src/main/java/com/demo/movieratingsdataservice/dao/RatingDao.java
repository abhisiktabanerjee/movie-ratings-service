package com.demo.movieratingsdataservice.dao;

import com.demo.movieratingsdataservice.model.UserRatings;

public interface RatingDao {
	
	public UserRatings fetchRating(String userid);
}
