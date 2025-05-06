package mx.com.gmr.app.Terapias.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.gmr.app.Terapias.model.Usuario;
import mx.com.gmr.app.Terapias.repository.UsuarioRepository;
import mx.com.gmr.app.Terapias.service.UsuarioService;

@Service
public class UsuarioServiceImpl  implements UsuarioService{
	
	@Autowired 
	
	UsuarioRepository usuarioRepository;
	

	@Override
	public List<Usuario> obtenerTodos() {
		List<Usuario> usuarioList = new ArrayList<>();
		try {
			usuarioList=usuarioRepository.obtenerTodos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usuarioList;
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		
		Usuario usuario = new Usuario();
		try {
			usuario= usuarioRepository.obtenerPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usuario;
	}

	@Override
	public int crear(Usuario usuario) {
	
		try {
			usuarioRepository.crear(usuario);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int actualizar(Usuario usuario) {
		try {
			usuarioRepository.actualizar(usuario);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public boolean existeUsuario(Usuario usuario) {
		try {
			if(buscarPorCorreo(usuario.getCorreo())!=null) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Usuario obtenerPorUsuario(String nombre) {
		Usuario usuario = new Usuario();
		try {
			usuario= usuarioRepository.buscarPorUsuario(nombre);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return usuario;
	}

}
