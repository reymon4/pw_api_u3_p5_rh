package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class LightEstudianteTO  extends RepresentationModel<LightEstudianteTO>implements Serializable{
	/**
	 * 
	 */
	//Con esto le damos un ID al objeto que se esta serializando 
	private static final long serialVersionUID = 3L;

	private Integer id;

	private String name;
	
	private String school;
	
	//getters and setters

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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
}
