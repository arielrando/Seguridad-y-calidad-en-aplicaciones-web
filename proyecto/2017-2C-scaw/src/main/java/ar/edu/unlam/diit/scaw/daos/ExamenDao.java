package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Examen;

public interface ExamenDao {

	void save(Examen examen);

	List<Examen> examenes();

}
