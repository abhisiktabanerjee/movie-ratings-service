package com.demo.movieratingsdataservice.service;

import com.demo.movieratingsdataservice.model.UserRatings;

public interface RatingService {
	
	public UserRatings fetchRating(String userid);
}
