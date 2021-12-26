package edu.wccnet.ghenning.movieApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.wccnet.ghenning.movieApp.entity.Checkout;
import edu.wccnet.ghenning.movieApp.entity.Customer;
import edu.wccnet.ghenning.movieApp.entity.Movie;
import edu.wccnet.ghenning.movieApp.service.CheckoutService;
import edu.wccnet.ghenning.movieApp.service.CustomerService;
import edu.wccnet.ghenning.movieApp.service.MovieService;

@RestController
@RequestMapping("/api/")
public class RestAPIController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private CheckoutService checkoutService;

	@GetMapping("/customer")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	@GetMapping("/customer/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		return customerService.get(customerId);
	}
	@GetMapping("/movie/{name}")
	public Movie getByName(@PathVariable String name) {
		return movieService.getByName(name);
	}
	@GetMapping("/history/{customerId}")
	public List<Checkout> getHistory(@PathVariable int customerId) {
		return checkoutService.getCheckouts(customerId);

	}

}

