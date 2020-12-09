package com.carguearchivo.backend.app.services;

import java.util.List;

import com.carguearchivo.backend.app.model.entity.EmpleadoDepartamento;

public interface IEmpleadoHasDepartamentoService {

	public List<EmpleadoDepartamento> findAll();
	
	public EmpleadoDepartamento findById(Integer id);
	
	public void create(EmpleadoDepartamento empleadoDepartamento);
	
	public void delete(EmpleadoDepartamento empleadoDepartamento);
	
	public void update(EmpleadoDepartamento empleadoDepartamento);

	public List<Object> findGroupForDepartamento();

	public List<EmpleadoDepartamento> findForDepartamento(Integer departamentoId);
	
}
