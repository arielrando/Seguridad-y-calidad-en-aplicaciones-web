package ar.edu.unlam.diit.scaw.entities;

import java.io.Serializable;

public class Preguntas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idExamen;
	private String pregunta;
	
	public Preguntas() {
		
	}

	public Preguntas(Integer id, Integer idExamen, String pregunta) {
		super();
		this.id = id;
		this.idExamen = idExamen;
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	

}
