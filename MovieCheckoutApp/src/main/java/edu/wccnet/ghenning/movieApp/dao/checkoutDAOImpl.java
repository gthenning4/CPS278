package edu.wccnet.ghenning.movieApp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.ghenning.movieApp.entity.Checkout;

@Repository
public class checkoutDAOImpl implements checkoutDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Checkout> getCheckouts(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Checkout> query = session.createQuery("from Checkout as c where c.customerId = :customerId ",Checkout.class);
		query.setParameter("customerId", customerId);
		return query.getResultList();
	}

	@Override
	public void save(Checkout checkout) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(checkout);
	}

	@Override
	public Checkout get(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Checkout> query = session.createQuery("from Checkout as c where c.id = :id ",Checkout.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	
}
