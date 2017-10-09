package ar.edu.unlam.diit.scaw.services.impl;

import ar.edu.unlam.diit.scaw.daos.RespuestaDao;
import ar.edu.unlam.diit.scaw.daos.impl.RespuestaDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Respuestas;
import ar.edu.unlam.diit.scaw.services.RespuestasService;

public class RespuestasServiceImpl implements RespuestasService {
	
	RespuestaDao respuestaDao;
	
	public RespuestasServiceImpl() {
		respuestaDao = (RespuestaDao) new RespuestaDaoImpl();
	}

	@Override
	public void cargarRespuestasPorIdPregunta(int parseInt) {
		respuestaDao.cargarRespuestasPorIdPregunta(parseInt);
		
	}

	@Override
	public void saveRespuestas(Respuestas respuestas) {
		respuestaDao.saveRespuestas(respuestas);
		
	}

}
