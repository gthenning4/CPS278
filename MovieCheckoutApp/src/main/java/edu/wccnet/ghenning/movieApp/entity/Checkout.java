package edu.wccnet.ghenning.movieApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="checkout")
public class Checkout {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="returnStatus")
	private boolean returnStatus;
	@ManyToOne
	@JoinColumn(name="movieId")
	private Movie movie;
	@Column(name="customerId")
	private int customerId;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "checkoutDate")
	private Date checkoutDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "returnDate")
	private Date returnDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(boolean returnStatus) {
		this.returnStatus = returnStatus;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public int getMovieId() {
		return this.getMovie().getId();
	}
	public void setMovieId(int id) {
		this.movie.setId(id);
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Checkout() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Checkout(int id, boolean returnStatus) {
		super();
		this.id = id;
		this.returnStatus = returnStatus;
	}
	
}
