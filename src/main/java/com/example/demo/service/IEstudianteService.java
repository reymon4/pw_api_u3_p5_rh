package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	
	//Aquí ponemos términos de negocio en los métodos
	public void save(Estudiante estudiante);
	public void update(Estudiante estudiante);
	public void partialUpdate(String lastName, String name, Integer id);
	public Estudiante search(Integer id);
	public void delete(Integer id);
	
	public List<Estudiante> searchAll(String gender);
	
	
	public List<EstudianteTO> searchAllTO();

}
