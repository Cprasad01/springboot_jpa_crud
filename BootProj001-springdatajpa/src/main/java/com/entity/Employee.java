package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Employeespringjpapratice")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Column(name="emp_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator
	private Integer emp_id;
	
	@Column(name="Empname")
	private String empname;
	
	@Column(name="Emp_desg")
	private String desgniation;
	 
	@Column(name="Emp_income")
	private Double income;

}
