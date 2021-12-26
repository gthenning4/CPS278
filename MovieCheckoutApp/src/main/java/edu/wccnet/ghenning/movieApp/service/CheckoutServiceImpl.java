package edu.wccnet.ghenning.movieApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import  edu.wccnet.ghenning.movieApp.dao.checkoutDAO;
import  edu.wccnet.ghenning.movieApp.dao.movieDAO;
import edu.wccnet.ghenning.movieApp.entity.Checkout;
import edu.wccnet.ghenning.movieApp.entity.Movie;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	@Autowired
	private checkoutDAO checkoutDAO;
	@Autowired
	private movieDAO movieDAO;

	@Override
	@Transactional
	public List<Checkout> getCheckouts(int customerId) {
		return checkoutDAO.getCheckouts(customerId);
	}

	@Override
	@Transactional
	public void save(Checkout checkout) {
		//decrement available
		Movie movie = checkout.getMovie();
		if (movie.getNumAvailable() >0 ) {
			movieDAO.decrement(movie);
			
			//save checkout
			checkoutDAO.save(checkout);
		}
	}
	
	@Override
	@Transactional
	public void returnCheckout(Checkout checkout) {
		
		checkout = checkoutDAO.get(checkout.getId());
		if (checkout.isReturnStatus() == false ) {
			movieDAO.increment(checkout.getMovie());
			//update return status
			checkout.setReturnStatus(true);
			
			//save checkout
			checkoutDAO.save(checkout);
		}
		
	}

	@Override
	@Transactional
	public Checkout get(int id) {   
		return checkoutDAO.get(id);
	}
}
	