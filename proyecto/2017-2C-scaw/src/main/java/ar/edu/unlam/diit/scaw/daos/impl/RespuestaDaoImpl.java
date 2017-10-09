package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ar.edu.unlam.diit.scaw.configs.HsqlDataSource;
import ar.edu.unlam.diit.scaw.daos.RespuestaDao;
import ar.edu.unlam.diit.scaw.entities.Respuestas;

public class RespuestaDaoImpl implements RespuestaDao {
	
	HsqlDataSource dataSource = new HsqlDataSource();
	Connection conn;

	@Override
	public void cargarRespuestasPorIdPregunta(int parseInt) {
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"SELECT * FROM Respuestas AS R "
					+ "WHERE R.idPregunta = " + parseInt + ";"
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void saveRespuestas(Respuestas respuestas) {
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"INSERT INTO Respuestas (idPregunta, respuesta, idTipoRespuesta) "
					+ "VALUES('" + respuestas.getIdPregunta() + "', '" + respuestas.getRespuesta() + "', '" + respuestas.getIdTipoRespuesta() + "');"
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

}
