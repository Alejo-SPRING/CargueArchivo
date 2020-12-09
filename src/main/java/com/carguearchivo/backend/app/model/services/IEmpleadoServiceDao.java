package com.carguearchivo.backend.app.model.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.carguearchivo.backend.app.model.entity.Empleado;

public interface IEmpleadoServiceDao extends CrudRepository<Empleado, Integer>{

	@Query(value = "SELECT * FROM Empleados ORDER BY salario DESC LIMIT 5", nativeQuery=true)
	List<Empleado> findSalario();
	
}
