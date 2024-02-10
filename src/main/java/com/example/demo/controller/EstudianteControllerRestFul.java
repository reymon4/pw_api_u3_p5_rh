package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

//API es la creación de un proyecto con un fin específico
@RestController // Servicio
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {
	// Implementamos una API RestFul

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService iMateriaService;

	// http://localhost:8080/API/v1.0/Matricula/estudiantes
	// Capacidades

	// Se debe colocar el mismo nombre del path variable en el método
	// El Path variable se usa cuando queremos obtener un recurso específico
	// PARA USAR VARIOS PATH VARIABLE
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/search/{id}/{gender}
	// PARA UN PRODCUCES DE TIPO HTML, DEBO AGREGAR LA DEPENDENCIA CORRESPONDIENTE
	// AL PROYECTO

	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<EstudianteTO> search(@PathVariable() Integer id) {
		// 240: Estudiante resource successfully found !
		// También puedo enviar códigos estándar
		// return
		// ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.search(id));
		EstudianteTO estu =this.estudianteService.searchTO(id);
		Link link = linkTo(methodOn(EstudianteControllerRestFul.class).searchMateriasForId(estu.getId()))
				.withRel("materias");
		Link link2 = linkTo(methodOn(EstudianteControllerRestFul.class).searchMateriasForId(estu.getId()))
				.withSelfRel();
		estu.add(link);
		estu.add(link2);
		return ResponseEntity.status(240).body(estu);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Estudiante estudiante) {
		this.estudianteService.save(estudiante);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.update(estudiante);
	}

	// Este se realiza mediante un identificador único
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void partialUpdate(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		this.estudianteService.partialUpdate(estudiante.getLastName(), estudiante.getName(), id);
	}

	@DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		this.estudianteService.delete(id);
	}

	// Cuando deseamos obtener una lista, filtrándolos según la necesidad usamos
	// RequestParam

	// PARA USAR VARIOS REQUESTPARAM
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/{cedula}GET
	@GetMapping(path = "/tmp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estudiante>> searchAll(
			@RequestParam(defaultValue = "M", required = false) String gender) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("242 message", "Lista consultada de manera satisfactoria!");
		headers.add("info message", "El sistema va a estar en mantenimiento el finde!");
		// Primero va el body(objeto), cabecera y código
		return new ResponseEntity<>(this.estudianteService.searchAll(gender), headers, 242);
	}

	/// HATEOAS//////
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> searchAllHATEOAS() {
		List<EstudianteTO> list = this.estudianteService.searchAllTO();
		for (EstudianteTO est : list) {
			// Dentro del methoOn, ponemos el nombre de la clase que queremos que consuma la
			// capacidad
			// No necesariamente debe ser la misma clase
			Link link = linkTo(methodOn(EstudianteControllerRestFul.class).searchMateriasForId(est.getId()))
					.withRel("materias");
			est.add(link);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1/materias GET

	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> searchMateriasForId(@PathVariable Integer id) {
		List<MateriaTO> lista = this.iMateriaService.searchForStudentId(id);
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
}
