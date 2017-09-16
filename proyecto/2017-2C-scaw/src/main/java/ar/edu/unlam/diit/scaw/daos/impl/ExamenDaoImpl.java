package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ar.edu.unlam.diit.scaw.configs.HsqlDataSource;
import ar.edu.unlam.diit.scaw.daos.ExamenDao;
import ar.edu.unlam.diit.scaw.entities.Examen;

public class ExamenDaoImpl implements ExamenDao {

	HsqlDataSource dataSource = new HsqlDataSource();
	Connection conn;

	public void save(Examen examen) {
		try {
			conn = (dataSource.dataSource()).getConnection();

			Statement query;


			query = conn.createStatement();		
			query.executeUpdate(
					"INSERT INTO Examenes (nombre, idmateria, idestadoexamen) "
							+ "VALUES('" + examen.getNombre() + "', '" + examen.getIdMateria() + "', '" + examen.getIdEstadoExamen() + ")"

					);

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}

}
