package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

//API es la creación de un proyecto con un fin específico
@RestController // Servicio
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
	// Implementamos una API RestFul

	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes
	// Capacidades
	@GetMapping(path = "/search")
	public Estudiante search() {
		return this.estudianteService.search(1);
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody Estudiante estudiante) {
		this.estudianteService.save(estudiante);
	}

	@PutMapping(path = "/update")
	public void update(@RequestBody Estudiante estudiante) {
		this.estudianteService.update(estudiante);
	}

	@PatchMapping(path = "/partialUpdate")
	public void partialUpdate(@RequestBody Estudiante estudiante) {
		this.estudianteService.partialUpdate(estudiante.getLastName(), estudiante.getName(), estudiante.getId());
	}
	@DeleteMapping(path="/delete")
	public void delete() {
		this.estudianteService.delete(1);
	}
}
