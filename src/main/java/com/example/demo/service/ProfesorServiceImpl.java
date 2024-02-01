package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProfesorRepository;
import com.example.demo.repository.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService {

	@Autowired
	private IProfesorRepository profesorRepository;
	
	@Override
	public void save(Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorRepository.insert(profesor);
	}

	@Override
	public void update(Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorRepository.update(profesor);
	}

	@Override
	public void partialUpdate(String lastName, String name, Integer id, String email) {
		// TODO Auto-generated method stub
		this.profesorRepository.partialUpdate(lastName, name, id, email);
	}

	@Override
	public Profesor search(Integer id) {
		// TODO Auto-generated method stub
		return this.profesorRepository.select(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.profesorRepository.delete(id);
	}

	@Override
	public List<Profesor> searchAll(String gender) {
		// TODO Auto-generated method stub
		return this.profesorRepository.selectAll(gender);
	}

}
