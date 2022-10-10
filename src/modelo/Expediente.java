package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="expediente")
public class Expediente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_expediente;
	@Column(name="id_cliente")
	int id_cliente;
	@Column(name="nom_exp")
	String nom_exp;
	@Column(name="clase_exp")
	String clase_exp;
	@Column(name="estado_exp")
	String estado_exp;
	@Column(name="existencia_exp")
	String existencia_exp;
	public Expediente(int id_cliente, String nom_exp, String clase_exp, String estado_exp, String existencia_exp) {
		super();
		this.id_cliente = id_cliente;
		this.nom_exp = nom_exp;
		this.clase_exp = clase_exp;
		this.estado_exp = estado_exp;
		this.existencia_exp = existencia_exp;
	}
	public Expediente() {
		
	}
	public int getId_expediente() {
		return id_expediente;
	}
	public void setId_expediente(int id_expediente) {
		this.id_expediente = id_expediente;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNom_exp() {
		return nom_exp;
	}
	public void setNom_exp(String nom_exp) {
		this.nom_exp = nom_exp;
	}
	public String getClase_exp() {
		return clase_exp;
	}
	public void setClase_exp(String clase_exp) {
		this.clase_exp = clase_exp;
	}
	public String getEstado_exp() {
		return estado_exp;
	}
	public void setEstado_exp(String estado_exp) {
		this.estado_exp = estado_exp;
	}
	public String getExistencia_exp() {
		return existencia_exp;
	}
	public void setExistencia_exp(String existencia_exp) {
		this.existencia_exp = existencia_exp;
	}
	
	
	
	
	
}