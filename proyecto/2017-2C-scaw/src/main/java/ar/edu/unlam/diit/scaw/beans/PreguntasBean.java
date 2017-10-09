package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.entities.Preguntas;
import ar.edu.unlam.diit.scaw.services.PreguntasService;
import ar.edu.unlam.diit.scaw.services.impl.PreguntasServiceImpl;

@ManagedBean(name = "preguntasBean", eager = true)
@RequestScoped
public class PreguntasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pregunta = null;
	private Integer id_pregunta = null;
	private Integer idExamen = null;

	PreguntasService service;

	public PreguntasBean() {
		super();
		service = (PreguntasService) new PreguntasServiceImpl();
	}

	public PreguntasBean(String pregunta, Integer id_pregunta, Integer idExamen) {
		super();
		this.pregunta = pregunta;
		this.id_pregunta = id_pregunta;
		this.idExamen = idExamen;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Integer getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(Integer id_pregunta) {
		this.id_pregunta = id_pregunta;
	}

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public PreguntasService getService() {
		return service;
	}

	public void setService(PreguntasService service) {
		this.service = service;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//Listado de los exámenes y preguntas por id
	public List<Preguntas> getPreguntasPorId() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		List<Preguntas> list = new ArrayList<>();
		list = service.preguntasPorId(Integer.parseInt(params.get("id")));
		return list;
	}

	public String savePreguntas() {

		Preguntas preguntas = buildPreguntas();
		service.savePreguntas(preguntas);
		return "preguntas";
	}

	private Preguntas buildPreguntas() {
		Preguntas preguntas = new Preguntas();

		preguntas.setId_pregunta(this.id_pregunta);
		preguntas.setIdExamen(this.idExamen);
		preguntas.setPregunta(this.pregunta);

		return preguntas;
	}

	//Borrar Pregunta
	public String borrarPregunta() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		service.borrarPregunta(Integer.parseInt(params.get("idParamBorrarPregunta")));
		return "preguntas";
	}

	public String cargarPreguntasPorIdExamen(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		service.cargarPreguntasPorExamen(Integer.parseInt(params.get("id")));
		return "preguntas";
	}



}
