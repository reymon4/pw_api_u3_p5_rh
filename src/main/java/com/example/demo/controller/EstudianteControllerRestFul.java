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
	
	@GetMapping(path = "/search/{id}/{edad}")
	// Se debe colocar el mismo nombre del path variable en el método
	//El Path variable se usa cuando queremos obtener un recurso específico
	//PARA USAR VARIOS PATH VARIABLE
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/search/{id}/{gender}
	public Estudiante search(@PathVariable Integer id, @PathVariable Integer edad) {
		return this.estudianteService.search(id);
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

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		this.estudianteService.delete(id);
	}
	
	//Cuando deseamos obtener una lista, filtrándolos según la necesidad usamos RequestParam
	
	//PARA USAR VARIOS REQUESTPARAM
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/searchAll?gender=M&edad=18
	@GetMapping(path = "/searchAll")
	public List<Estudiante> searchAll(@RequestParam String gender, @RequestParam String edad) {
		return this.estudianteService.searchAll(gender);
	}
}
