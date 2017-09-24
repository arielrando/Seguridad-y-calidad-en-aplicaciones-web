package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Preguntas;

public interface PreguntasService {
	
	public void save(Preguntas preguntas);

	public List<Preguntas> findAll();

}
