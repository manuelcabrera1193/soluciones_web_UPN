package com.example.demo.entities;

import java.util.Date;
/*Mapeo relacional de objetos ORM-JPA*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "firstname", nullable = false, length = 45)
	private String firstname;

	@NotEmpty(message = "Ingrese apellido")
	@Column(name = "lastname", nullable = false, length = 45)
	private String lastname;

	@NotBlank(message = "Ingrese email")
	@Email
	@Column(name = "emailEmployee", nullable = false, length = 45)
	private String emailEmployee;
	
	@ManyToOne
	@JoinColumn(name = "idDepartment", nullable = false)
	private Department department; /* @ManyToOne */

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int idEmployee, @NotEmpty(message = "Ingrese nombre") String firstname,
			@NotEmpty(message = "Ingrese apellido") String lastname,
			@NotBlank(message = "Ingrese email") @Email String emailEmployee, Department department) {
		super();
		this.idEmployee = idEmployee;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailEmployee = emailEmployee;
		this.department = department;
	}

	public int getIdEMployee() {
		return idEmployee;
	}

	public void setIdEMployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailEmployee() {
		return emailEmployee;
	}

	public void setEmailEmployee(String emailEmployee) {
		this.emailEmployee = emailEmployee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
	

}
