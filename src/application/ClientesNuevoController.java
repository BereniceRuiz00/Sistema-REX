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

public class ClientesNuevoController implements Initializable {
	
	//Objeto inherente para imprimir mensajes (flags) en la consola
	Class clase = this.getClass();

	//Componentes de la vista, mismo nombre que sus ID de la vista
	@FXML private TextField clientesNuevoIdTF;
	@FXML private TextField clientesNuevoNombreTF;
	@FXML private TextField clientesNuevoApellidosTF;
	@FXML private TextField clientesNuevoDireccionTF;
	@FXML private TextField clientesNuevoTelefonoTF;
	@FXML private TextField clientesNuevoCorreoTF;
	@FXML private Button clientesAgregarBT;
	
	//Objetos necesarios para formatear los datos para la tabla (considerar a "ObservableList" como un ArrayList)
	private ObservableList<Cliente> clientes;
	private Cliente cliente;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Entrando a la vista para agregar nuevo cliente");
		ClienteDAO cliente=new ClienteDAO();
		int ultimoID=cliente.consultarUltimoId()+1;
		String num=String.valueOf(ultimoID);
		this.clientesNuevoIdTF.setText(num);
	
	}
	
	//Inicializa los atributos del objeto, es llamado desde la clase de MenuClientesController
	public void iniAtributos(ObservableList<Cliente> clientes) {
		this.clientes = clientes;
	}

	//Método que manda a ClientesMenuController (y, por lo tanto, a ClientesMenuVista) el objeto con los datos ingresados
	@FXML
	private void aceptar(MouseEvent event) {
		try {
			//Variables que capturan los datos de los campos de texto de la vista
		 	//int id = Integer.parseInt(this.clientesNuevoIdTF.getText());
			String nombre = this.clientesNuevoNombreTF.getText();
			String apellidos = this.clientesNuevoApellidosTF.getText();
			String direccion = this.clientesNuevoDireccionTF.getText();
			String telefono = this.clientesNuevoTelefonoTF.getText();
			String correo = this.clientesNuevoCorreoTF.getText();
			//Genera el objeto
			Cliente c = new Cliente(nombre, apellidos, direccion, telefono, correo);
			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Datos capturados: " + c.getNom_cliente() + ", " + c.getApp_cliente() + ", " + c.getApm_cliente() + ", " + c.getCel_cliente() + ", " + c.getEmail_cliente());
			//Comprueba si el cliente no está vacío, de otra forma no se añade a la base de datos
			if(this.clientes != null) {
				//Comprueba si no hay un mismo cliente, de otra forma no se añade a la base de datos
				//NOTA: Puede que realmente este if no nos sirva, pues como el ID se genera automático, nunca abrá un objeto exactamente igual
				if (!this.clientes.contains(c)) {
					this.cliente = c;
					Stage stage = (Stage) this.clientesAgregarBT.getScene().getWindow();
					stage.close();
					System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Saliendo de la vista para agregar nuevo cliente");
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("Algo salió mal...");
					alert.showAndWait();
				}
			}else {
				System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Objeto vacío, incapaz de añadir a la tabla ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 @FXML
	private void cancelar(MouseEvent event) {
		this.cliente = null;
		//Stage stage = (Stage) this.clientesCancelarBT.getScene().getWindow();
		//stage.close();
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}

}
