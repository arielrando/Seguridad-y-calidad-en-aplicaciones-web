package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Preguntas;

public interface PreguntasDao {

	void save(Preguntas preguntas);

	List<Preguntas> findAll();

}
