package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {
	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void save(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insert(estudiante);
	}

	@Override
	public void update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.update(estudiante);
	}

	@Override
	public void partialUpdate(String lastName, String name, Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.partialUpdate(lastName, name, id);
	}

	@Override
	public Estudiante search(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.select(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.delete(id);
	}

}
