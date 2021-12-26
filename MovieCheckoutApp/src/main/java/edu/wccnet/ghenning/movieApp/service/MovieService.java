package edu.wccnet.ghenning.movieApp.service;

import java.util.List;

import edu.wccnet.ghenning.movieApp.entity.Movie;

public interface MovieService {
	public List<Movie> getMovies();
	public List<Movie> searchMovies(String keyword);
	public void saveMovie(Movie movie);
	public Movie get(int movieId);
	public Movie getByName(String name);
}
