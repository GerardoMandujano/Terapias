package mx.com.gmr.app.Terapias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Sesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long terapeutaId;
	private long clienteId;
	private String fechaHora;
	private String notas;
	private String  fechaCreacion;
	private String fechaModificacion;
	private Boolean activo;
}
