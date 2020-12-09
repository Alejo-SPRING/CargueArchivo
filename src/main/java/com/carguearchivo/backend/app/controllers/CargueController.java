package com.carguearchivo.backend.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.carguearchivo.backend.app.model.entity.Empleado;
import com.carguearchivo.backend.app.model.entity.EmpleadoDepartamento;
import com.carguearchivo.backend.app.services.IEmpleadoHasDepartamentoService;
import com.carguearchivo.backend.app.services.IEmpleadoService;
import com.carguearchivo.backend.app.services.IUploadFileService;

@RestController
@RequestScope
public class CargueController {

	private Map<String, Object> body = new HashMap<>();
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IUploadFileService uploadFileService;
	@Autowired
	private IEmpleadoHasDepartamentoService empleadoHasDepartamentoService;
	
	@GetMapping("/cargue")
	public ResponseEntity<?> cargue(@RequestParam(name = "file") MultipartFile file) {
		try {
			uploadFileService.upload(file);
			empleadoService.create();
			body.put("mensaje", "¡Cargue finalizado!");
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.CREATED);
		} catch (IOException e) {
			body.put("mensaje", "¡Error al cargar la imagen!");
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(DataAccessException e2) {
			body.put("mensaje", "¡Error al crear los datos!" + e2.getMessage()  + ":" + e2.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findForDepartamentoGroup")
	public ResponseEntity<?> findGroupForDepartamento() {
		return new ResponseEntity<List<Object>>(empleadoHasDepartamentoService.findGroupForDepartamento(), HttpStatus.OK);
	}
	
	@GetMapping("/findSalario")
	public ResponseEntity<?> findMaxSalario(){
		return new ResponseEntity<List<Empleado>>(empleadoService.findSalario(), HttpStatus.OK);
	}
	
	@GetMapping("/findEmpleadosForDepartamento/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") Integer id) {
		return new ResponseEntity<List<EmpleadoDepartamento>>(empleadoHasDepartamentoService.findForDepartamento(id), HttpStatus.OK);
	}
	
}
