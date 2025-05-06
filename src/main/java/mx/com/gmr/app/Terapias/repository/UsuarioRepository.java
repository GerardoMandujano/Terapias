package mx.com.gmr.app.Terapias.repository;

import java.util.List;

import org.hibernate.annotations.processing.SQL;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import mx.com.gmr.app.Terapias.mapper.UsuarioMapper;
import mx.com.gmr.app.Terapias.model.SQLConstantes;
import mx.com.gmr.app.Terapias.model.Usuario;

@Repository
public class UsuarioRepository {
    private final PasswordEncoder passwordEncoder;
	
	private final JdbcTemplate jdbcTemplate;
	
	public UsuarioRepository(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
		this.jdbcTemplate = jdbcTemplate;
    }
	
    public int crear(Usuario usuario) {
        String passwordCodificada = passwordEncoder.encode(usuario.getContraseña());

        String sql = "INSERT INTO Usuario (nombre, correo, contraseña, rol, activo) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                usuario.getNombre(),
                usuario.getCorreo(),
                passwordCodificada,
                usuario.getRol(),
                true);
    }
    
    public Usuario obtenerPorId(Long id) {
        String sql = SQLConstantes.QS_USUARIOBYID;
        return jdbcTemplate.queryForObject(sql, new UsuarioMapper(), id);
    }
	
	public List<Usuario> obtenerTodos(){
		String sql=SQLConstantes.QS_USUARIO;
		return jdbcTemplate.query(sql, new UsuarioMapper());
		
	}
	
	 public Usuario buscarPorUsuario(String nombre) {
	        String sql = SQLConstantes.QS_USUARIOBYUSUARIO;
	        return jdbcTemplate.queryForObject(sql, new UsuarioMapper(), nombre);
	    }
	
	 public Usuario buscarPorCorreo(String correo) {
	        String sql = SQLConstantes.QS_USUARIOBYCORREO;
	        return jdbcTemplate.queryForObject(sql, new UsuarioMapper(), correo);
	    }
	 
	 public int actualizar(Usuario usuario) {
	        String sql = SQLConstantes.QU_USUARIO;
	        return jdbcTemplate.update(sql,
	                usuario.getNombre(),
	                usuario.getCorreo(),
	                usuario.getContraseña(),
	                usuario.getRol(),
	                usuario.getActivo(),
	                usuario.getId());
	    }


}
