package fr.epsi.stazi.jpahibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="number_")
	private int number;
	
	@Column(name="name_")
	private String name;
	
	@Column(name="health_points")
	private int healthPoints;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name= "pokemon_est_de_type", joinColumns= { @JoinColumn(name="pokemon_id") }, inverseJoinColumns = { @JoinColumn(name="type_id") })
	private List<Type> types;
	
	@OneToOne
	@JoinColumn(name="evolution")
	private Pokemon evolution;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public Pokemon getEvolution() {
		return evolution;
	}
	public void setEvolution(Pokemon evolution) {
		this.evolution = evolution;
	}
	
	@Override
	public String toString() {
		return "Pokemon [number=" + number + ", name=" + name + ", healthPoints=" + healthPoints + ", types=" + types
				+ ", evolution=" + evolution + "]";
	}
}
