package edu.wccnet.ghenning.movieApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.ghenning.movieApp.entity.Movie;
import edu.wccnet.ghenning.movieApp.dao.movieDAO;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private movieDAO movieDAO;
	
	@Override
	@Transactional
	public List<Movie> getMovies() {
		return movieDAO.getMovies();
	}

	@Override
	@Transactional
	public void saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieDAO.saveMovie(movie);
	}

	@Override
	@Transactional
	public List<Movie> searchMovies(String keyword) {
		// TODO Auto-generated method stub
		return movieDAO.searchMovies(keyword);
	}

	@Override
	@Transactional
	public Movie get(int movieId) {
		// TODO Auto-generated method stub
		return movieDAO.get(movieId);
	}

	@Override
	@Transactional
	public Movie getByName(String name) {
		return movieDAO.getByName(name);
	}

}
