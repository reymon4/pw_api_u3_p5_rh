package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	// Se debe colocar el mismo nombre del path variable en el método
	// El Path variable se usa cuando queremos obtener un recurso específico
	// PARA USAR VARIOS PATH VARIABLE
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/search/{id}/{gender}
	// PARA UN PRODCUCES DE TIPO HTML, DEBO AGREGAR LA DEPENDENCIA CORRESPONDIENTE
	// AL PROYECTO

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Estudiante> search(@PathVariable() Integer id) {
		// 240: Estudiante resource successfully found !
		// También puedo enviar códigos estándar
		// return
		// ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.search(id));
		return ResponseEntity.status(240).body(this.estudianteService.search(id));
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Estudiante estudiante) {
		this.estudianteService.save(estudiante);
	}

	@PutMapping(path = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.update(estudiante);
	}

	// Este se realiza mediante un identificador único
	@PatchMapping(path = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void partialUpdate(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.partialUpdate(estudiante.getLastName(), estudiante.getName(), id);
	}

	@DeleteMapping(path = "/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		this.estudianteService.delete(id);
	}

	// Cuando deseamos obtener una lista, filtrándolos según la necesidad usamos
	// RequestParam

	// PARA USAR VARIOS REQUESTPARAM
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/{cedula}GET
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estudiante>> searchAll(
			@RequestParam(defaultValue = "M", required = false) String gender) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("242 message", "Lista consultada de manera satisfactoria!");
		headers.add("info message", "El sistema va a estar en mantenimiento el finde!");
		// Primero va el body(objeto), cabecera y código
		return new ResponseEntity<>(this.estudianteService.searchAll(gender), headers, 242);
	}
}
