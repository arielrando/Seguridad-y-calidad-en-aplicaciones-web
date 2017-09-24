package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Examen;

public interface ExamenService {

	public void save(Examen examen);

	public List<Examen> examenes();

}
