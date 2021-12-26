package edu.wccnet.ghenning.movieApp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.ghenning.movieApp.entity.Movie;
import edu.wccnet.ghenning.movieApp.service.MovieService;


@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/list")
	public String listMovies(Model model) {
		model.addAttribute("movies", movieService.getMovies());
		return "list-movies";
	}
	@RequestMapping("/add")
	public String addMovieForm(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie",movie);
		return "add-movie-form";
	}
	@PostMapping("/save")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		movie.setNumAvailable(movie.getNumTotal());
		movieService.saveMovie(movie);
		return "redirect:/movie/list";
	}
	@PostMapping("/search")
	public String searchMovies(Model model, @RequestParam("keyword") String keyword) {
		model.addAttribute("movies",movieService.searchMovies(keyword));
		return "list-movies";
	}
	@GetMapping("/demo")
	public String demo (Model model) {
		model.addAttribute("movies",movieService.getMovies());
		return "materializeDemo";
	}
	

}
