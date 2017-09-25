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
	private Integer id;
	private String nombre;
	private String nombreMateria;
	private String descripcion;
	private Integer idMateria;
	private Integer idEstadoExamen;
	private String pregunta;
	private Integer idExamen;
	private Integer id_pregunta;
	private Integer id_respuesta;
	private Integer idPregunta;
	private String respuesta;
	private Integer idTipoRespuesta;

	public Examen() {
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
	
	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	
	public Integer getIdEstadoExamen() {
		return idEstadoExamen;
	}

	public void setIdEstadoExamen(Integer idEstadoExamen) {
		this.idEstadoExamen = idEstadoExamen;
	}
	
	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}
	
	public Integer getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(Integer id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	
	public Integer getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(Integer id_respuesta) {
		this.id_respuesta = id_respuesta;
	}
	
	public Integer getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	public Integer getIdTipoRespuesta() {
		return idTipoRespuesta;
	}

	public void setIdTipoRespuesta(Integer idTipoRespuesta) {
		this.idTipoRespuesta = idTipoRespuesta;
	}

}
