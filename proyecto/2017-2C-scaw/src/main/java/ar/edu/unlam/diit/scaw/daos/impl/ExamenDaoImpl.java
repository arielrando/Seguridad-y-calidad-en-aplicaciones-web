package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlam.diit.scaw.configs.HsqlDataSource;
import ar.edu.unlam.diit.scaw.daos.ExamenDao;
import ar.edu.unlam.diit.scaw.entities.Examen;

public class ExamenDaoImpl implements ExamenDao {

	HsqlDataSource dataSource = new HsqlDataSource();
	Connection conn;

	@Override
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

	@Override
	public List<Examen> examenes() {
		List<Examen> ll = new LinkedList<Examen>();

		try {
			conn = (dataSource.dataSource()).getConnection();

			Statement query;

			query = conn.createStatement();

			ResultSet rs = query.executeQuery(
					"SELECT E.id, E.nombre, E.idMateria, M.nombre AS nombreMateria, E.idEstadoExamen, EE.descripcion AS estadoExamen FROM Examenes AS E "
							+ "INNER JOIN Materias AS M ON E.idMateria = M.id "
							+ "INNER JOIN EstadosExamenes AS EE ON E.idEstadoExamen = EE.id"
					);

			while (rs.next()) {


				Integer id = rs.getInt("id");
				String nombreExamen = rs.getString("nombre");
				Integer idMateria = rs.getInt("idMateria");
				String nombreMateria = rs.getString("nombreMateria");
				Integer idEstadoExamen = rs.getInt("idEstadoExamen");
				String estadoExamen = rs.getString("estadoExamen");

				Examen examen = new Examen();
				examen.setId(id);
				examen.setNombre(nombreExamen);
				examen.setIdMateria(idMateria);;
				examen.setNombreMateria(nombreMateria);;
				examen.setIdEstadoExamen(idEstadoExamen);;
				examen.setEstadoExamen(estadoExamen);;

				ll.add(examen);
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}

}
