package mx.com.gmr.app.Terapias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import mx.com.gmr.app.Terapias.model.Usuario;
import mx.com.gmr.app.Terapias.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/")
	public ResponseEntity<?> obtenerUsuarios(){
		
		
		return new ResponseEntity<>(usuarioService.obtenerTodos(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerUsuariosByID(@PathVariable("id") long id){
		
		return new ResponseEntity<>(usuarioService.obtenerPorId(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<?> obtenerUsuariosByUsuario(@RequestParam("nombre") String nombre){
		
		return new ResponseEntity<>(usuarioService.obtenerPorUsuario(nombre),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> insertarUsuario(@RequestBody Usuario usuario){

			if(!usuarioService.existeUsuario(usuario)) {
				usuarioService.crear(usuario);
				return new ResponseEntity<>(usuarioService.obtenerTodos(),HttpStatus.CREATED);

			}else {
				return new ResponseEntity<>("Error al crear Usuario Existente",HttpStatus.ACCEPTED);

			}
			
	}
			@PatchMapping("/")
			public ResponseEntity<?>actualizarUsuario(@RequestBody Usuario usuario){

					if(usuarioService.existeUsuario(usuario)) {
						usuarioService.actualizar(usuario);
						return new ResponseEntity<>(usuarioService.obtenerTodos(),HttpStatus.CREATED);

					}else {
						return new ResponseEntity<>("Error al crear Usuario Existente",HttpStatus.ACCEPTED);

					}

	}
	
	
	
	

}
