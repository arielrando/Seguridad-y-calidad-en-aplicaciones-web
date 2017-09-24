package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.services.ExamenService;
import ar.edu.unlam.diit.scaw.services.MateriaService;
import ar.edu.unlam.diit.scaw.services.impl.ExamenServiceImpl;
import ar.edu.unlam.diit.scaw.services.impl.MateriaServiceImpl;

@ManagedBean(name = "examenBean", eager = true)
@RequestScoped
public class ExamenBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id = null;
	private String nombre = null;
	private Integer idMateria = null;
	private String nombreMateria = null;
	private Integer idEstadoExamen = null;
	private String estadoExamen = null;
	
	ExamenService examenService;

	public ExamenBean() {
		super();
		examenService = (ExamenService) new ExamenServiceImpl();
	}

	public ExamenBean(int id, String nombre, int idMateria, String nombreMateria, int idEstadoExamen, String estadoExamen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
		this.idEstadoExamen = idEstadoExamen;
		this.estadoExamen = estadoExamen;
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

	public String save() {
		Examen examen = buildExamen();
		
		examenService.save(examen);
		
		return "Examenes";
		
	}
	
	private Examen buildExamen() {
		Examen examen = new Examen();
		
		examen.setNombre(this.nombre);
		examen.setIdMateria(this.idMateria);
		examen.setNombreMateria(nombreMateria);
		examen.setIdEstadoExamen(this.idEstadoExamen);
		examen.setEstadoExamen(estadoExamen);
		
		return examen;
		
	}
	
	//Listado de todas los materias
		public List<Examen> getExamenes() {
			List<Examen> list = examenService.examenes();
			return list;
		}
	
	

}
