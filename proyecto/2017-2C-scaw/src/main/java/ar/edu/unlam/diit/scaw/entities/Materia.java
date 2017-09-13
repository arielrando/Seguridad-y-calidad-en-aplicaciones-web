package ar.edu.unlam.diit.scaw.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	private String nombre;
	private String apellido;
	private String nombreMateria;
	private Integer idDocenteTitular;
	private Integer idEstadoMateria;

	public Materia() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public Integer getIdDocenteTitular() {
		return idDocenteTitular;
	}

	public void setIdDocenteTitular(Integer idDocenteTitular) {
		this.idDocenteTitular = idDocenteTitular;
	}
	
	public Integer getIdEstadoMateria() {
		return idEstadoMateria;
	}

	public void setIdEstadoMateria(Integer idEstadoMateria) {
		this.idEstadoMateria = idEstadoMateria;
	}

}
