package sn.esmt.projet.java.controler;
import java.net.URL;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sn.esmt.projet.java.model.AdminUserDao;
import sn.esmt.projet.java.model.DBConnexion;
import sn.esmt.projet.java.model.IDaoRecette;
import sn.esmt.projet.java.model.Recette;
import sn.esmt.projet.java.model.User;

public class ChauffeurCtrl {
	
	ObservableList<Recette> row = FXCollections.observableArrayList();
	
	@FXML
    private TableView<User> tableUser;

	    @FXML
	    private Button deconnectBtn;

	    @FXML
	    private TableColumn<?, ?> ladate;

	    @FXML
	    private TextField champMontant;

	    @FXML
	    private TextField champDate;

	    @FXML
	    private Button exitBtn;

	    @FXML
	    private TableColumn<Recette, String> montant;
	    @FXML
	    private TableColumn<Recette, String> date;

	    @FXML
	    private TableColumn<Recette, Integer> idTab;

	    @FXML
	    private ImageView imageUser;

	    @FXML
	    private Button addBtn;
	    
	    @FXML
	    private Button logoutBtn;
	    
	    @FXML
	    private TableView<Recette> tableView;

	    @FXML
	    void seDeconnecter(ActionEvent event) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Confirmation");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Voulez-vous quitter l'application ?");
	    	ButtonType buttonTypeOui = new ButtonType("Oui");
	    	ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

	    	alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeCancel);
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == buttonTypeOui){
	    		
	    	    Stage stage = (Stage) logoutBtn.getScene().getWindow();
	    	    stage.close();
	    	    System.exit(0);
	    	} else if (result.get() == buttonTypeCancel) {
	    	    
	    	}

	    }

	    


	    @FXML
	    void addRecette(ActionEvent event) throws Exception {
	    	 Connection connection=DBConnexion.getConnection();

	         try {
	             PreparedStatement pst;
	             String sql="INSERT INTO recette values(default,?,?) ";
	             pst= connection.prepareStatement(sql);
	            
	             pst.setString(1, champMontant.getText());
	             pst.setString(2, champDate.getText());
	          
	             pst.executeUpdate();
	    	
	         }catch(Exception e) {
	        	 e.printStackTrace();
	         }
	         liste();
	         champMontant.setText("");
	         champDate.setText("");

	    }
	    public void initialize(URL url, ResourceBundle rb) throws Exception {
	    	idTab.setCellValueFactory(new PropertyValueFactory<>("id"));
			montant.setCellValueFactory(new PropertyValueFactory<>("montantR"));
	    	ladate.setCellValueFactory(new PropertyValueFactory<>("dateR"));
	    	liste();
	    }




	    @FXML
	    void liste() throws Exception {
	    	
	    	IDaoRecette<Recette> dao = new AdminUserDao();
	  
	    	ObservableList<Recette> listes = FXCollections.observableArrayList() ; 
	    	try {
				dao.listeRecette().stream().forEach(c-> listes.add(c));
			} catch (sn.esmt.projet.java.model.DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	tableView.setItems(listes);
	    }


	


}
