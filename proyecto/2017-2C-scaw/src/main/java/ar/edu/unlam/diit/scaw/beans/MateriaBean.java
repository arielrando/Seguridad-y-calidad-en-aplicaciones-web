package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ar.edu.unlam.diit.scaw.entities.Materia;
import ar.edu.unlam.diit.scaw.services.MateriaService;
import ar.edu.unlam.diit.scaw.services.impl.MateriaServiceImpl;

@ManagedBean(name = "materiaBean", eager = true)
@RequestScoped
public class MateriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id = null;
	private String nombre = null;
	private String apellido = null;
	private String nombreMateria = null;
	private Integer idDocenteTitular = null;
	private Integer idEstadoMateria = null;
	
	MateriaService service;
	
	public MateriaBean() {
		super();
		service = (MateriaService) new MateriaServiceImpl();
	}
	
	public MateriaBean(Integer id, String nombre, String apellido, Integer idDocenteTitular, Integer idEstadoMateria, String nombreMateria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreMateria = nombreMateria;
		this.idDocenteTitular = idDocenteTitular;
		this.idEstadoMateria = idEstadoMateria;
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
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.nombre = apellido;
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public MateriaService getService() {
		return service;
	}

	public void setService(MateriaService service) {
		this.service = service;
	}
	
	public Integer getIdDocenteTitular() {
		return idDocenteTitular;
	}

	public void setIdDocenteTitular(Integer idDocenteTitular) {
		this.idDocenteTitular = idDocenteTitular;
	}
	
	public Integer getIdEstadoMateria() {
		return idEstadoMateria;
	}

	public void setIdEstadoMateria(Integer idEstadoMateria) {
		this.idEstadoMateria = idEstadoMateria;
	}
	
	public String save() {
		
		Materia materia = buildMateria();
		
		service.save(materia);
		
		return "materias";
	}
	
	//Listado de todas los materias
	public List<Materia> getMaterias() {
		List<Materia> list = service.materias();
		return list;
	}
	
	
	private Materia buildMateria() {
		Materia materia = new Materia();
		
		materia.setId(this.id);
		materia.setNombre(this.nombre);
		materia.setIdDocenteTitular(this.idDocenteTitular);
		materia.setIdEstadoMateria(this.idEstadoMateria);
		
		return materia;
	}

}
