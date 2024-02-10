package com.example.demo.service.to;



import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MateriaTO implements Serializable{
	/**
	 * 
	 */
	//Con esto le damos un ID al objeto que se esta serializando 
	private static final long serialVersionUID = 2L;
	
	private Integer id;

	private String name;

	private String credits;

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

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	
	
	

}
