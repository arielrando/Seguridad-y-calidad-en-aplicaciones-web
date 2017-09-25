package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Statement;
import ar.edu.unlam.diit.scaw.configs.HsqlDataSource;
import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	HsqlDataSource dataSource = new HsqlDataSource();
	Connection conn;

	@Override
	public Usuario login(Usuario usuario){
		Usuario logueado = null;
		try{
			conn = (dataSource.dataSource()).getConnection();
			Statement query = conn.createStatement();
			
			String sql = 
					"SELECT * FROM Usuarios "
					+ "WHERE eMail = '"+ usuario.getEmail() + "' AND contraseña = '"+ usuario.getContraseña() +"' AND idEstadoUsuario IN (1,2)";
			ResultSet rs = query.executeQuery(sql);
			while(rs.next()){
				String eMail = rs.getString("eMail");
				String contraseña = rs.getString("contraseña");
				Integer id = rs.getInt("id");
				String apellido = rs.getString("apellido");
				String nombre = rs.getString("nombre");
				Integer idEstadoUsuario = rs.getInt("idEstadoUsuario");
				Integer idRol = rs.getInt("idRol");
				
				logueado = new Usuario();
				logueado.setEmail(eMail);
				logueado.setContraseña(contraseña);
				logueado.setId(id);
				logueado.setApellido(apellido);
				logueado.setNombre(nombre);
				logueado.setIdEstadoUsuario(idEstadoUsuario);
				logueado.setIdRol(idRol);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logueado;
	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> ll = new LinkedList<Usuario>();
		
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			query = conn.createStatement();
			
			ResultSet rs = query.executeQuery(
					"SELECT * FROM Usuarios "
					+ "INNER JOIN EstadosUsuarios ON Usuarios.idEstadoUsuario = EstadosUsuarios.id "
					+ "LEFT JOIN Roles ON usuarios.idrol = Roles.id "
					);
	
			while (rs.next()) {
			  
				String eMail = rs.getString("eMail");
				String contraseña = rs.getString("contraseña");
				Integer id = rs.getInt("id");
				String apellido = rs.getString("apellido");
				String nombre = rs.getString("nombre");
				Integer idEstadoUsuario = rs.getInt("idEstadoUsuario");
				String descripcion = rs.getString("descripcion");
				Integer idRol = rs.getInt("idRol");
				String rolDescripcion = rs.getString("rolDescripcion");
			  
				Usuario usuario = new Usuario();
				usuario.setEmail(eMail);
				usuario.setContraseña(contraseña);
				usuario.setId(id);
				usuario.setApellido(apellido);
				usuario.setNombre(nombre);
				usuario.setIdEstadoUsuario(idEstadoUsuario);
				usuario.setDescripcion(descripcion);
				usuario.setIdRol(idRol);
				usuario.setRolDescripcion(rolDescripcion);
	
				ll.add(usuario);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	@Override
	public void save(Usuario usuario) {

		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"INSERT INTO Usuarios (eMail, contraseña, apellido, nombre, idestadousuario, idrol) "
					+ "VALUES('" + usuario.getEmail() + "', '" + usuario.getContraseña() + "', '" + usuario.getApellido()+ "', '" + usuario.getNombre() + "', 1," + usuario.getIdRol() + ")"
							
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//Listado de usuarios pendientes de habilitacion
	@Override
	public List<Usuario> pendientes() {
		List<Usuario> ll = new LinkedList<Usuario>();
		
		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			query = conn.createStatement();
			
			ResultSet rs = query.executeQuery(
					"SELECT * FROM Usuarios "
					+ "INNER JOIN EstadosUsuarios ON Usuarios.idEstadoUsuario = EstadosUsuarios.id "
					+ "LEFT JOIN Roles ON Usuarios.idRol = Roles.id "
					+ "WHERE Usuarios.idEstadoUsuario = 1");
	
			while (rs.next()) {
			  
				String eMail = rs.getString("eMail");
				String contraseña = rs.getString("contraseña");
				Integer id = rs.getInt("id");
				String apellido = rs.getString("apellido");
				String nombre = rs.getString("nombre");
				Integer idEstadoUsuario = rs.getInt("idEstadoUsuario");
				String descripcion = rs.getString("descripcion");
				Integer idRol = rs.getInt("idRol");
				String rolDescripcion = rs.getString("rolDescripcion");
			  
				Usuario usuario = new Usuario();
				usuario.setEmail(eMail);
				usuario.setContraseña(contraseña);
				usuario.setId(id);
				usuario.setApellido(apellido);
				usuario.setNombre(nombre);
				usuario.setIdEstadoUsuario(idEstadoUsuario);
				usuario.setDescripcion(descripcion);
				usuario.setIdRol(idRol);
				usuario.setRolDescripcion(rolDescripcion);
	
				ll.add(usuario);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	//Aceptar pendientes
	@Override
	public void aceptar(Integer id) {

		try {
			conn = (dataSource.dataSource()).getConnection();
		
			Statement query;
			
			
			query = conn.createStatement();		
			query.executeUpdate(
					"UPDATE Usuarios SET idEstadoUsuario = 2 "
					+ "WHERE id ="+ id + ";"	
			);
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	//Rechazar pendientes
		@Override
		public void rechazar(Integer id) {

			try {
				conn = (dataSource.dataSource()).getConnection();
			
				Statement query;
				
				
				query = conn.createStatement();		
				query.executeUpdate(
						"UPDATE Usuarios SET idEstadoUsuario = 3 "
						+ "WHERE id ="+ id + ";"	
				);
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		//Borrar Usuarios
		@Override
		public void borrar(Integer id) {

			try {
				conn = (dataSource.dataSource()).getConnection();
			
				Statement query;
				
				
				query = conn.createStatement();		
				query.executeUpdate(
						"DELETE FROM Usuarios where id ="+ id +";"
				);
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		//Listado de docentes
		@Override
		public List<Usuario> docentes() {
			List<Usuario> ll = new LinkedList<Usuario>();
			
			try {
				conn = (dataSource.dataSource()).getConnection();
			
				Statement query;
				
				query = conn.createStatement();
				
				ResultSet rs = query.executeQuery(
						"SELECT * FROM Usuarios "
						+ "INNER JOIN EstadosUsuarios ON Usuarios.idEstadoUsuario = EstadosUsuarios.id "
						+ "LEFT JOIN Roles ON Usuarios.idRol = Roles.id "
						+ "WHERE Usuarios.idEstadoUsuario = 2 "
						+ "AND Roles.id = 2");
		
				while (rs.next()) {
				  
					String eMail = rs.getString("eMail");
					String contraseña = rs.getString("contraseña");
					Integer id = rs.getInt("id");
					String apellido = rs.getString("apellido");
					String nombre = rs.getString("nombre");
					Integer idEstadoUsuario = rs.getInt("idEstadoUsuario");
					Integer idRol = rs.getInt("idRol");
					String rolDescripcion = rs.getString("rolDescripcion");
				  
					Usuario usuario = new Usuario();
					usuario.setEmail(eMail);
					usuario.setContraseña(contraseña);
					usuario.setId(id);
					usuario.setApellido(apellido);
					usuario.setNombre(nombre);
					usuario.setIdEstadoUsuario(idEstadoUsuario);
					usuario.setIdRol(idRol);
					usuario.setRolDescripcion(rolDescripcion);
		
					ll.add(usuario);
				}
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ll;
		}
}
