package com.carguearchivo.backend.app.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carguearchivo.backend.app.model.entity.Departamento;
import com.carguearchivo.backend.app.model.entity.Empleado;
import com.carguearchivo.backend.app.model.entity.EmpleadoDepartamento;
import com.carguearchivo.backend.app.model.services.IEmpleadoServiceDao;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoServiceDao empleadoDao;
	private Empleado empleado = new Empleado();
	private Departamento departamento = new Departamento();
	@Autowired
	private IDepartamentoService departamentoService;
	@Autowired
	private IEmpleadoHasDepartamentoService empleadoHasDepartamentoService;
	private EmpleadoDepartamento empleadoDepartamento = new EmpleadoDepartamento();

	@Override
	public List<Empleado> findAll() {
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	public Empleado findById(Integer id) {
		return empleadoDao.findById(id).orElse(null);
	}

	@Override
	public List<Empleado> findSalario() {
		return empleadoDao.findSalario();
	}
	
	@Override
	public void create() {
		Path path = Paths.get("archivos");
		File archivo = new File(path.toFile().getAbsolutePath() + "/empleados.csv");
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			line = br.readLine();
			while (null != line) {
				String[] fields = line.split(",");
				if(!fields[0].equalsIgnoreCase("Nombre")) {
					this.empleado.setCargo(fields[1]);
					this.empleado.setSalario(new BigDecimal(fields[2]));
					if (fields[3].equalsIgnoreCase("true")) {
						this.empleado.setTimpoCompleto(true);
					} else {
						this.empleado.setTimpoCompleto(false);
					}
					departamento = departamentoService.findByNombre(fields[4]);
					if(departamento == null) {
						departamento = new Departamento();
						departamento.setNombre(fields[4]);
					}
					empleadoDepartamento.setDepartamento(departamento);
					empleadoDepartamento.setEmpleado(empleado);
					empleadoHasDepartamentoService.create(empleadoDepartamento);
					empleadoDepartamento = new EmpleadoDepartamento();
					empleado = new Empleado();
					departamento = new Departamento();
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Empleado empleado) {
		empleadoDao.delete(empleado);
	}

	@Override
	public void update(Empleado empleado) {
		empleadoDao.save(empleado);
	}

}
