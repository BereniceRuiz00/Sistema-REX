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

public class InicioMenuController implements Initializable{
	
	//guarda la direcci?n/referencia del archivo de css, para evitar escribir toda la funci?n 
	private String css = this.getClass().getResource("application.css").toExternalForm();
	
	private Parent root;
	private Image icono = new Image("file:SistemaRexImagenes/Negro y Blanco Enmarcado DJ Kessey Logo.png");
	
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
	
	@FXML
	public BorderPane bp;
	@FXML
	public AnchorPane ap;
	
    @Override
	public void initialize(URL url, ResourceBundle rb) {
		
    	/*	Para los RadioButton de expedientes
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
    void page1(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("ClientesMenuVista.fxml"));
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
			System.out.println("<SISTEMA|Paquete application/Clase MenuController>: Error al mostrar la ventana del men? de expedientes");
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
    private TextField pass;

    @FXML
    private TextField user;

    
    @FXML
    void Ingresar(MouseEvent event) {
    	
    	String usuario=this.user.getText();
    	String contrase?a=this.pass.getText();
    	if(usuario.isEmpty()) {
    		JOptionPane.showMessageDialog(null,"Error");
    	}else {
    		Stage primaryStage = new Stage ();
	    	try {
    				Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));//Menu.fxml es el men? de inicio
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
    
    @FXML
    void borrarexp(MouseEvent event) {
    	Alert dialogoAlerta= new Alert(AlertType.CONFIRMATION);
    	dialogoAlerta.setHeaderText(null);
    	dialogoAlerta.setContentText("?Desea eliminar este expediente?");
    	Optional<ButtonType>result = dialogoAlerta.showAndWait();
    	if(result.get()== ButtonType.OK){}	
    }

    @FXML
    void editarexp(MouseEvent event) {
    	Stage primaryStage = new Stage ();
		try {
			root = FXMLLoader.load(getClass().getResource("ExpedientesEditarVista.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(icono);
			primaryStage.setTitle("Informaci?n de expediente");
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
			root = FXMLLoader.load(getClass().getResource("ExpedientesNuevoVista.fxml"));
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
