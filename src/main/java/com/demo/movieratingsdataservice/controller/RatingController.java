package com.demo.movieratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.movieratingsdataservice.model.Rating;
import com.demo.movieratingsdataservice.model.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRatings getUserRatingList(@PathVariable("userId") String userId) {
		
		List<Rating> ratings =  Arrays.asList(new Rating("5", 4), new Rating("6", 4), new Rating("8", 4),
				new Rating("18", 4));
		
		UserRatings  userRating = new UserRatings();
		userRating.setUserRatings(ratings);
		return userRating;
	}
}
