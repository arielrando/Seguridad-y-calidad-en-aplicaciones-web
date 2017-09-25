package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;
import ar.edu.unlam.diit.scaw.daos.impl.UsuarioDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	UsuarioDaoImpl usuarioHsql;
	
	public UsuarioServiceImpl(){
		usuarioHsql = new UsuarioDaoImpl();
	}
	
	@Override
	public Usuario login(Usuario usuario){
		return usuarioHsql.login(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioHsql.findAll();
	}

	public UsuarioDaoImpl getUsuarioHsql() {
		return usuarioHsql;
	}

	public void setUsuarioHsql(UsuarioDaoImpl personHsql) {
		this.usuarioHsql = personHsql;
	}

	@Override
	public void save(Usuario usuario) {
		usuarioHsql.save(usuario);
		
	}
	
	//Lista de usuarios pendientes de habilitacion
	@Override
	public List<Usuario> pendientes() {
		return usuarioHsql.pendientes();
	}
	
	//aceptar un usuario
	@Override
	public void aceptar(Integer id) {
		usuarioHsql.aceptar(id);
		
	}
	
	//rechazar un usuario
	@Override
	public void rechazar(Integer id) {
		usuarioHsql.rechazar(id);
		
	}
	
	//borrar un usuario
	@Override
	public void borrar(Integer id) {
		usuarioHsql.borrar(id);
		
	}
	
	//Lista de docentes
		@Override
		public List<Usuario> docentes() {
			return usuarioHsql.docentes();
		}
	
}
