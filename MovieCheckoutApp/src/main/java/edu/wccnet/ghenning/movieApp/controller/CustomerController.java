package edu.wccnet.ghenning.movieApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.wccnet.ghenning.movieApp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listMovies(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "list-customers";
	}
	
}
