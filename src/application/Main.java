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
 * Imports de m�todos a�adidos recientemente
 */
import javafx.scene.image.Image;//Para a�adir im�genes

public class Main extends Application {
	
	@FXML 
	private TextField pass;
	@FXML
	private TextField user;
	@FXML
	private Button ingresar;
    
	//M�todo que inicia la aplicaci�n, muestra solamente la pantalla de login, que esta misma referencia al InicioMenuController
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Carga la imagen para tomarlo como �cono
			Image icono = new Image("file:SistemaRexImagenes/Negro y Blanco Enmarcado DJ Kessey Logo.png");
			//Agrega el �cono a la ventana
			primaryStage.getIcons().add(icono);
			//Agrega t�tulo a la ventana
			primaryStage.setTitle("Login");
			//Evita que se pueda cambiar el tama�o de la ventana
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
		launch(args);//Tambi�n sirve "Application.launch(args);"
	}
}
