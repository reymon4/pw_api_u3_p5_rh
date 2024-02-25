package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@GeneratedValue(generator = "seq_profesor", strategy = GenerationType.SEQUENCE)
	// El name es el nombre de la anotacion. Es decir, de la sequencia
	@SequenceGenerator(name = "seq_profesor", sequenceName = "seq_profesor", allocationSize=1)
	
	@Column(name = "prof_id")
	private Integer id;

	@Column(name = "prof_name")

	private String name;
	
	@Column(name = "prof_last_name")
	
	private String lastName;
	@Column(name = "prof_gender")
	
	private String gender;
	
	
	@Column(name = "prof_birthdate")
	private LocalDateTime birthdate;
	
	@Column(name = "prof_subject")
	private String subject;
	
	@Column(name = "prof_email")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
