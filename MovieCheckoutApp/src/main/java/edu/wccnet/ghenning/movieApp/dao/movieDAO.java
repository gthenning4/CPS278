package edu.wccnet.ghenning.movieApp.dao;

import java.util.List;

import edu.wccnet.ghenning.movieApp.entity.Movie;

public interface movieDAO {
	public List<Movie> getMovies();
	public List<Movie> searchMovies(String keyword);
	public void saveMovie(Movie movie);
	public Movie get(int movieId);
	public void decrement(Movie movie);
	public void increment(Movie movie);
	public Movie getByName(String name);
}
