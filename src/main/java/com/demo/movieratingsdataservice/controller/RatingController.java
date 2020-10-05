package com.demo.movieratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.movieratingsdataservice.model.Rating;
import com.demo.movieratingsdataservice.model.UserRatings;
import com.demo.movieratingsdataservice.service.RatingService;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
	
	private static final Logger LOGGER = LogManager.getLogger(RatingController.class);
	@Autowired
	private RatingService ratingService;
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRatings getUserRatingList(@PathVariable("userId") String userId) {
		final String METHODNAME = "getUserRatingList";
		LOGGER.info(METHODNAME + "STARTS");
		LOGGER.info("USerID received is {} ", userId);
		List<Rating> ratings =  Arrays.asList(new Rating("1000", 4), new Rating("1001", 4), new Rating("1002", 4),
				new Rating("1003", 4));
		
		UserRatings  userRating = new UserRatings();
		userRating.setUserRatings(ratings);
	//	userRating = ratingService.fetchRating(userId);
		LOGGER.info(METHODNAME + "ENDS");
		return userRating;
	}
}
