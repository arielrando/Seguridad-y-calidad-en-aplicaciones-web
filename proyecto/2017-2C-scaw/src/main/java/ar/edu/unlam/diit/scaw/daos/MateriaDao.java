package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Materia;

public interface MateriaDao {

	public List<Materia> materias();
	public void save(Materia materia);
	
}
