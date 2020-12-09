package com.carguearchivo.backend.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carguearchivo.backend.app.model.entity.EmpleadoDepartamento;
import com.carguearchivo.backend.app.model.services.IEmpleadoHasDepartamentoServiceDao;

@Service
public class EmpleadoHasDepartamentoServiceImpl implements IEmpleadoHasDepartamentoService{

	@Autowired
	private IEmpleadoHasDepartamentoServiceDao empleadoHasDepartamentoDao;
	
	@Override
	public List<EmpleadoDepartamento> findAll() {
		return (List<EmpleadoDepartamento>) empleadoHasDepartamentoDao.findAll();
	}

	@Override
	public EmpleadoDepartamento findById(Integer id) {
		return empleadoHasDepartamentoDao.findById(id).orElse(null);
	}

	@Override
	public List<EmpleadoDepartamento> findForDepartamento(Integer departamentoId) {
		return empleadoHasDepartamentoDao.findForDepartamentoId(departamentoId); 
	}
	
	@Override
	public List<Object> findGroupForDepartamento() {
		return empleadoHasDepartamentoDao.findGroupForDepartamento();
	}
	
	@Override
	public void create(EmpleadoDepartamento empleadoDepartamento) {
		empleadoHasDepartamentoDao.save(empleadoDepartamento);
	}

	@Override
	public void delete(EmpleadoDepartamento empleadoDepartamento) {
		empleadoHasDepartamentoDao.delete(empleadoDepartamento);
	}

	@Override
	public void update(EmpleadoDepartamento empleadoDepartamento) {
		empleadoHasDepartamentoDao.save(empleadoDepartamento);
	}

}
