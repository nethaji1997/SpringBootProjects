package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Version
    private Integer version;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String phone;
	private String dateOfBirth;
	private String jobTitle;
}
