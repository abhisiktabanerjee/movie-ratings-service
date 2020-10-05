package com.demo.movieratingsdataservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings_data")
public class Rating {
	
	@Id
	@Column(name = "movieid")
	private String movieId;
	
	@Column(name = "rating")
	private double rating;
}
