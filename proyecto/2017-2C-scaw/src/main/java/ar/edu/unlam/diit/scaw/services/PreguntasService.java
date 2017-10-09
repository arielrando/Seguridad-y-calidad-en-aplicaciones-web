package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Preguntas;

public interface PreguntasService {

	void borrarPregunta(int id);
	
	void savePreguntas(Preguntas preguntas);

	List<Preguntas> preguntasPorId(Integer idExamen);

	void cargarPreguntasPorExamen(Integer id);

}
