package com.qa.AvengersInitiativeProject.repo;

import org.springframework.stereotype.Repository;
import com.qa.AvengersInitiativeProject.Domain.Avenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public class AvengerRepo extends JpaRepository<Avenger, Long> {
	
//	Derived Query
	List<Avenger> findByFirstName(String firstName);
	List<Avenger> findByLastName(String lastName);
	List<Avenger> findByFirstNameStartingWith(String name);
	
//	Manual SQL Query
	@Query(value = "SELECT * FROM avenger WHERE power = ?1", nativeQuery=true)
	Optional<Avenger> findByPower(String power);

}
