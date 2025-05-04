package mx.com.gmr.app.Terapias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Terapeuta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long usuarioId;
	private String especialidad;
	private String biografia;
	private long id;
	private String  fechaCreacion;
	private String fechaModificacion;
	private Boolean activo;

}
