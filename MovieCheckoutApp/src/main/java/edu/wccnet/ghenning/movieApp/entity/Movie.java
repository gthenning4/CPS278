package edu.wccnet.ghenning.movieApp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="numTotal")
	private int numTotal;
	@Column(name="numAvailable")
	private int numAvailable;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumTotal() {
		return numTotal;
	}
	public void setNumTotal(int numTotal) {
		this.numTotal = numTotal;
	}
	public int getNumAvailable() {
		return numAvailable;
	}
	public void setNumAvailable(int numAvailable) {
		this.numAvailable = numAvailable;
	}
	public Movie(String name, String description, int numTotal, int numAvailable) {
		super();
		this.name = name;
		this.description = description;
		this.numTotal = numTotal;
		this.numAvailable = numAvailable;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", description=" + description + ", numTotal=" + numTotal
				+ ", numAvailable=" + numAvailable + "]";
	}
	
}
