package com.carguearchivo.backend.app.model.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carguearchivo.backend.app.model.entity.Departamento;

public interface IDepartamentoServiceDao extends CrudRepository<Departamento, Integer>{

	@Query("SELECT d FROM Departamento d WHERE d.nombre = :nombre")
	Departamento findByNombre(@Param("nombre") String nombre);
	
}
