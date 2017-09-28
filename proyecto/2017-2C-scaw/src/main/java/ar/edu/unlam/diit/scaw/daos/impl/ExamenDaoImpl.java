package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import java.sql.Statement;
import ar.edu.unlam.diit.scaw.configs.HsqlDataSource;
import ar.edu.unlam.diit.scaw.daos.ExamenDao;
import ar.edu.unlam.diit.scaw.entities.Examen;

public class ExamenDaoImpl implements ExamenDao {

	HsqlDataSource dataSource = new HsqlDataSource();
	Connection conn;


	@Override
	public List<Examen> examenes() {
		List<Examen> ll = new LinkedList<Examen>();
		
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			query = conn.createStatement();
			
			ResultSet rs = query.executeQuery(
					"SELECT E.id, M.id AS idMateria, E.id AS idEstadoExamen, E.nombre, M.nombre AS nombreMateria, EE.descripcion FROM Examenes AS E "
					+ "INNER JOIN Materias AS M ON M.id = E.idMateria "
					+ "INNER JOIN EstadosExamenes AS EE ON EE.id = E.idEstadoExamen"
					);
	
			while (rs.next()) {
			  
				
				Integer id = rs.getInt("id");
				Integer idMateria = rs.getInt("idMateria");
				Integer idEstadoExamen = rs.getInt("idEstadoExamen");
				String nombre = rs.getString("nombre");
				String nombreMateria = rs.getString("nombreMateria");
				String descripcion = rs.getString("descripcion");
			  
				Examen examen = new Examen();
				examen.setId(id);
				examen.setNombre(nombre);
				examen.setNombreMateria(nombreMateria);
				examen.setIdMateria(idMateria);
				examen.setIdEstadoExamen(idEstadoExamen);
				examen.setDescripcion(descripcion);
				
				ll.add(examen);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	@Override
	public void save(Examen examen) {

		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"INSERT INTO Examenes (nombre, idMateria, idEstadoExamen) "
					+ "VALUES('" + examen.getNombre() + "', " + examen.getIdMateria() +", 1);"
							
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//Listado de exámenes pendientes de habilitación
		@Override
		public List<Examen> pendientes() {
			List<Examen> ll = new LinkedList<Examen>();
			
			try {
				conn = (dataSource.dataSource()).getConnection();
			
				Statement query;
				
				query = conn.createStatement();
				
				ResultSet rs = query.executeQuery(
						"SELECT * FROM Examenes "
						+ "INNER JOIN EstadosExamenes ON Examenes.idEstadoExamen = EstadosExamenes.id "
						+ "LEFT JOIN Materias on Examenes.idMateria = Materias.id "
						+ "WHERE Examenes.idEstadoExamen = 1 "
						);
		
				while (rs.next()) {
				  
					Integer id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					Integer idEstadoExamen = rs.getInt("idEstadoExamen");
					Integer idMateria = rs.getInt("idMateria");
					String nombreMateria = rs.getString("nombreMateria");
					String descripcion = rs.getString("descripcion");
				  
					Examen examen = new Examen();
					examen.setId(id);
					examen.setNombre(nombre);
					examen.setNombreMateria(nombreMateria);
					examen.setIdMateria(idMateria);
					examen.setIdEstadoExamen(idEstadoExamen);
					examen.setDescripcion(descripcion);
		
					ll.add(examen);
				}
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ll;
		}
		
		//Listado de exámenes habilitados para alumnos
				@Override
				public List<Examen> habilitados() {
					List<Examen> ll = new LinkedList<Examen>();
					
					try {
						conn = (dataSource.dataSource()).getConnection();
					
						Statement query;
						
						query = conn.createStatement();
						
						ResultSet rs = query.executeQuery(
								"SELECT * FROM Examenes "
								+ "INNER JOIN EstadosExamenes ON Examenes.idEstadoExamen = EstadosExamenes.id "
								+ "LEFT JOIN Materias on Examenes.idMateria = Materias.id "
								+ "WHERE Examenes.idEstadoExamen = 2 "
								+ "AND idestadomateria = 1"
								);
				
						while (rs.next()) {
						  
							Integer id = rs.getInt("id");
							String nombre = rs.getString("nombre");
							Integer idMateria = rs.getInt("idMateria");
							String nombreMateria = rs.getString("nombreMateria");
							String descripcion = rs.getString("descripcion");
						  
							Examen habilitados = new Examen();
							habilitados.setId(id);
							habilitados.setNombre(nombre);
							habilitados.setNombreMateria(nombreMateria);
							habilitados.setIdMateria(idMateria);
							habilitados.setDescripcion(descripcion);
				
							ll.add(habilitados);
						}
						
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return ll;
				}
	
	//Aceptar pendientes
		@Override
		public void aceptarExamen(Integer id) {

			try {
				conn = (dataSource.dataSource()).getConnection();
			
				Statement query;
				
				
				query = conn.createStatement();		
				query.executeUpdate(
						"UPDATE Examenes SET idEstadoExamen = 2 "
						+ "WHERE id ="+ id + ";"	
				);
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		//Rechazar pendientes
			@Override
			public void rechazarExamen(Integer id) {

				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					query.executeUpdate(
							"UPDATE Examenes SET idEstadoExamen = 3 "
							+ "WHERE id ="+ id + ";"	
					);
					
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
			
			//Borrar exámenes
			@Override
			public void borrarExamen(Integer id) {

				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					query.executeUpdate(
							"DELETE FROM Examenes "
							+"WHERE id ="+ id + ";"
					);
					
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
			
			//Habilitados por id
			@Override
			public List<Examen> habilitadosPorId(String data) {
				List<Examen> ll = new LinkedList<Examen>();
				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					ResultSet rs = query.executeQuery(
							"SELECT * FROM Preguntas "
									+ "inner join examenes on examenes.id = preguntas.idexamen "
									+ "where preguntas.idexamen ='"+ data +"';"
											);
					while (rs.next()) {
						
						Integer idExamen = rs.getInt("idExamen");
					  
						Examen habilitados = new Examen();
						habilitados.setIdExamen(idExamen);
			
						ll.add(habilitados);
					}	
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
				return ll;
			}
			
			//Preguntas por id
			@Override
			public List<Examen> preguntasPorId(String data_examen) {
				List<Examen> ll = new LinkedList<Examen>();
				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					ResultSet rs = query.executeQuery(
							"SELECT * FROM preguntas "
									+ "where idExamen ='"+ data_examen +"';"
											);
					while (rs.next()) {
						
						Integer id_pregunta = rs.getInt("id_pregunta");
						Integer idExamen = rs.getInt("idExamen");
						String pregunta = rs.getString("pregunta");
					  
						Examen habilitados = new Examen();
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
		
			//Agregar Preguntas al Examen
			@Override
			public void savePreguntas(Examen examen, String data_examen) {

				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					query.executeUpdate(
							"insert into preguntas (idexamen, pregunta) "
							+ "VALUES('"+ data_examen +"', '" + examen.getPregunta() +"');"
					);
					
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
			
			//Borrar pregunta
			@Override
			public void borrarPregunta(Integer id) {

				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					query.executeUpdate(
							"DELETE FROM Preguntas "
							+"WHERE id_pregunta ="+ id + ";"
					);
					
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
			
			//Agregar Respuestas al Examen
			@Override
			public void saveRespuestas(Examen examen, String data_pregunta) {

				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					query.executeUpdate(
							"insert into respuestas (idpregunta, respuesta, idtiporespuesta) "
							+ "VALUES('"+ data_pregunta +"', '" + examen.getRespuesta() +"', '" + examen.getIdTipoRespuesta() +"');"
					);
					
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
			
			//Respuestas por id
			@Override
			public List<Examen> respuestasPorId(String data_pregunta) {
				List<Examen> ll = new LinkedList<Examen>();
				try {
					conn = (dataSource.dataSource()).getConnection();
				
					Statement query;
					
					
					query = conn.createStatement();		
					ResultSet rs = query.executeQuery(
							"SELECT * FROM respuestas "
									+ "where idPregunta ='"+ data_pregunta +"';"
											);
					while (rs.next()) {
						
						Integer idPregunta = rs.getInt("idPregunta");
						Integer id_respuesta = rs.getInt("id_respuesta");
						String respuesta = rs.getString("respuesta");
						Integer idTipoRespuesta = rs.getInt("idTipoRespuesta");
					  
						Examen habilitados = new Examen();
						habilitados.setIdPregunta(idPregunta);
						habilitados.setId_respuesta(id_respuesta);
						habilitados.setRespuesta(respuesta);
						habilitados.setIdTipoRespuesta(idTipoRespuesta);
			
						ll.add(habilitados);
					}	
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
				return ll;
			}
			
}
