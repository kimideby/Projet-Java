package sn.esmt.projet.java.model;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Utils {
	
	private void loadPage(ActionEvent event,String url) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide();
		Parent root = FXMLLoader.load(getClass().getResource(url));
		Image icon = new Image("/sn/esmt/projet/java/view/icons/téléchargement (1).jpg");
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Gestion de bus");
		stage.getIcons().add(icon);
		
	}
	public static void load(ActionEvent event,String url) throws IOException {
		new Utils().loadPage(event,url);
	}
}
