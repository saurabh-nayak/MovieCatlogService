package com.saurabh;

public class MovieRating {
	private int movieId;
	private int rate;
	
	
	
	public MovieRating(int movieId, int rate) {
		super();
		this.movieId = movieId;
		this.rate = rate;
	}
	public int getRate() {
		return rate;
	}

	public int getMovieId() {
		return movieId;
	}

	

}
