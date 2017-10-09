package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import ar.edu.unlam.diit.scaw.daos.PreguntaDao;
import ar.edu.unlam.diit.scaw.daos.impl.PreguntaDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Preguntas;
import ar.edu.unlam.diit.scaw.services.PreguntasService;

public class PreguntasServiceImpl implements PreguntasService {
	
	PreguntaDao preguntaDao;
	
	public PreguntasServiceImpl() {
		preguntaDao = (PreguntaDao) new PreguntaDaoImpl();
	}
	
	@Override
	public void borrarPregunta(int id) {
		preguntaDao.borrarPregunta(id);
		
	}

	@Override
	public void savePreguntas(Preguntas preguntas) {
		preguntaDao.savePreguntas(preguntas);
		
	}

	@Override
	public void cargarPreguntasPorExamen(Integer id) {
		preguntaDao.cargarPreguntasPorExamen(id);
		
	}

	@Override
	public List<Preguntas> preguntasPorId(Integer idExamen) {
		return preguntaDao.preguntasPorId(idExamen);
	}

}
