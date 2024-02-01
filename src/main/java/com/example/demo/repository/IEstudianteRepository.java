package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;


public interface IEstudianteRepository {
	//CRUD
	public void insert(Estudiante estudiante);
	public void update(Estudiante estudiante);
	public void partialUpdate(String lastName, String name, Integer id);
	public Estudiante select(Integer id);
	public void delete(Integer id);
	
	
	public List<Estudiante> selectAll(String gender);
	

}
