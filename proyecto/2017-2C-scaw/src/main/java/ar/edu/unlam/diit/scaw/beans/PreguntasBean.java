package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ar.edu.unlam.diit.scaw.entities.Preguntas;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.PreguntasService;
import ar.edu.unlam.diit.scaw.services.impl.PreguntasServiceImpl;

@ManagedBean(name = "preguntasBean", eager = true)
@RequestScoped
public class PreguntasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer idExamen;
	private String pregunta;
	
	PreguntasService preguntasService;
	
	public PreguntasBean() {
		preguntasService =(PreguntasService) new PreguntasServiceImpl();
	}

	public PreguntasBean(Integer id, Integer idExamen, String pregunta) {
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

	public PreguntasService getPreguntaService() {
		return preguntasService;
	}

	public void setPreguntaService(PreguntasService preguntaService) {
		this.preguntasService = preguntaService;
	}
	
	public List<Preguntas> getFindAll() {
		List<Preguntas> list = preguntasService.findAll();
		return list;
	}

}
