package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
/*
 * Imports de métodos añadidos recientemente
 */
import javafx.scene.image.Image;//Para añadir imágenes

public class Main extends Application {
	
	@FXML 
	private TextField pass;
	@FXML
	private TextField user;
	@FXML
	private Button ingresar;
    
	//Método que inicia la aplicación, muestra solamente la pantalla de login, que esta misma referencia al InicioMenuController
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Carga la imagen para tomarlo como ícono
			Image icono = new Image("file:SistemaRexImagenes/Negro y Blanco Enmarcado DJ Kessey Logo.png");
			//Agrega el ícono a la ventana
			primaryStage.getIcons().add(icono);
			//Agrega título a la ventana
			primaryStage.setTitle("Login");
			//Evita que se pueda cambiar el tamaño de la ventana
			primaryStage.setResizable(false);
			//Relaciona la vista con la ventana
			primaryStage.setScene(scene);
			//Muestra la ventana
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);//También sirve "Application.launch(args);"
	}
}
