package com.qa.AvengersInitiativeProject.Domain;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Avenger {
	
	@Id // This column will be the primary key - unique & not null
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "firstname", nullable = false) // This changes the column name to firstname
	private String firstName; // first_name
	
	@Column(nullable = false)
	private String lastName; // last_name
	
	@Column(nullable = false) // could also set unique=true, length=some length
	private String power; // username

	// Default constructor - Spring uses this
	public Avenger() {}
	
	// This would be used for inserting into the DB
	public Avenger(String firstName, String lastName, String power) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.power = power;
	}

	// This would be used for reading from the DB
	public Avenger(long id, String firstName, String lastName, String power) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.power = power;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	
	

}
