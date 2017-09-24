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
	private String nombreMateria;
	private int idEstadoExamen;
	private String estadoExamen;
	
	public Examen(){
		
	}
	
	public Examen(int id, String nombre, int idMateria, String nombreMateria, int idEstadoExamen, String estadoExamen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
		this.idEstadoExamen = idEstadoExamen;
		this.estadoExamen = estadoExamen;
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

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getEstadoExamen() {
		return estadoExamen;
	}

	public void setEstadoExamen(String estadoExamen) {
		this.estadoExamen = estadoExamen;
	}
}
