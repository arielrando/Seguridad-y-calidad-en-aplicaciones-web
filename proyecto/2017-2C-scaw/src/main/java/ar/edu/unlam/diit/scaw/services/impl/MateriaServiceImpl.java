package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;
import ar.edu.unlam.diit.scaw.daos.impl.MateriaDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Materia;
import ar.edu.unlam.diit.scaw.services.MateriaService;

public class MateriaServiceImpl implements MateriaService {

	MateriaDaoImpl materiaHsql;
	
	public MateriaServiceImpl(){
		materiaHsql = new MateriaDaoImpl();
	}
	

	@Override
	public List<Materia> materias() {
		return materiaHsql.materias();
	}

	public MateriaDaoImpl getMateriaHsql() {
		return materiaHsql;
	}

	public void setMateriaHsql(MateriaDaoImpl materiaHsql) {
		this.materiaHsql = materiaHsql;
	}

	@Override
	public void save(Materia materia) {
		materiaHsql.save(materia);
		
	}
	
	//Lista de docentes
	@Override
	public List<Materia> docentes() {
		return materiaHsql.docentes();
	}
	
	
}
