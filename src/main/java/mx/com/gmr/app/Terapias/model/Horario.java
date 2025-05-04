package mx.com.gmr.app.Terapias.model;

import javax.management.relation.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Horario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long terapeutaId;
	private String diaSemana;
	private String horaInicio;
	private String horaFin;
	private String  fechaCreacion;
	private String fechaModificacion;
	private Boolean activo;
}
