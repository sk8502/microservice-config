package com.sk.rating.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private Integer rating;
	private String feedBack;
}
