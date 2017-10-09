package ar.edu.unlam.diit.scaw.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Respuestas {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id_respuesta;
	private Integer idPregunta;
	private String respuesta;
	private Integer idTipoRespuesta;
	
	public Respuestas() {
		
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
