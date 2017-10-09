package ar.edu.unlam.diit.scaw.daos;

import ar.edu.unlam.diit.scaw.entities.Respuestas;

public interface RespuestaDao {

	void cargarRespuestasPorIdPregunta(int parseInt);

	void saveRespuestas(Respuestas respuestas);

}
