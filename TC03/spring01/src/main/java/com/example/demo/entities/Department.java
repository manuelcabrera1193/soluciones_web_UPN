package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartment;

	@NotEmpty(message = "Ingrese nombre de departamento")
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int idDepartment, @NotEmpty(message = "Ingrese nombre de departamento") String name) {
		super();
		this.idDepartment = idDepartment;
		this.name = name;
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
