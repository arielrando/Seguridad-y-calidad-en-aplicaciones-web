package ar.edu.unlam.diit.scaw.services;

import java.util.List;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioService {

	public Usuario login(Usuario usuario);
	public List<Usuario> findAll();
	public void save(Usuario usuario);
	public List<Usuario> pendientes();
	public void aceptar(Integer id);
	public void rechazar(Integer id);
	public void borrar(Integer id);
	public List<Usuario> docentes();

}
