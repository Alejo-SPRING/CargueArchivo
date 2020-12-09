package com.carguearchivo.backend.app.model.services;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.carguearchivo.backend.app.model.entity.EmpleadoDepartamento;

public interface IEmpleadoHasDepartamentoServiceDao extends CrudRepository<EmpleadoDepartamento, Integer>{

	@Query("SELECT SUM(e.empleado.salario), e.departamento.nombre FROM EmpleadoDepartamento e GROUP BY e.departamento.nombre")
	List<Object> findGroupForDepartamento();
	
	@Query("SELECT e FROM EmpleadoDepartamento e WHERE e.departamento.id = :departamentoId")
	List<EmpleadoDepartamento> findForDepartamentoId(@Param("departamentoId") Integer departamentoId);
	
}
