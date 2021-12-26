package edu.wccnet.ghenning.movieApp.service;

import java.util.List;

import edu.wccnet.ghenning.movieApp.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public Customer get(int customerId);

}
