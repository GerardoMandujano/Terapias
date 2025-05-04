package mx.com.gmr.app.Terapias.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private Double precio;
	private Integer duracion;
	private String  fechaCreacion;
	private String fechaModificacion;
	private Boolean activo;
}
