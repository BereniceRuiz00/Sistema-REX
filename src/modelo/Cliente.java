package modelo;
import javax.persistence.*;
@Entity 
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_cliente;
	@Column(name="nom_cliente")
	String nom_cliente;
	@Column(name="app_cliente")
	String app_cliente;
	@Column(name="apm_cliente")
	String apm_cliente;
	@Column(name="cel_cliente")
	String cel_cliente;
	@Column(name="email_cliente")
	String email_cliente;
	//CONSTRUCTORES
	public Cliente(int id_cliente, String nom_cliente, String app_cliente, String apm_cliente, String cel_cliente,
			String email_cliente) {
		this.id_cliente = id_cliente;
		this.nom_cliente = nom_cliente;
		this.app_cliente = app_cliente;
		this.apm_cliente = apm_cliente;
		this.cel_cliente = cel_cliente;
		this.email_cliente = email_cliente;
	}
	public Cliente() {
		
	}
	
	
	public Cliente(String nom_cliente, String app_cliente, String apm_cliente, String cel_cliente,
			String email_cliente) {
		super();
		this.nom_cliente = nom_cliente;
		this.app_cliente = app_cliente;
		this.apm_cliente = apm_cliente;
		this.cel_cliente = cel_cliente;
		this.email_cliente = email_cliente;
	}
	//GETTERS AND SETTERS
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public String getApp_cliente() {
		return app_cliente;
	}
	public void setApp_cliente(String app_cliente) {
		this.app_cliente = app_cliente;
	}
	public String getApm_cliente() {
		return apm_cliente;
	}
	public void setApm_cliente(String apm_cliente) {
		this.apm_cliente = apm_cliente;
	}
	public String getCel_cliente() {
		return cel_cliente;
	}
	public void setCel_cliente(String cel_cliente) {
		this.cel_cliente = cel_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	
	
	
}
