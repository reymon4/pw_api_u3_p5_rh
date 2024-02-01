package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Profesor;

public interface IProfesorService {
	

	//Aquí ponemos términos de negocio en los métodos
	public void save(Profesor profesor);
	public void update(Profesor profesor);
	public void partialUpdate(String lastName, String name, Integer id, String email);
	public Profesor search(Integer id);
	public void delete(Integer id);
	
	public List<Profesor> searchAll(String gender);
	

}
