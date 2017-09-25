package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;
import ar.edu.unlam.diit.scaw.daos.impl.ExamenDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.services.ExamenService;

public class ExamenServiceImpl implements ExamenService {

	ExamenDaoImpl examenHsql;
	
	public ExamenServiceImpl(){
		examenHsql = new ExamenDaoImpl();
	}
	

	@Override
	public List<Examen> examenes() {
		return examenHsql.examenes();
	}

	public ExamenDaoImpl getExamenHsql() {
		return examenHsql;
	}

	public void setExamenHsql(ExamenDaoImpl examenHsql) {
		this.examenHsql = examenHsql;
	}

	@Override
	public void save(Examen examen) {
		examenHsql.save(examen);
		
	}
	
	//Lista de exámenes pendientes de habilitación
		@Override
		public List<Examen> pendientes() {
			return examenHsql.pendientes();
		}
		
	//Lista de exámenes habilitados para alumnos
		@Override
		public List<Examen> habilitados() {
			return examenHsql.habilitados();
		}
		
	//Lista de exámenes habilitados por id
		@Override
		public List<Examen> habilitadosPorId(String data) {
			return examenHsql.habilitadosPorId(data);
		}
		
	//Lista de preguntas por id
		@Override
		public List<Examen> preguntasPorId(String data_examen) {
			return examenHsql.preguntasPorId(data_examen);
		}
	
	//Lista de preguntas por id
		@Override
		public List<Examen> respuestasPorId(String data_respuesta) {
			return examenHsql.respuestasPorId(data_respuesta);
		}
		
		
	//aceptar un examen
		@Override
		public void aceptarExamen(Integer id) {
			examenHsql.aceptarExamen(id);
			
		}
		
	//rechazar un examen
		@Override
		public void rechazarExamen(Integer id) {
			examenHsql.rechazarExamen(id);
			
		}
		
	//borrar un examen
		@Override
		public void borrarExamen(Integer id) {
			examenHsql.borrarExamen(id);
			
		}
	
	//Carga preguntas al examen
		@Override
		public void savePreguntas(Examen examen, String data_examen) {
			examenHsql.savePreguntas(examen, data_examen);
			
		}
		
	//Carga respuestas al examen
			@Override
			public void saveRespuestas(Examen examen, String data_pregunta) {
				examenHsql.saveRespuestas(examen, data_pregunta);
				
			}
			
			@Override
			public void borrarPregunta(Integer id) {
				examenHsql.borrarPregunta(id);
				
			}
	
	
}
