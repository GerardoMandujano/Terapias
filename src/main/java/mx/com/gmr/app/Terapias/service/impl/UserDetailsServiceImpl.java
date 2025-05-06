package mx.com.gmr.app.Terapias.service.impl;

import java.util.List;

//UserDetailsServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import mx.com.gmr.app.Terapias.model.Usuario;
import mx.com.gmr.app.Terapias.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

 @Autowired
 private UsuarioRepository usuarioRepository;

 
 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Usuario usuario = usuarioRepository.buscarPorUsuario(username); // Busca al usuario por su nombre de usuario

     if (usuario == null) {
         throw new UsernameNotFoundException("Usuario no encontrado");
     }

     // Aquí es donde la contraseña se compara con el codificador
     return new org.springframework.security.core.userdetails.User(
         usuario.getNombre(),
         usuario.getContraseña(),
         AuthorityUtils.createAuthorityList(usuario.getRol())
     );
 }
}