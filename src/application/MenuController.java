package application;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class MenuController implements Initializable{
	
	//guarda la dirección/referencia del archivo de css, para evitar escribir toda la función 
	private String css = this.getClass().getResource("application.css").toExternalForm();
	
	private Parent root;
	private Image icono = new Image("file:SistemaRexImagenes/Negro y Blanco Enmarcado DJ Kessey Logo.png");
	
	@FXML private TextField clientesEditarIdTF;
	@FXML private TextField clientesEditarNombreTF;
	@FXML private TextField clientesEditarApellidosTF;
	@FXML private TextField clientesEditarDireccionTF;
	@FXML private TextField clientesEditarTelefonoTF;
	@FXML private TextField clientesEditarCorreoTF;
	
	@FXML private Button clientesEditarBT;
	@FXML private Button clientesEliminarBT;
	@FXML private Button clientesBuscarBT;
	@FXML private Button expedientesNuevoBT;
	@FXML private Button expedientesEditarBT;
	@FXML private Button expedientesEliminarBT;
	@FXML private Button expedientesBuscarBT;
	
	@FXML private TextField expedientesNuevoIdClienteTF;
	@FXML private TextField expedientesNuevoIdExpedienteTF;
	@FXML private TextField expedientesNuevoClaveTF;
	@FXML private TextField expedientesNuevoMateriaTF;
	@FXML private TextField expedientesNuevoClaseTF;
	@FXML private RadioButton expedientesNuevoTramiteRB;
	@FXML private RadioButton expedientesNuevoArchivadoRB;
	@FXML private TextField expedientesNuevoExistenciaTF;
	@FXML private TextField expedientesEditarIdClienteTF;
	@FXML private TextField expedientesEditarIdExpedienteTF;
	@FXML private TextField expedientesEditarClaveTF;
	@FXML private TextField expedientesEditarMateriaTF;
	@FXML private TextField expedientesEditarClaseTF;
	@FXML private RadioButton expedientesEditarTramiteRB;
	@FXML private RadioButton expedientesEditarArchivadoRB;
	@FXML private TextField expedientesEditarExistenciaTF;
	@FXML private TextField expedientesBuscarTF;
	
	@FXML private TableView<Expediente> expedientesTabla;
	@FXML private TableColumn expedientesColumnaIdCliente;
	@FXML private TableColumn expedientesColumnaIdExpediente;
	@FXML private TableColumn expedientesColumnaClave;
	@FXML private TableColumn expedientesColumnaMateria;
	@FXML private TableColumn expedientesColumnaClase;
	@FXML private TableColumn expedientesColumnaEstado;
	@FXML private TableColumn expedientesColumnaExistencia;
	ObservableList<Expediente> expedientes;
	
	//private int clientesPosicion;
	//private int expedientesPosicion;
	
	@FXML
	public BorderPane bp;
	@FXML
	public AnchorPane ap;
	
    @Override
	public void initialize(URL url, ResourceBundle rb) {
		
    	/*
    	ToggleGroup tgNuevo = new ToggleGroup();
		this.expedientesNuevoTramiteRB.setToggleGroup(tgNuevo);
		this.expedientesNuevoArchivadoRB.setToggleGroup(tgNuevo);
		/*
		ToggleGroup tgEditar = new ToggleGroup();
		this.expedientesEditarTramiteRB.setToggleGroup(tgEditar);
		this.expedientesEditarArchivadoRB.setToggleGroup(tgEditar);
    	*/
    	
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
    void page1(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("Menu_clientes.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Clientes");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Node source = (Node) event.getSource();
	    Stage stage = (Stage) source.getScene().getWindow();
	    stage.close();
    	
    }
    
    /*
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void clientesAgregar(MouseEvent event) {
    	
    	try {
    		
    		int id = Integer.parseInt(this.clientesNuevoIdTF.getText());
        	String nombre = this.clientesNuevoNombreTF.getText();
        	String apellidos = this.clientesNuevoApellidosTF.getText();
        	String direccion = this.clientesNuevoDireccionTF.getText();
        	String telefono = this.clientesNuevoTelefonoTF.getText();
        	String correo = this.clientesNuevoCorreoTF.getText();
        	
        	Cliente c = new Cliente(id, nombre, apellidos, direccion, telefono, correo);
    		
	    	if(!this.clientes.contains(c)) {
	    		this.clientes.add(c);
	    		this.clientesTabla.setItems(clientes);
	    	}else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	    		alert.setHeaderText(null);
	    		alert.setTitle("Error");
	    		alert.setContentText("Algo salió mal...");
	    		alert.showAndWait();
	    	}
    	}catch(Exception e) {
    		System.out.print("ERROR YA SABES DÓNDE");
    	}
    	
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	*/
    
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
			System.out.println("<SISTEMA|Paquete application/Clase MenuController>: Error al mostrar la ventana del menú de expedientes");
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
    private TextField pass;

    @FXML
    private TextField user;


    @FXML
    void Ingresar(MouseEvent event) {
    	
    	String usuario=this.user.getText();
    	String contraseña=this.pass.getText();
    	if(usuario.isEmpty()) {
    		JOptionPane.showMessageDialog(null,"Error");
    	}else {
    		Stage primaryStage = new Stage ();
	    	try {
    				Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));//Menu.fxml es el menú de inicio
    				Scene scene = new Scene(root);
	    			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    			primaryStage.setScene(scene);
	    			primaryStage.setResizable(false);
	    			JOptionPane.showMessageDialog(null,"Conectado a la base de datos");
    				primaryStage.show();
	    	}catch(Exception e) {
    			e.printStackTrace();
	    	
    		}	
    		Node source = (Node) event.getSource();
    	    Stage stage = (Stage) source.getScene().getWindow();
    	    stage.close();
    	}
    }
    
/*
    @FXML
    void borrarcli(MouseEvent event) {
    	Alert dialogoAlerta= new Alert(AlertType.CONFIRMATION);
    	dialogoAlerta.setHeaderText(null);
    	dialogoAlerta.setContentText("¿Desea eliminar este cliente?");
    	Optional<ButtonType>result = dialogoAlerta.showAndWait();
    	if(result.get()== ButtonType.OK){}
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
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("Clientes_nuevo.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Nuevo cliente");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    */
    
    @FXML
    void borrarexp(MouseEvent event) {
    	Alert dialogoAlerta= new Alert(AlertType.CONFIRMATION);
    	dialogoAlerta.setHeaderText(null);
    	dialogoAlerta.setContentText("¿Desea eliminar este expediente?");
    	Optional<ButtonType>result = dialogoAlerta.showAndWait();
    	if(result.get()== ButtonType.OK){}	
    }

    @FXML
    void editarexp(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("Expedientes_editar.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Información de expediente");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void nuevoexp(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("Expedientes_nuevo.fxml"));
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Nuevo expediente");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
