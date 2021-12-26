package edu.wccnet.ghenning.movieApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.ghenning.movieApp.entity.Customer;
import edu.wccnet.ghenning.movieApp.dao.customerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private customerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer get(int customerId) {
		return customerDAO.get(customerId);
	}

}
