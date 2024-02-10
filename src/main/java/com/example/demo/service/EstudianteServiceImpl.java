package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.LightEstudianteTO;

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

	@Override
	public List<Estudiante> searchAll(String gender) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.selectAll(gender);
	}

	@Override
	public List<EstudianteTO> searchAllTO() {
		// TODO Auto-generated method stub
		List<Estudiante> list = this.estudianteRepository.selectAll("M");
		List<EstudianteTO> listTO = new ArrayList<>();
		for (Estudiante est : list) {
			listTO.add(this.convert(est));
		}
		return listTO;
	}

	private EstudianteTO convert(Estudiante estudiante) {
		EstudianteTO estudianteTO = new EstudianteTO();
		estudianteTO.setLastName(estudiante.getLastName());
		;
		estudianteTO.setName(estudiante.getName());
		estudianteTO.setGender(estudiante.getGender());
		estudianteTO.setId(estudiante.getId());
		estudianteTO.setBirthdate(estudiante.getBirthdate());
		;
		return estudianteTO;
	}

	@Override
	public EstudianteTO searchTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convert(this.estudianteRepository.select(id));
	}

	@Override
	public LightEstudianteTO searchLightTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convertLightTO(this.estudianteRepository.select(id));
	}

	private LightEstudianteTO convertLightTO(Estudiante estudiante) {
		LightEstudianteTO lightEstudianteTO = new LightEstudianteTO();
		lightEstudianteTO.setName(estudiante.getName());
		;

		return lightEstudianteTO;
	}
}
