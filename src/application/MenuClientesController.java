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

public class MenuClientesController implements Initializable{
	
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
		ObservableList<Cliente>  items=clientedao.consultarCliente();
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
			root = FXMLLoader.load(getClass().getResource("Menu_inicio.fxml"));
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
			root = FXMLLoader.load(getClass().getResource("Menu_expedientes.fxml"));
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
			root = FXMLLoader.load(getClass().getResource("Menu_eventos.fxml"));
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
    void borrarcli(MouseEvent event) {
    	
    	Cliente c = this.clientesTabla.getSelectionModel().getSelectedItem();
    	
    	if(c == null) {
    		Alert alertaError = new Alert(AlertType.ERROR);
    		alertaError.setHeaderText(null);
    		alertaError.setTitle("Error");
    		alertaError.setContentText("Seleccione primero a un cliente para después eliminarlo");
    		alertaError.showAndWait();
    	}else {
    		Alert dialogoAlerta= new Alert(AlertType.CONFIRMATION);
        	dialogoAlerta.setHeaderText(null);
        	dialogoAlerta.setContentText("¿Desea eliminar este cliente?");
        	Optional<ButtonType>result = dialogoAlerta.showAndWait();
        	if(result.get()== ButtonType.OK){
        		this.clientes.remove(c);
        		this.clientesTabla.refresh();
        		
        		Alert alertaInformacion = new Alert(AlertType.INFORMATION);
        		alertaInformacion.setHeaderText(null);
        		alertaInformacion.setTitle("Información");
        		alertaInformacion.setContentText("Se ha eliminado al cliente exitosamente");
        		alertaInformacion.showAndWait();
        		
        	}
    	}
    	
    }

    @FXML
    void editarcli(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("Clientes_editar.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Información de cliente");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void nuevocli(MouseEvent event) {
    	System.out.println("[Sistema] Ejecutando método de nuevo cliente...");
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Clientes_nuevo.fxml"));
			root = loader.load();
			ClientesNuevoController controlador = loader.getController();
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
			ClienteDAO cdao=new ClienteDAO();
			cdao.insertarCliente(c.getNom_cliente(), c.getApp_cliente(), c.getApm_cliente(), c.getCel_cliente(), c.getEmail_cliente());
			if(c != null) {
				this.clientes.add(c);
				this.clientesTabla.refresh();
			}
			
			System.out.println("[Sistema] Método de nuevo cliente ejecutado");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("[Sistema] No se pudo ejecutar el método de nuevo cliente");
		}
    }
    
    @FXML 
    void buscarCliente(MouseEvent event){
    	
    }

}
