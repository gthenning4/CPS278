package edu.wccnet.ghenning.movieApp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.wccnet.ghenning.movieApp.entity.Movie;


@Repository
public class movieDAOImpl implements movieDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Query<Movie> query= session.createQuery("from Movie", Movie.class);
		return query.getResultList();
	}

	@Override
	public void saveMovie(Movie movie) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(movie);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movie> searchMovies(String keyword) {
		Session session= sessionFactory.getCurrentSession();
		Query<Movie> query= session.createQuery("from Movie as m where m.name like :name OR m.description like :desc ", Movie.class);
		
		query.setParameter("name","%"+keyword+"%");
		query.setParameter("desc","%"+keyword+"%");
		return query.getResultList();
	}

	@Override
	public Movie get(int movieId) {
		Session session= sessionFactory.getCurrentSession();
		Query<Movie> query= session.createQuery("from Movie as m where m.id = :id", Movie.class);
		query.setParameter("id", movieId);
		return query.getSingleResult();
	}

	@Override
	public void decrement(Movie movie) {
		Session session= sessionFactory.getCurrentSession();
		movie.setNumAvailable(movie.getNumAvailable()-1);
		session.saveOrUpdate(movie);
		
	}

	@Override
	public void increment(Movie movie) {
		Session session= sessionFactory.getCurrentSession();
		movie.setNumAvailable(movie.getNumAvailable()+1);
		session.saveOrUpdate(movie);
		
		
	}

	@Override
	public Movie getByName(String name) {
		Session session= sessionFactory.getCurrentSession();
		Query<Movie> query= session.createQuery("from Movie as m where m.name = :name", Movie.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

}
