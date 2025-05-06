package mx.com.gmr.app.Terapias.model;

public  class SQLConstantes {
	

	public static final String QS_USUARIO="SELECT * FROM USUARIO WHERE activo";
	
	public static final String QS_USUARIOBYID="SELECT * FROM Usuario WHERE id = ?";
	
	public static final String QS_USUARIOBYCORREO="SELECT * FROM Usuario WHERE correo = ?";
	
	public static final String QS_USUARIOBYUSUARIO="SELECT * FROM Usuario WHERE nombre = ?";

	public static final String QU_USUARIO="UPDATE Usuario SET nombre = ?, correo = ?, contraseña = ?, rol = ?, activo = ? WHERE id = ?";
}
