package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Statement;
import ar.edu.unlam.diit.scaw.configs.HsqlDataSource;
import ar.edu.unlam.diit.scaw.daos.MateriaDao;
import ar.edu.unlam.diit.scaw.entities.Materia;

public class MateriaDaoImpl implements MateriaDao {

	HsqlDataSource dataSource = new HsqlDataSource();
	Connection conn;


	@Override
	public List<Materia> materias() {
		List<Materia> ll = new LinkedList<Materia>();
		
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			query = conn.createStatement();
			
			ResultSet rs = query.executeQuery(
					"SELECT * FROM Materias "
					+ "INNER JOIN usuarios ON materias.iddocentetitular = usuarios.id"
					);
	
			while (rs.next()) {
			  
				
				Integer id = rs.getInt("id");
				String nombreMateria = rs.getString("nombreMateria");
				Integer idDocenteTitular = rs.getInt("idDocenteTitular");
				Integer idEstadoMateria = rs.getInt("idEstadoMateria");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
			  
				Materia materia = new Materia();
				materia.setId(id);
				materia.setNombreMateria(nombreMateria);
				materia.setNombre(nombre);
				materia.setApellido(apellido);
				materia.setIdDocenteTitular(idDocenteTitular);
				materia.setIdEstadoMateria(idEstadoMateria);
	
				ll.add(materia);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	@Override
	public void save(Materia materia) {

		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"INSERT INTO materias (nombreMateria, iddocentetitular,idestadomateria) "
					+ "VALUES('" + materia.getNombreMateria() + "', " + materia.getIdDocenteTitular() +", 1);"
							
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
