package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.ClienteDAO;

public class ClientesMenuController implements Initializable{
	
	//Objeto inherente para imprimir mensajes (flags) en la consola
	Class clase = this.getClass();
	
	//Objeto para referenciar dónde mostrar la vista
	private Parent root;
	//Objeto para referenciar la hoja de estilos (CSS) que puede usarse en las vistas (ACTUALMENTE NO SE USA)
	private String css = this.getClass().getResource("application.css").toExternalForm();
	//Objeto que referencia la imagen para ponerse como icono
	private Image icono = new Image("file:SistemaRexImagenes/Negro y Blanco Enmarcado DJ Kessey Logo.png");
	
	@FXML private TextField clientesBuscarTF;
	@FXML private Button clientesBuscarBT;
	@FXML private Button clientesEliminarBT;
	
	@FXML private TableView<Cliente> clientesTabla;
	@FXML private TableColumn clientesColumnaId;
	@FXML private TableColumn clientesColumnaNombre;
	@FXML private TableColumn clientesColumnaApellidos;
	@FXML private TableColumn clientesColumnaDireccion;
	@FXML private TableColumn clientesColumnaTelefono;
	@FXML private TableColumn clientesColumnaCorreo;
	private ObservableList<Cliente> clientes;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Inicializando controlador de la vista del menú de clientes...");
		
		//En estas 3 lineas se instancia el clienteDAO para traer el metodo consultar cliente registros de la base de datos
		clientes = FXCollections.observableArrayList();
		ClienteDAO clientedao=new ClienteDAO();
		ObservableList<Cliente>  items = clientedao.consultarCliente();
		this.clientesTabla.setItems(items);
		this.clientesColumnaId.setCellValueFactory(new PropertyValueFactory("id_cliente"));
		this.clientesColumnaNombre.setCellValueFactory(new PropertyValueFactory("nom_cliente"));
		this.clientesColumnaApellidos.setCellValueFactory(new PropertyValueFactory("app_cliente"));
		this.clientesColumnaDireccion.setCellValueFactory(new PropertyValueFactory("apm_cliente"));
		this.clientesColumnaTelefono.setCellValueFactory(new PropertyValueFactory("cel_cliente"));
		this.clientesColumnaCorreo.setCellValueFactory(new PropertyValueFactory("email_cliente"));
		
