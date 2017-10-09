package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Preguntas;

public interface PreguntaDao {

	void borrarPregunta(int id);

	void savePreguntas(Preguntas preguntas);

	List<Preguntas> preguntasPorId(Integer idExamen);

	void cargarPreguntasPorExamen(Integer id);

}
