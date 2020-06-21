package sn.esmt.projet.java.controler;

import java.sql.Connection; 
import sn.esmt.projet.java.model.Utils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import sn.esmt.projet.java.model.DBConnexion;

public class AuthenCtrl {

    @FXML
    private TextField loginUser;
     
    @FXML
    private TextField role;

    @FXML
    private Button quitter;

    @FXML
    private Button connexion;

    @FXML
    private PasswordField pwdUser;

    @FXML
    private Button annulerSaisie;
    
    @FXML
    private Text auth;


    @SuppressWarnings("static-access")
	@FXML
    void authentification(ActionEvent event) throws Exception {
    	
    	 DBConnexion connectionClass=new DBConnexion();
         Connection connection=connectionClass.getConnection();

         try {
             PreparedStatement pst;
             String sql="SELECT * FROM user WHERE login = ? AND password = ? ";
             pst= connection.prepareStatement(sql);
            
            pst.setString(1, loginUser.getText());
            pst.setString(2, pwdUser.getText());
          
            ResultSet resulset = pst.executeQuery();
         
            int count=0;
            String role = null ;
            while(resulset.next()){
            	count=count+1;
           	  role = resulset.getString("role") ;

            }
             if (count==1 ){
            	 if(role.equals("admin")) {
            		 Utils.load(event,"/sn/esmt/projet/java/view/AdminView (1).fxml");
            		 /* Stage primaryStage= new Stage();
  	    		    Parent root = FXMLLoader.load(getClass().getResource("/sn/esmt/projet/java/view/AdminView.fxml"));
  	    		    Scene scene = new Scene(root);
  	    		    primaryStage.setScene(scene);
  	    		    primaryStage.setResizable(true);
  	    		    primaryStage.show();*/
            	 }
            	 else {
            		 
            		 Utils.load(event,"/sn/esmt/projet/java/view/Chauffeur.fxml");
            	  	   /*Stage primaryStage= new Stage();
    	    		    Parent root = FXMLLoader.load(getClass().getResource("/sn/esmt/projet/java/view/Chauffeur1.fxml"));
    	    		    Scene scene = new Scene(root);
    	    		    primaryStage.setScene(scene);
    	    		    primaryStage.setResizable(false);
    	    		    primaryStage.show();*/
            	 }
          
	    		   
                //Alert alert = new Alert(AlertType.INFORMATION);
                
             }else {
              	    Alert alert = new Alert(AlertType.INFORMATION);
            	    alert.setContentText("Please enter correct Login and Password");
                    alert.setTitle("Alert");
                    alert.showAndWait();
                }

         } catch (SQLException e) {
             e.printStackTrace();
         }
    	
    }

    @FXML
    void annuler(ActionEvent event) {
    	try {
			
    		loginUser.setText("");	
        	pwdUser.setText("");
        	
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}

    }

    @FXML
    void quitter(ActionEvent event) {

    	try {
			
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Confirmation");
        	alert.setHeaderText(null);
        	alert.setContentText("Voulez-vous quitter l'application ?");
        	ButtonType buttonTypeOui = new ButtonType("Oui");
        	ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

        	alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeCancel);
        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == buttonTypeOui){
        		System.exit(0);
        	  Stage stage = (Stage) quitter.getScene().getWindow();
        	    stage.close();
        	    
        	    
        	} else if (result.get() == buttonTypeCancel) {
        	    
        	}
    		
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
    }

    
}
