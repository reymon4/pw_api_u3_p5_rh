package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public void update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
	}

	@Override
	public void partialUpdate(String lastName, String name, Integer id) {
		// TODO Auto-generated method stub
		// En el query pasamos el JPQUL del SQL: UPDATE estudiante e set
		// e.estu_name=:valor, e.estu_lastName=:valor2 WHERE e.estu_id=:valor3
		Query query = this.entityManager
				.createQuery("UPDATE Estudiante e SET e.name=:v1, e.last_name=:v2 WHERE e.id=:v3");
		query.setParameter("v1", name);
		query.setParameter("v2", lastName);
		query.setParameter("v3", id);
		//Esta funcion retorna la cantidad de registros que se actualizaron
		query.executeUpdate();
	}

	@Override
	public Estudiante select(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.select(id));
	}

}
