package mx.com.gmr.app.Terapias.dto;

import lombok.Data;

@Data
public class AuthResponse {
	 private String token;
	    private String username;
	    private String rol; // o List<String> roles si tienes varios

	    // Constructor
	    public AuthResponse(String token, String username, String rol) {
	        this.token = token;
	        this.username = username;
	        this.rol = rol;
	    }
}
