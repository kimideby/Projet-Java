package sn.esmt.projet.java.application;
	
import java.io.IOException ;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage stage;
	private BorderPane rootLayout= new BorderPane();
	
	 public void initRootLayout() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("/sn/esmt/projet/view/"));
	            rootLayout = (BorderPane)  loader.load();
	            
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            stage.setScene(scene);
	            stage.show();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Shows the contact overview inside the root layout.
	     */
	    public void showContactOverview() {
	        try {
	            // Load contact overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("/sn/esmt/projet/view/UserView.fxml"));
	           BorderPane view = (BorderPane) loader.load();
	            
	            // Set contact overview into the center of root layout.
	            rootLayout.setCenter(view);
	            
	            // Give the controller access to the main app.
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	@Override
	public void start(Stage primaryStage) {
		try {
		
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/sn/esmt/projet/java/view/Authentification.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			primaryStage.show();
			
			Image icon = new Image("/sn/esmt/projet/java/view/icons/téléchargement (1).jpg");
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Gestion de bus");
			
		
			primaryStage.show();	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void showAddLayout() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
