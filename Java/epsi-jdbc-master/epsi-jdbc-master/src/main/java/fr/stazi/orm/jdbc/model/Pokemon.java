package fr.stazi.orm.jdbc.model;

import java.util.List;

public class Pokemon {
	private long id;
	private int number;
	private String name;
	private int healthPoints;
	private List<Type> types;
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
