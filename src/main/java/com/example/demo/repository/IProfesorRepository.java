package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Profesor;

public interface IProfesorRepository {
	
	//CRUD
		public void insert(Profesor profesor);
		public void update(Profesor profesor);
		public void partialUpdate(String lastName, String name, Integer id, String email);
		public Profesor select(Integer id);
		public void delete(Integer id);
		
		
		public List<Profesor> selectAll(String gender);
		

}
