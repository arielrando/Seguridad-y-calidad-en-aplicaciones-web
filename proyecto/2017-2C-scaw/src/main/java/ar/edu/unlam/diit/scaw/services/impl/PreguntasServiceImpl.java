package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import ar.edu.unlam.diit.scaw.daos.PreguntasDao;
import ar.edu.unlam.diit.scaw.entities.Preguntas;
import ar.edu.unlam.diit.scaw.services.PreguntasService;

public class PreguntasServiceImpl implements PreguntasService {
	
	private PreguntasDao preguntasHsqldb;

	@Override
	public void save(Preguntas preguntas) {
		preguntasHsqldb.save(preguntas);
		
	}
	
	@Override
	public List<Preguntas> findAll() {
		return preguntasHsqldb.findAll();
	}
	
	

}
