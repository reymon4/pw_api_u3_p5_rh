package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional

public class ProfesorRepositoryImpl implements IProfesorRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(profesor);
	}

	@Override
	public void update(Profesor profesor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(profesor);
	}

	@Override
	public void partialUpdate(String lastName, String name, Integer id, String email) {
		// TODO Auto-generated method stub
		Query query = this.entityManager
				.createQuery("UPDATE Profesor p SET p.name=:v1, p.lastName=:v2, p.email=:v4 WHERE p.id=:v3");
		query.setParameter("v1", name);
		query.setParameter("v2", lastName);
		query.setParameter("v3", id);
		query.setParameter("v4", email);
		//Esta funcion retorna la cantidad de registros que se actualizaron
		query.executeUpdate();
		
	}

	@Override
	public Profesor select(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Profesor.class, id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.select(id));
	}

	@Override
	public List<Profesor> selectAll(String gender) {
		// TODO Auto-generated method stub
		TypedQuery<Profesor> query = this.entityManager.createQuery("SELECT p FROM Profesor p WHERE p.gender =:variable", Profesor.class);
		query.setParameter("variable", gender);
		return query.getResultList();
	}

}
