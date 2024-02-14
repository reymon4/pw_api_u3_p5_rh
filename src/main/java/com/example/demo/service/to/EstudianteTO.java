package com.example.demo.service.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.Column;
//Cuando el objeto va a manejar Hypermedia, se debe extender la clase de RepresentationModel
//solo ponemos cuando es listas
public class EstudianteTO extends RepresentationModel<EstudianteTO> implements Serializable{

	
	/**
	 * 
	 */
	//Con esto le damos un ID al objeto que se esta serializando 
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;

	private String name;

	private String lastName;

	private String gender;

	private LocalDateTime birthdate;
	

	private String email;
	
	private String phoneNumber;
	
	private String address;

	private String school;

	private String program;

	// Set y Get
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
	

}
