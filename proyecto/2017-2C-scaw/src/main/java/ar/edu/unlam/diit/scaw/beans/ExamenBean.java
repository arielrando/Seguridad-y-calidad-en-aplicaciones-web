package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.services.ExamenService;
import ar.edu.unlam.diit.scaw.services.impl.ExamenServiceImpl;

@ManagedBean(name = "examenBean", eager = true)
@RequestScoped
public class ExamenBean<ModelAndView> implements Serializable {

	private static final long serialVersionUID = 1L;


	private Integer id = null;
	private String nombre = null;
	private String nombreMateria = null;
	private Integer idMateria = null;
	private Integer idEstadoExamen = null;
	private Integer idExamen = null;
	private String pregunta = null;
	private Integer id_pregunta = null;
	private Integer id_respuesta = null;
	private Integer idPregunta = null;
	private String respuesta = null;
	private Integer idTipoRespuesta = null;
	
	ExamenService service;
	
	public ExamenBean() {
		super();
		service = (ExamenService) new ExamenServiceImpl();
	}
	
	public ExamenBean(Integer id, String nombre, String nombreMateria, Integer idMateria, Integer idEstadoExamen, String pregunta,
			Integer id_pregunta, Integer id_respuesta, Integer idPregunta, String respuesta, Integer idTipoRespuesta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
		this.idEstadoExamen = idEstadoExamen;
		this.pregunta = pregunta;
		this.id_pregunta = id_pregunta;
		this.idPregunta = idPregunta;
		this.respuesta = respuesta;
		this.idTipoRespuesta = idTipoRespuesta;
	}
	
	public String save() {
		
		Examen examen = buildExamen();
		
		service.save(examen);
		
		return "examenes";
	}
	
	//Listado de todos los examenes
	public List<Examen> getExamenes() {
		List<Examen> list = service.examenes();
		return list;
	}
	
	
	private Examen buildExamen() {
		Examen examen = new Examen();
		
		examen.setId(this.id);
		examen.setNombre(this.nombre);
		examen.setIdMateria(this.idMateria);
		examen.setIdEstadoExamen(this.idEstadoExamen);
		
		return examen;
	}
	
	//Listado de los exámenes pendientes de habilitación
		public List<Examen> getPendientes() {
			List<Examen> list = service.pendientes();
			return list;
		}
		
		//Listado de los exámenes pendientes de habilitación
		public List<Examen> getHabilitados() {
			List<Examen> list = service.habilitados();
			return list;
		}
		
		
		//Listado de los exámenes habilitados para alumnos
		public List<Examen> getHabilitadosPorId() {
			List<Examen> list = service.habilitadosPorId(data);
			return list;
		}
		
		//Listado de los exámenes y preguntas por id
		public List<Examen> getPreguntasPorId() {
			List<Examen> list = service.preguntasPorId(data_examen);
			return list;
		}
		
		//Listado de los exámenes y preguntas por id
		public List<Examen> getRespuestasPorId() {
			List<Examen> list = service.respuestasPorId(data_pregunta);
			return list;
		}
		
		//Aceptar pendiente
		public String aceptarExamen() {
			
			Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id2 = params.get("idParamAceptarExamen");
			List<Examen> list = service.preguntasPorId(id2);
			
			if (list.size()>0)
			{int id = Integer.parseInt(id2);
	
			service.aceptarExamen(id);
			return "examenesPendientes";}
			else
			{return "examenes";}
			
			
		}
		
		//Rechazar pendiente
		public String rechazarExamen() {
				
				Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
				String id2 = params.get("idParamRechazarExamen");
				int id = Integer.parseInt(id2);
		
				service.rechazarExamen(id);
				return "examenesPendientes";
			}
		
		//Borrar Examen
		public String borrarExamen() {
				
				Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
				String id2 = params.get("idParamBorrarExamen");
				int id = Integer.parseInt(id2);
		
				service.borrarExamen(id);
				return "examenes";
			}
		
		
		// PASAR POR PARÁMETROS
		
		public String data = "1";
		
		public String getData() {
		      return data;
		   }
		
		public void setData(String data) {
		      this.data = data;
		   }
		
		//id para examen
		public String data_examen = "1";
		
		public String getData_examen() {
		      return data_examen;
		   }
		
		public void setData_examen(String data_examen) {
		      this.data_examen = data_examen;
		   }
		
		//id para pregunta
		public String data_pregunta = "1";
		
		public String getData_pregunta() {
		      return data_pregunta;
		   }
		
		public void setData_pregunta(String data_pregunta) {
		      this.data_pregunta = data_pregunta;
		   }
		
		public String realizarExamenAlumnos(){
		      FacesContext fc = FacesContext.getCurrentInstance();
		      Map<String,String> params = 
		      fc.getExternalContext().getRequestParameterMap();
		      data =  params.get("id"); 
		      return "realizarExamenAlumnos";
		   }
		
		public String cargarPreguntasPorIdExamen(){
		      FacesContext fc = FacesContext.getCurrentInstance();
		      Map<String,String> params = 
		      fc.getExternalContext().getRequestParameterMap();
		      data_examen =  params.get("id"); 
		      return "preguntas";
		   }
		
		public String cargarRespuestasPorIdPregunta(){
		      FacesContext fc = FacesContext.getCurrentInstance();
		      Map<String,String> params = 
		      fc.getExternalContext().getRequestParameterMap();
		      data_pregunta =  params.get("id_pregunta"); 
		      return "respuestas";
		   }
		//FIN PASAR POR PARÁMETROS
	
	//guarda las preguntas del examen	
	public String savePreguntas() {
		
		Examen examen = buildPreguntas();
		
		service.savePreguntas(examen, data_examen);
		
		return "preguntas";
	}
	
	private Examen buildPreguntas() {
		Examen examen = new Examen();
		
		examen.setId_pregunta(this.id_pregunta);
		examen.setIdExamen(this.idExamen);
		examen.setPregunta(this.pregunta);
		
		return examen;
	}
	
	//Borrar Pregunta
	public String borrarPregunta() {
			
			Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id2 = params.get("idParamBorrarPregunta");
			int id = Integer.parseInt(id2);
	
			service.borrarPregunta(id);
			return "preguntas";
		}
	
	//guarda las respuestas de la pregunta
		public String saveRespuestas() {
			
			Examen examen = buildRespuestas();
			
			service.saveRespuestas(examen, data_pregunta);
			
			return "respuestas";
		}
		
		private Examen buildRespuestas() {
			Examen examen = new Examen();
			
			examen.setId_respuesta(this.id_respuesta);
			examen.setIdPregunta(this.idPregunta);
			examen.setRespuesta(this.respuesta);
			examen.setIdTipoRespuesta(this.idTipoRespuesta);
			
			return examen;
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
	

	public ExamenService getService() {
		return service;
	}

	public void setService(ExamenService service) {
		this.service = service;
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
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
