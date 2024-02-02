package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController // Servicio
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {
	
	@Autowired
	private IProfesorService profesorService;
	
	// http://localhost:8080/API/v1.0/Matricula/profesores
	
	@GetMapping(path = "/search/{id}/{edad}")
	
	public Profesor search(@PathVariable Integer id, @PathVariable Integer edad) {
		return this.profesorService.search(id);
	}
	@PostMapping(path = "/save")
	public void save(@RequestBody Profesor profesor) {
		this.profesorService.save(profesor);
	}

	@PutMapping(path = "/update")
	public void update(@RequestBody Profesor profesor) {
		this.profesorService.update(profesor);
	}

	@PatchMapping(path = "/partialUpdate")
	public void partialUpdate(@RequestBody Profesor profesor) {
		this.profesorService.partialUpdate(profesor.getLastName(), profesor.getName(), profesor.getId(), profesor.getEmail());
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		this.profesorService.delete(id);
	}
	
	
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/searchAll?gender=M&edad=18
	@GetMapping(path = "/searchAll")
	public List<Profesor> searchAll(@RequestParam String gender, @RequestParam String edad) {
		return this.profesorService.searchAll(gender);
	}
	
	
}
