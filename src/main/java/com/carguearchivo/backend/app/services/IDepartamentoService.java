package com.carguearchivo.backend.app.services;

import java.util.List;

import com.carguearchivo.backend.app.model.entity.Departamento;

public interface IDepartamentoService {

	public List<Departamento> findAll();
	
	public Departamento findById(Integer id);
	
	public void create(Departamento departamento);
	
	public void delete(Departamento departamento);
	
	public void update(Departamento departamento);

	public Departamento findByNombre(String nombre);
	
}
