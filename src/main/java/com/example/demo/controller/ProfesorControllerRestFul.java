package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.example.demo.repository.modelo.Profesor;
import com.example.demo.service.IProfesorService;

@RestController // Servicio
@RequestMapping(path = "/profesores")
public class ProfesorControllerRestFul {
	// PARA PROFESOR USAREMOS LOS CÓDIGOS DESDE EL 260
	@Autowired
	private IProfesorService profesorService;

	// http://localhost:8080/API/v1.0/Matricula/profesores

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profesor> search(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("260 message", "Se ha obtenido de manera exitosa el objeto número"+id);
		return new ResponseEntity<>(this.profesorService.search(id),headers, 260);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Profesor profesor) {
		this.profesorService.save(profesor);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Profesor profesor, @PathVariable Integer id) {
		profesor.setId(id);
		this.profesorService.update(profesor);
	}

	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void partialUpdate(@RequestBody Profesor profesor, @PathVariable Integer id) {
		this.profesorService.partialUpdate(profesor.getLastName(), profesor.getName(), id, profesor.getEmail());
	}

	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		this.profesorService.delete(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/searchAll?gender=M&edad=18
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>> searchAll(@RequestParam(defaultValue = "M", required = false) String gender) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("261 message", "Lista consultada de manera satisfactoria!");
		headers.add("info message", "El sistema va a estar en mantenimiento el finde!");
		return new ResponseEntity<>(this.profesorService.searchAll(gender), headers, 261);
	}

}
