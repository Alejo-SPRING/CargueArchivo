package com.carguearchivo.backend.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idempleados")
	private Integer id;
	@Column(name = "cargo")
	private String cargo;
	@Column(name = "salario")
	private BigDecimal salario;
	@Column(name = "tiempoCompleto")
	private boolean timpoCompleto;
	@OneToMany(mappedBy = "empleado")
	private List<EmpleadoDepartamento> empleadoDepartamentoList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public boolean isTimpoCompleto() {
		return timpoCompleto;
	}

	public void setTimpoCompleto(boolean timpoCompleto) {
		this.timpoCompleto = timpoCompleto;
	}

}
