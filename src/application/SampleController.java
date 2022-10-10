//Desvinculada

package application;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
public class SampleController {

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
	    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
