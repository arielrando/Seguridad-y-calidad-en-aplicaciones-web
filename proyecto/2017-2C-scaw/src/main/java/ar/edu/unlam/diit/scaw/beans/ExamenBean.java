package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.entities.Materia;
import ar.edu.unlam.diit.scaw.services.ExamenService;

@ManagedBean(name = "examenBean", eager = true)
@RequestScoped
public class ExamenBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id = null;
	private String nombre = null;
	private Integer idMateria = null;
	private Integer idEstadoExamen = null;
	
	ExamenService examenService;

	public ExamenBean() {
		super();
	}

	public ExamenBean(Integer id, String nombre, Integer idMateria, Integer idEstadoExamen,
			ExamenService examenService) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMateria = idMateria;
		this.idEstadoExamen = idEstadoExamen;
		this.examenService = examenService;
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

	public ExamenService getExamenService() {
		return examenService;
	}

	public void setExamenService(ExamenService examenService) {
		this.examenService = examenService;
	}
	
	public String save() {
		Examen examen = buildExamen();
		
		examenService.save(examen);
		
		return "Examenes";
		
	}
	
	private Examen buildExamen() {
		Examen examen = new Examen();
		
		examen.setNombre(this.nombre);
		examen.setIdMateria(this.idMateria);
		examen.setIdEstadoExamen(this.idEstadoExamen);
		
		return examen;
		
	}
	
	

}
