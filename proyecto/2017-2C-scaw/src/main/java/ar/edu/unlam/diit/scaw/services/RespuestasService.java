package ar.edu.unlam.diit.scaw.services;

import ar.edu.unlam.diit.scaw.entities.Respuestas;

public interface RespuestasService {

	void cargarRespuestasPorIdPregunta(int parseInt);

	void saveRespuestas(Respuestas respuestas);

}
