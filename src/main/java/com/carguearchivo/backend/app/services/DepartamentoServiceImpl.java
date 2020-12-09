package com.carguearchivo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carguearchivo.backend.app.model.entity.Departamento;
import com.carguearchivo.backend.app.model.services.IDepartamentoServiceDao;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

	@Autowired
	private IDepartamentoServiceDao departamentoDao;
	
	@Override
	public List<Departamento> findAll() {
		return (List<Departamento>) departamentoDao.findAll();
	}

	@Override
	public Departamento findById(Integer id) {
		return departamentoDao.findById(id).orElse(null);
	}

	@Override
	public Departamento findByNombre(String nombre) {
		return departamentoDao.findByNombre(nombre);
	}
	
	@Override
	public void create(Departamento departamento) {
		departamentoDao.save(departamento);
	}

	@Override
	public void delete(Departamento departamento) {
		departamentoDao.delete(departamento);
	}

	@Override
	public void update(Departamento departamento) {
		departamentoDao.save(departamento);
	}

}
