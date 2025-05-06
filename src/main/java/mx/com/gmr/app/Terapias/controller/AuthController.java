package mx.com.gmr.app.Terapias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.gmr.app.Terapias.dto.AuthRequest;
import mx.com.gmr.app.Terapias.dto.AuthResponse;
import mx.com.gmr.app.Terapias.model.Usuario;
import mx.com.gmr.app.Terapias.repository.UsuarioRepository;
import mx.com.gmr.app.Terapias.security.JwtService;
import mx.com.gmr.app.Terapias.service.impl.UserDetailsServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    	
    @Autowired
    private UsuarioRepository usuarioRepository;
    

    @GetMapping("/")
    public String inicio() {
    	return "INICIANDO APP";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails.getUsername());

        // Obtener rol desde tu base de datos (usando tu entidad)
        Usuario usuario = usuarioRepository.buscarPorUsuario(request.getUsername());

        return new AuthResponse(token, usuario.getNombre(), usuario.getRol());
    }
}
