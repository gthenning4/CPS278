package edu.wccnet.ghenning.movieApp.dao;

import java.util.List;

import edu.wccnet.ghenning.movieApp.entity.Customer;

public interface customerDAO {
	public List<Customer> getCustomers();

	public Customer get(int customerId);

}
