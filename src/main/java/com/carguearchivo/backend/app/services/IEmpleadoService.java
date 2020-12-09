package com.carguearchivo.backend.app.services;

import java.util.List;

import com.carguearchivo.backend.app.model.entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	
	public Empleado findById(Integer id);
	
	public void create();
	
	public void delete(Empleado empleado);
	
	public void update(Empleado empleado);

	public List<Empleado> findSalario();
	
}
