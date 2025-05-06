package mx.com.gmr.app.Terapias.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.gmr.app.Terapias.model.Usuario;

@Service
public interface UsuarioService {
	
	List<Usuario> obtenerTodos();
	 Usuario buscarPorCorreo(String correo);
	 Usuario obtenerPorId(Long id) ;
	 Usuario obtenerPorUsuario(String nombre);
	 int crear(Usuario usuario); 
	 int actualizar(Usuario usuario);
	 boolean existeUsuario(Usuario usuario);

}
