package ar.edu.unlam.diit.scaw.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Examen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String nombre;
	private int idMateria;
	private int idEstadoExamen;
	
	public Examen(){
		
	}
	
	public Examen(int id, String nombre, int idMateria, int idEstadoExamen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMateria = idMateria;
		this.idEstadoExamen = idEstadoExamen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdEstadoExamen() {
		return idEstadoExamen;
	}

	public void setIdEstadoExamen(int idEstadoExamen) {
		this.idEstadoExamen = idEstadoExamen;
	}
}
