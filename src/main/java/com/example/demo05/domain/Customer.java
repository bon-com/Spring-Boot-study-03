package com.example.demo05.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // ①
@Table(name = "customer")
@Data // ②
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id // ③
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false) // ④
	private String firstName;

	@Column(length = 100, nullable = false)
	private String lastName;
}
