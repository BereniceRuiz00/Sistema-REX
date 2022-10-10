package modelo;

import java.util.Date;
import javax.persistence.*;
@Entity 
@Table(name="agenda")
public class Agenda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_evento;
	@Column(name="idtipo_evento")
	int idtipo_evento;
	@Column(name="descrip_evento")
	String descrip_evento;
	@Column(name="fecha_evento")
	Date fecha_evento;
	@Column(name="hora_evento")
	Date hora_evento;
	public Agenda(int idtipo_evento, String descrip_evento, Date fecha_evento, Date hora_evento) {
		super();
		this.idtipo_evento = idtipo_evento;
		this.descrip_evento = descrip_evento;
		this.fecha_evento = fecha_evento;
		this.hora_evento = hora_evento;
	}
	
	public Agenda() {
		
	}

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

	public int getIdtipo_evento() {
		return idtipo_evento;
	}

	public void setIdtipo_evento(int idtipo_evento) {
		this.idtipo_evento = idtipo_evento;
	}

	public String getDescrip_evento() {
		return descrip_evento;
	}

	public void setDescrip_evento(String descrip_evento) {
		this.descrip_evento = descrip_evento;
	}

	public Date getFecha_evento() {
		return fecha_evento;
	}

	public void setFecha_evento(Date fecha_evento) {
		this.fecha_evento = fecha_evento;
	}

	public Date getHora_evento() {
		return hora_evento;
	}

	public void setHora_evento(Date hora_evento) {
		this.hora_evento = hora_evento;
	}
	
	
	
	
}
