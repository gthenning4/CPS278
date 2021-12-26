package edu.wccnet.ghenning.movieApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wccnet.ghenning.movieApp.entity.Checkout;
import edu.wccnet.ghenning.movieApp.service.CheckoutService;
import edu.wccnet.ghenning.movieApp.service.CustomerService;
import edu.wccnet.ghenning.movieApp.service.MovieService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	private CheckoutService checkoutService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/list")
	private String checkoutList(Model model,@RequestParam("customerId") int customerId) {
		
		model.addAttribute("movies", movieService.getMovies());
		model.addAttribute("customer", customerService.get(customerId));

		return "list-checkout";
	}
	@GetMapping("/history")
	private String checkoutHistory(Model model,@RequestParam("customerId") int customerId) {
		
		model.addAttribute("checkouts", checkoutService.getCheckouts(customerId));
		model.addAttribute("checkout", new Checkout());
		return "checkout-history";
	}
	@PostMapping("/save")
	private String save(Model model,@RequestParam("customerId") int customerId,@RequestParam("movieId") int movieId) {
		Checkout checkout = new Checkout();
		checkout.setCustomerId(customerId);
		checkout.setMovie(movieService.get(movieId));
		checkout.setReturnStatus(false);
		
		checkoutService.save(checkout);
		return "redirect:/checkout/history?customerId="+customerId;
	}
	@PostMapping("/return")
	private String returnCheckout(Model model, @RequestParam("customerId") int customerId, @ModelAttribute("checkout") Checkout checkout) {
		
		checkoutService.returnCheckout(checkout);
		
		return "redirect:/checkout/history?customerId="+customerId;
	}

}
