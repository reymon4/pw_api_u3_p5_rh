package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
//CON ESTO ELIMINAMOS LAS DEPENDENCIAS CÍCLICAS DE LOS OBJETOS
@JsonIgnoreProperties(value="materias")
//NO DEBEMOS PONERLO. ESTO SE SOLUCIONA CON HATEOAS
public class Estudiante {

	// Por buena practica se pone como prefijo los cuatro primeros caracteres del
	// nombre de la tabla
	@Id
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	// El name es el nombre de la anotacion. Es decir, de la sequencia
	@SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize=1)
	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_name")

	private String name;
	@Column(name = "estu_last_name")
	
	private String lastName;
	@Column(name = "estu_gender")
	private String gender;
	@Column(name = "estu_birthdate")
	private LocalDateTime birthdate;
	//Tarea10
	@Column(name = "estu_email")
	private String email;
	@Column(name = "estu_phone_number")
	private String phoneNumber;
	@Column(name = "estu_address")
	private String address;
	@Column(name = "estu_school")
	private String school;
	@Column(name = "estu_program")
	private String program;

	@OneToMany(mappedBy="estudiante")
	private List<Materia> materias;
	

	// Getters & setters
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
	

	
	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
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
