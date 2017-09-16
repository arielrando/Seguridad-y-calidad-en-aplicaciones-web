package ar.edu.unlam.diit.scaw.services.impl;

import ar.edu.unlam.diit.scaw.daos.ExamenDao;
import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.services.ExamenService;

public class ExamenServiceImpl implements ExamenService {
	
	private ExamenDao examenHsqldb;

	@Override
	public void save(Examen examen) {
		examenHsqldb.save(examen);
		
	}

}
