package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.entities.Respuestas;
import ar.edu.unlam.diit.scaw.services.RespuestasService;
import ar.edu.unlam.diit.scaw.services.impl.RespuestasServiceImpl;

@ManagedBean(name = "respuestasBean", eager = true)
@RequestScoped
public class RespuestasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id_respuesta = null;
	private Integer idPregunta = null;
	private String respuesta = null;
	private Integer idTipoRespuesta = null;

	RespuestasService service;

	public RespuestasBean() {
		super();
		service = (RespuestasService) new RespuestasServiceImpl();
	}

	public RespuestasBean(Integer id_respuesta, Integer idPregunta, String respuesta, Integer idTipoRespuesta) {
		super();
		this.id_respuesta = id_respuesta;
		this.idPregunta = idPregunta;
		this.respuesta = respuesta;
		this.idTipoRespuesta = idTipoRespuesta;
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

	public RespuestasService getService() {
		return service;
	}

	public void setService(RespuestasService service) {
		this.service = service;
	}

	public String cargarRespuestasPorIdPregunta(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		service.cargarRespuestasPorIdPregunta(Integer.parseInt(params.get("id_pregunta"))); 
		return "respuestas";
	}

	public String saveRespuestas() {

		Respuestas respuestas = buildRespuestas();

		service.saveRespuestas(respuestas);

		return "respuestas";
	}

	private Respuestas buildRespuestas() {
		Respuestas respuestas = new Respuestas();

		respuestas.setId_respuesta(this.id_respuesta);
		respuestas.setIdPregunta(this.idPregunta);
		respuestas.setRespuesta(this.respuesta);
		respuestas.setIdTipoRespuesta(this.idTipoRespuesta);

		return respuestas;
	}

}
