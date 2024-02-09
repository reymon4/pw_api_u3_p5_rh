package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository  iMateriaRepository;
	
	@Override
	public List<MateriaTO> searchForStudentId(Integer id) {
		// TODO Auto-generated method stub
		
		List<Materia> lista = this.iMateriaRepository.selectForStudentId(id);
		List<MateriaTO> listaTO = new ArrayList<>();
		for(Materia mat:lista) {
			listaTO.add(this.convert(mat));
		}
		return listaTO;
	}

	private MateriaTO convert(Materia materia) {
		MateriaTO mat = new MateriaTO();
		mat.setId(materia.getId());
		mat.setName(materia.getName());
		mat.setCredits(materia.getCredits());
		return mat;
	}
}
