package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.diit.scaw.configs.HsqlDataSource;
import ar.edu.unlam.diit.scaw.daos.PreguntaDao;
import ar.edu.unlam.diit.scaw.entities.Examen;
import ar.edu.unlam.diit.scaw.entities.Preguntas;

public class PreguntaDaoImpl implements PreguntaDao {
	
	HsqlDataSource dataSource = new HsqlDataSource();
	Connection conn;

	@Override
	public void borrarPregunta(int id) {
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"DELETE FROM Preguntas "
					+ "WHERE id_pregunta =" + id + ";"
			);
			query.executeUpdate(
					"DELETE FROM Respuestas "
					+ "WHERE idPregunta =" + id + ";"
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void savePreguntas(Preguntas preguntas) {
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"INSERT INTO Preguntas (idExamen, pregunta) "
					+ "VALUES('" + preguntas.getIdExamen() + "', '" + preguntas.getPregunta() +"');"
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public void cargarPreguntasPorExamen(Integer id) {
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.execute(
					"SELECT * FROM Preguntas AS P WHERE P.idExamen = " + id 
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

	@Override
	public List<Preguntas> preguntasPorId(Integer idExamenes) {
		List<Preguntas> ll = new LinkedList<Preguntas>();
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			ResultSet rs = query.executeQuery(
					"SELECT * FROM preguntas "
							+ "where idExamen =" + idExamenes
									);
			while (rs.next()) {
				
				Integer id_pregunta = rs.getInt("id_pregunta");
				Integer idExamen = rs.getInt("idExamen");
				String pregunta = rs.getString("pregunta");
			  
				Preguntas habilitados = new Preguntas();
				habilitados.setId_pregunta(id_pregunta);
				habilitados.setIdExamen(idExamen);
				habilitados.setPregunta(pregunta);
	
				ll.add(habilitados);
			}	
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return ll;
	}

}
