package edu.wccnet.ghenning.movieApp.service;

import java.util.List;

import edu.wccnet.ghenning.movieApp.entity.Checkout;

public interface CheckoutService {

	public List<Checkout> getCheckouts(int customerId);
	public void save(Checkout checkout);
	public void returnCheckout(Checkout checkout);
	public Checkout get(int id);

}
