package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Examen;

public interface ExamenDao {

	public List<Examen> examenes();
	public void save(Examen examen);
	public List<Examen> pendientes();
	public List<Examen> habilitados();
	public void aceptarExamen(Integer id);
	public void rechazarExamen(Integer id);
	public void borrarExamen(Integer id);
	public List<Examen>habilitadosPorId (String data);
	public List<Examen>preguntasPorId (String data_examen);
	public void savePreguntas(Examen examen, String data_examen); //cargar preguntas
	public void saveRespuestas(Examen examen, String data_pregunta); //cargar respuestas
	public List<Examen>respuestasPorId (String data_pregunta);
	public void borrarPregunta(Integer id);
}
