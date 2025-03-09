package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Data_Jpa_Actor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

	@Column(name="Actor_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aid;

	@Column(name="Actor_name")
	private String aname;

	@Column(name="Actor_category")
	private String category;

	@Column(name="Actor_Mbl_No")
	private Long mobileNo;


}
