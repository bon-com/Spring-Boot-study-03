package com.example.demo05.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo05.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("SELECT c FROM Customer c ORDER BY c.id DESC")
	List<Customer> findAllOrderByIdDesc();
	
	@Query("SELECT c FROM Customer c WHERE c.firstName = :firstName")
	Customer findByFirstName(String firstName);
	
	
	@Query(value = "SELECT id, first_name, last_name FROM customer WHERE last_name = :lastName", nativeQuery = true)
	Customer findByLastName(String lastName);
}
