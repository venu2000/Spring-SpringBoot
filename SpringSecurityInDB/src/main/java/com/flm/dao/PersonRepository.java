package com.flm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.model.Person;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	
	public Person findPersonByUserName (String username);
	

}
