package com.saurabh;

public class Movie
{
	
	
	
   public Movie(int movieId, String movieName, String description) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.description = description;
	}
int movieId;
   String movieName;
   String description;
public int getMovieId() {
	return movieId;
}
public void setMovieId(int movieId) {
	this.movieId = movieId;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
   
}
