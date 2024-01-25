package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;


//API es la creación de un proyecto con un fin específico
@RestController //Servicio

public class EstudianteControllerRestFul {
	//Implementamos una API RestFul

	private IEstudianteService estudianteService;
	
	//Capacidades
	public void save(Estudiante estudiante) {
		
	}
}
