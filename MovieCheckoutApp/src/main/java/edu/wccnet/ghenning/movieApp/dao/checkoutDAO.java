package edu.wccnet.ghenning.movieApp.dao;

import java.util.List;

import edu.wccnet.ghenning.movieApp.entity.Checkout;

public interface checkoutDAO {

	public List<Checkout> getCheckouts(int customerId);

	public void save(Checkout checkout);

	public Checkout get(int id);

}
