package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import ar.edu.unlam.diit.scaw.daos.ExamenDao;
import ar.edu.unlam.diit.scaw.daos.impl.ExamenDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.services.ExamenService;

public class ExamenServiceImpl implements ExamenService {
	
	private ExamenDao examenHsqldb;
	
	public ExamenServiceImpl() {
		examenHsqldb = new ExamenDaoImpl();
	}

	@Override
	public void save(Examen examen) {
		examenHsqldb.save(examen);
		
	}

	@Override
	public List<Examen> examenes() {
		return examenHsqldb.examenes();
	}

}