		System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Controlador de la vista del menú de clientes inicializado completamente");
	}
	
	@FXML
    void home(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("InicioMenuVista.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Inicio");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }
	
	@FXML
    void page2(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("ExpedientesMenuVista.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Expedientes");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    	
    }

    @FXML
    void page3(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("EventosMenuVista.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Eventos");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    }

    @FXML
    void page4(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("page4.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Indefinido");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    	
    }
    
    @FXML 
    void buscarCliente(MouseEvent event){
    	
    }
    
    @FXML
    void actualizarTablaVista() {
    	ClienteDAO clientedao = new ClienteDAO();
		ObservableList<Cliente>  items = clientedao.consultarCliente();
		this.clientesTabla.setItems(items);
    }
    
    @FXML
    void nuevocli(MouseEvent event) {
    	System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Ejecutando método de nuevo cliente...");
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientesNuevoVista.fxml"));
			root = loader.load();
			//Objeto que comunica con la clase del controlador del nuevo cliente
			ClientesNuevoController controlador = loader.getController();
			//Objeto que se inicializa el ArrayLista del controlador mencionado arriba
			controlador.iniAtributos(clientes);
			
			Scene scene = new Scene(root);
			Stage stage = new Stage ();
			scene.getStylesheets().add(css);
			stage.initModality(Modality.APPLICATION_MODAL);//No dejará seguir con la app mientras esté abierta la ventana emergente de nuevo cliente
			stage.setScene(scene);
			stage.getIcons().add(icono);
			stage.setTitle("Nuevo cliente");
			stage.setResizable(false);
			stage.showAndWait();
			//desde aqui se agrega a la base de datos
			
			Cliente c = controlador.getCliente();
			ClienteDAO cdao = new ClienteDAO();
			cdao.insertarCliente(c.getNom_cliente(), c.getApp_cliente(), c.getApm_cliente(), c.getCel_cliente(), c.getEmail_cliente());
			Alert alert = new Alert(Alert.AlertType.INFORMATION);				alert.setHeaderText(null);
			alert.setTitle("Información");
			alert.setContentText("Cliente añadido correctamente");
			alert.showAndWait();
			if(c != null) {
				this.clientes.add(c);
				ClienteDAO clientedao=new ClienteDAO();
				ObservableList<Cliente>  items = clientedao.consultarCliente();
				this.clientesTabla.setItems(items);
			}
			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Método de nuevo cliente ejecutado");
		} catch(Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Los datos no se cargaron a la base de datos, intente de nuevo.");
			alert.showAndWait();
			e.printStackTrace();
			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> No se pudo ejecutar el método de nuevo cliente");
		}
    }
    
    @FXML
    void editarcli(MouseEvent event) {
    	Cliente c = this.clientesTabla.getSelectionModel().getSelectedItem();
    	
    	if(c == null) {
    		Alert alertaError = new Alert(AlertType.ERROR);
    		alertaError.setHeaderText(null);
    		alertaError.setTitle("Error");
    		alertaError.setContentText("Seleccione un cliente para poder modificarlo");
    		alertaError.showAndWait();
    	}else {
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("ClientesEditarVista.fxml"));
    			root = loader.load();
    			//Objeto que comunica con la clase del controlador del nuevo cliente
    			ClientesEditarController controlador = loader.getController();
    			//Objeto que se inicializa el ArrayLista del controlador mencionado arriba
    			controlador.iniAtributos(clientes, c);
    			
    			Scene scene = new Scene(root);
    			Stage stage = new Stage ();
    			scene.getStylesheets().add(css);
    			stage.initModality(Modality.APPLICATION_MODAL);//No dejará seguir con la app mientras esté abierta la ventana emergente de nuevo cliente
    			stage.setScene(scene);
    			stage.getIcons().add(icono);
    			stage.setTitle("Información de cliente");
    			stage.setResizable(false);
    			stage.showAndWait();
    			//Este objeto recibe los el objeto con los datos modificados
    			Cliente cModificado = controlador.getCliente();
    			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Datos modificados obtenidos: " + cModificado.getId_cliente() + ", " + cModificado.getNom_cliente() + ", " + cModificado.getApp_cliente() + ", " + cModificado.getApm_cliente() + ", " + cModificado.getCel_cliente() + ", " + cModificado.getEmail_cliente());
    			//Se crea el objeto para ejecutar la modificación en la base de datos
    			ClienteDAO cdao = new ClienteDAO();
    			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Hola");
    			//Se llama al método que actualiza la base de datos
    			cdao.actualizarCliente(cModificado.getNom_cliente(), cModificado.getApp_cliente(), cModificado.getApm_cliente(), cModificado.getCel_cliente(), cModificado.getEmail_cliente());
    			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Hola");
    			this.clientes.add(cModificado);
    			System.out.println("<SISTEMAREX ["+ clase.getName() +"]> Hola");
				ClienteDAO clientedao=new ClienteDAO();
				ObservableList<Cliente>  items = clientedao.consultarCliente();
				this.clientesTabla.setItems(items);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	
    }
    
    @FXML
    void borrarcli(MouseEvent event) {
    	
    	Cliente c = this.clientesTabla.getSelectionModel().getSelectedItem();
    	
    	if(c == null) {
    		Alert alertaError = new Alert(AlertType.ERROR);
    		alertaError.setHeaderText(null);
    		alertaError.setTitle("Error");
    		alertaError.setContentText("Seleccione un cliente para poder eliminarlo");
    		alertaError.showAndWait();
    	}else {
    		Alert dialogoAlerta= new Alert(AlertType.CONFIRMATION);
        	dialogoAlerta.setHeaderText(null);
        	dialogoAlerta.setContentText("¿Desea eliminar este cliente?");
        	Optional<ButtonType>result = dialogoAlerta.showAndWait();
        	if(result.get()== ButtonType.OK){
        		this.clientes.remove(c);
        		ClienteDAO clientedao = new ClienteDAO();
        		clientedao.eliminarCliente(c.getId_cliente()+"");
        		ObservableList<Cliente>  items = clientedao.consultarCliente();
        		this.clientesTabla.setItems(items);
        		
        		Alert alertaInformacion = new Alert(AlertType.INFORMATION);
        		alertaInformacion.setHeaderText(null);
        		alertaInformacion.setTitle("Información");
        		alertaInformacion.setContentText("Se ha eliminado al cliente exitosamente");
        		alertaInformacion.showAndWait();
        		
        	}
    	}
    	
    }
    
}
