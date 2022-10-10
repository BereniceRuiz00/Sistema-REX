package application;

import modelo.Cliente;
import modelo.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClientesEditarController implements Initializable {

	Class clase = this.getClass();
	
	@FXML private TextField clientesEditarIdTF;
	@FXML private TextField clientesEditarNombreTF;
	@FXML private TextField clientesEditarApellidopTF;
	@FXML private TextField clientesEditarApellidomTF;
	@FXML private TextField clientesEditarTelefonoTF;
	@FXML private TextField clientesEditarCorreoTF;
	
	@FXML private Button clientesModificarBT;
	
	private ObservableList<Cliente> clientes;
	private Cliente cliente;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	//Inicializa los atributos del objeto, es llamado desde la clase de MenuClientesController
	public void iniAtributos(ObservableList<Cliente> clientes, Cliente c) {
		this.clientes = clientes;
		this.cliente = c;
		this.clientesEditarIdTF.setText(c.getId_cliente()+"");
		this.clientesEditarNombreTF.setText(c.getNom_cliente());
		this.clientesEditarApellidopTF.setText(c.getApp_cliente());
		this.clientesEditarApellidomTF.setText(c.getApm_cliente());
		this.clientesEditarTelefonoTF.setText(c.getCel_cliente());
		this.clientesEditarCorreoTF.setText(c.getEmail_cliente());
	}
	
	@FXML
	private void modificar(MouseEvent event) {
		
		String nombre = this.clientesEditarNombreTF.getText();
		String apellidop = this.clientesEditarApellidopTF.getText();
		String apellidom = this.clientesEditarApellidomTF.getText();
		String telefono = this.clientesEditarTelefonoTF.getText();
		String correo = this.clientesEditarCorreoTF.getText();
		
		Cliente c = new Cliente(nombre, apellidop, apellidom, telefono, correo);
		System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Datos capturados: " + c.getNom_cliente() + ", " + c.getApp_cliente() + ", " + c.getApm_cliente() + ", " + c.getCel_cliente() + ", " + c.getEmail_cliente());
		
		//Comprueba si no hay un mismo cliente, de otra forma no se añade a la base de datos
		//NOTA: Puede que realmente este if no nos sirva, pues como el ID se genera automático, nunca abrá un objeto exactamente igual
		if (!this.clientes.contains(c)) {
			this.cliente = c;
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Información");
			alert.setContentText("Cliente modificado correctamente");
			alert.showAndWait();
			Stage stage = (Stage) this.clientesModificarBT.getScene().getWindow();
			stage.close();
			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Saliendo de la vista para agregar nuevo cliente");
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Los datos no pudieron procesarse. Ingréselos de nuevo.");
			alert.showAndWait();
		}
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
}
