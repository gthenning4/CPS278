package edu.wccnet.ghenning.movieApp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.ghenning.movieApp.entity.Customer;

@Repository
public class customerDAOImpl implements customerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer get(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer as c where c.id = :id",Customer.class);
		query.setParameter("id", customerId);
		return query.getSingleResult();
	}

}
