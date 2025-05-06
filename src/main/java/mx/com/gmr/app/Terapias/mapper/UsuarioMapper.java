package mx.com.gmr.app.Terapias.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.gmr.app.Terapias.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getLong("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setCorreo(rs.getString("correo"));
			usuario.setContraseña(rs.getString("contraseña"));
			usuario.setRol(rs.getString("rol"));
			usuario.setActivo(rs.getBoolean("activo"));
		return usuario;
	}
 
}
