package sn.esmt.projet.java.controler;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional ;


import com.mysql.jdbc.Connection;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sn.esmt.projet.java.model.AdminUserDao;
import sn.esmt.projet.java.model.Bus;
import sn.esmt.projet.java.model.Chauffeur;
import sn.esmt.projet.java.model.DAOException;
import sn.esmt.projet.java.model.DBConnexion;
import sn.esmt.projet.java.model.IDaoBus;
import sn.esmt.projet.java.model.IDaoChauffeur;
import sn.esmt.projet.java.model.IDaoTrajet;
import sn.esmt.projet.java.model.IDaoUser;
import sn.esmt.projet.java.model.Trajet;
import sn.esmt.projet.java.model.User;
import sn.esmt.projet.java.model.UserDAO;

public class AdminCtrl {
	
	ObservableList<Trajet> data = FXCollections.observableArrayList();
	
	/**Accueil*/

    @FXML
    private TextField loginUser;

    @FXML
    private TextField roleUser;

    @FXML
    private Text auth;

    @FXML
    private AnchorPane background;

    @FXML
    private Button connexion;

    @FXML
    private PasswordField pwdUser;

    
    
    /**controller Admin
     * */
    @FXML
    private Button annulerSaisie;    

    @FXML
    private TextField champPrenom;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField champdateNaissance;

    @FXML
    private TextField champrue;

    @FXML
    private TextField champage;

    @FXML
    private TextField champlieuNaissance;

    @FXML
    private TextField champQuartier;

    @FXML
    private TextField champMail;

    @FXML
    private TextField champNom;

    @FXML
    private TextField champPhone;

    @FXML
    private Button ajout;

    @FXML
    private TextField champville;
    
    
    /**Bus*/
    /**trajet*/
    

    @FXML
    private TextField idField;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField searchField;

    @FXML
    private Button addBtnBus;


    @FXML
    private TextField champLigne;

    @FXML
    private TextField lieuField;

    @FXML
    private TextField prenomField;
    
    @FXML
    private TableView<Bus> tableBus;
    
    @FXML
    private TableColumn<Bus, String> immatBus;
    
    @FXML
    private TableColumn<Bus, String> ligneBus;

    @FXML
    private TableColumn<Bus, Integer> idBus;

    @FXML
    private TableColumn<Bus, Trajet> destBus;

    @FXML
    private TableColumn<Bus, String> parkBus;
    
    @FXML
    private TableColumn<Bus, String> sourceBus;
    
    @FXML
    private Button resetBtnBus;

    @FXML
    private TextField champImmat;

    @FXML
    private Button deconectBtn;

    @FXML
    private ChoiceBox<String> genderChoice;

    @FXML
    private Button ajoutBtn;
    
    @FXML
    private ComboBox<Trajet> comboTrajet;


    @FXML
    private Button rechBtn;

    @FXML
    private Button createBtn;

    @FXML
    private TextField emailField;

    @FXML
    private TextField champSearch;

    @FXML
    private Button suppBtn;

   

    @FXML
    private TextField nomField;

    @FXML
    private TextField adresseField;
    
    @FXML
    private TextField telephoneField;

    @FXML
    private Button annulerBtn;

    @FXML
    private Button modifBtn;

    @FXML
    private TextField champPark;

    

    @FXML
    private TableView<Chauffeur> chauffeur_tv;

    @FXML
    private TableColumn<Chauffeur, Integer> idChauf_colonne;

    @FXML
    private TableColumn<Chauffeur, String> nomChauf_colonne;

    @FXML
    private TableColumn<Chauffeur, String> prenomChauf_colonne;

    @FXML
    private TableColumn<Chauffeur, String> emailChauf_colonne;

    @FXML
    private TableColumn<Chauffeur, String> phoneChauf_colonne;

    @FXML
    private TableColumn<Chauffeur, String> adresse_colonne;
    
    @FXML
    private TableView<Trajet> trajet_tv;
    

    @FXML
    private TableColumn<Trajet, Integer> idTrajet_colonne;

    @FXML
    private TableColumn<Trajet, String> source_colonne;

    @FXML
    private TableColumn<Trajet, String> destination_colonne;

    @FXML
    private Button boutonSearch;

    @FXML
    void createUser(ActionEvent event) {

    }
    

    
    
    /**
     * ajouter un chauffeur*/
    @FXML
    void addChauffeur(ActionEvent event) throws Exception { 
    	String nom = nomField.getText();
    	String prenom = prenomField.getText();
    	String telephone = telephoneField.getText();
    	String email = emailField.getText();
	    String adresse = adresseField.getText();
    	Chauffeur chauff=  new Chauffeur(nom, prenom,telephone,email,adresse);
    	AdminUserDao dao= new AdminUserDao();
    	dao.createChauf(chauff);
    	listeChauf();
	    Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("succès!!!");
	    alert.setContentText("creation effectuez avec succès");
    	alert.showAndWait() ;
    	listeBus();
    	listeTrajet();
    }
    
    @FXML
    private TableView<User> tableUser;

	private void listeUs() throws Exception {
		IDaoUser<User> idao= new AdminUserDao();
    	ObservableList<User> listes = FXCollections.observableArrayList() ; 
    	try {
			idao.listeUser().stream().forEach(c-> listes.add(c));
	    	tableUser.setItems(listes); ;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void listeBus() throws Exception  {
    	AdminUserDao idao= new AdminUserDao();
    	ObservableList<Bus> listes = FXCollections.observableArrayList() ; 
    	try {
			idao.listeBus().stream().forEach(c-> listes.add(c));
	    	tableBus.setItems(listes);
		} catch (sn.esmt.projet.java.model.DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void listeTrajet() throws Exception  {		
    	AdminUserDao idao= new AdminUserDao();
    	ObservableList<Trajet> listes = FXCollections.observableArrayList() ; 
    	try {
			idao.listeTra().stream().forEach(c-> listes.add(c));
	    	trajet_tv.setItems(listes);
		} catch (sn.esmt.projet.java.model.DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
/**
 * reset chauffeur*/
    @FXML
    void resetChauffeur(ActionEvent event) {
    	nomField.setText("");
    	prenomField.setText("");
    	telephoneField.setText("");
    	emailField.setText("");
    	adresseField.setText("");  	
    }
/**
 * reset trajet*/
    @FXML
    void annulerTrajets(ActionEvent event) {
    	source.setText("");
    	destination.setText("");
    }


    @FXML
    void supprimerBus(ActionEvent event) throws Exception {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Confirmation");
    	alert.setHeaderText(null);
    	alert.setContentText("Voulez-vous supprimer ce bus ?");
    	ButtonType buttonTypeOui = new ButtonType("Oui");
    	ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

    	alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeCancel);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonTypeOui){
    		
    		IDaoBus<Bus> dao = new AdminUserDao() ;
			int selectedIndex = tableBus.getSelectionModel().getSelectedIndex();
			int selectedItem = idBus.getCellData(selectedIndex);
			if(selectedIndex >= 0){
			tableBus.getItems().remove(selectedIndex);
			dao.deleteBus(selectedItem);
			
			}
    	    
    	} else if (result.get() == buttonTypeCancel) {
    	    
    	}
    }
    
    @FXML
    private ChoiceBox<String> etatchoice;
    ObservableList<String> role = FXCollections.observableArrayList("En panne","En reparation","En fonctionnement");
    
    @FXML
    private TableColumn<User, Integer> id_User;
    
    @FXML
    private TableColumn<User, String> id_login;

    @FXML
    private TableColumn<User, String> t_role;
    
    
    /**
     * methode d'initialisation*/
    @FXML
    private void initialize() throws Exception {
    	
    	etatchoice.setItems(role);
    	BindDataTrajet();
    	
    	id_User.setCellValueFactory(new PropertyValueFactory<>("id"));
    	id_login.setCellValueFactory(new PropertyValueFactory<>("login"));
    	t_role.setCellValueFactory(new PropertyValueFactory<>("role"));
    	listeUs();
    	
		idTrajet_colonne.setCellValueFactory(new PropertyValueFactory<>("idTrajet"));
		source_colonne.setCellValueFactory(new PropertyValueFactory<>("source"));
		destination_colonne.setCellValueFactory(new PropertyValueFactory<>("destination"));
		listeTrajet();
		
		idChauf_colonne.setCellValueFactory(new PropertyValueFactory<>("idChauff"));
		nomChauf_colonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenomChauf_colonne.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		adresse_colonne.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		emailChauf_colonne.setCellValueFactory(new PropertyValueFactory<>("email"));
		listeChauf();
		
		idBus.setCellValueFactory(new PropertyValueFactory<>("idBus"));
		immatBus.setCellValueFactory(new PropertyValueFactory<>("matriculation"));
		ligneBus.setCellValueFactory(new PropertyValueFactory<>("ligneBus"));
		parkBus.setCellValueFactory(new PropertyValueFactory<>("garage"));
		sourceBus.setCellValueFactory(new PropertyValueFactory<>("source"));
		destBus.setCellValueFactory(new PropertyValueFactory<>("trajet"));
		
		listeBus();
		charger_trajet();
   }
    
    void charger_trajet() throws Exception {
		IDaoTrajet<Trajet> idao = new AdminUserDao() ; 
		List<Trajet> liste = idao.listeTra() ;
		for(Trajet trajet:liste) {
			comboTrajet.getItems().add(trajet) ;
		}
    }
    /**
     * la methode ajouter bus*/
    @FXML
    void addBus(ActionEvent event) throws Exception {
    	String matriculation = champImmat.getText();	
    	String  numeroLigne = champLigne.getText();  	
    	String garage =champPark.getText();
    	String choix= etatchoice.getSelectionModel().getSelectedItem();
    	Trajet trajet = comboTrajet.getSelectionModel().getSelectedItem() ;
    	Bus bus = new Bus(matriculation,garage,numeroLigne, choix);
    	bus.setTrajet(trajet);
    	AdminUserDao dao= new AdminUserDao();
    	dao.createBus(bus);
    	
    	 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Confirmation");
		 alert.setHeaderText("succès!!!");
	     alert.setContentText("creation effectuez avec succès");
	     alert.showAndWait() ;
	     listeBus();
	     
	     champImmat.setText("");
    	 champLigne.setText("");
    	 champPark.setText("");
    	 etatchoice.setValue("");
    	 comboTrajet.setValue(trajet);
    }
    
    /**
     * la methode reset bus*/
    @FXML
    void resetBus(ActionEvent event) {
    	 champImmat.setText("");
    	 champLigne.setText("");
    	 champPark.setText("");   	 
    }  

/**
 * la fonction reset chauffeur*/

    
    /**
     * la fonctin ajouter un trajet*/
    @FXML
    private TextField source;
    
    @FXML
    private TextField destination;
    
    @FXML
    void ajoutTrajet(ActionEvent event) throws Exception {    	
    	String src=source.getText();
    	String dest =destination.getText();
    	AdminUserDao dao= new AdminUserDao();    	
	    Trajet trajet= new Trajet(src,dest);
	    dao.createTra(trajet);  
	 	listeChauf();
    	listeBus();
    	listeTrajet();
		charger_trajet();
		source.setText("");
		destination.setText("");
    }
    
    @FXML
    void listeBus(ActionEvent event) throws Exception {
    	
    	IDaoBus<Bus> dao=new AdminUserDao();
  
    	ObservableList<Bus> listes = FXCollections.observableArrayList() ; 
    	try {
			dao.listeBus().stream().forEach(c-> listes.add(c));
		} catch (sn.esmt.projet.java.model.DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	tableBus.setItems(listes);
    }
    
    void listeChauf() throws Exception  {
    	
    	IDaoChauffeur<Chauffeur> idao= new AdminUserDao();
  
    	ObservableList<Chauffeur> listes = FXCollections.observableArrayList() ; 
    	try {
			idao.listeChauf().stream().forEach(c-> listes.add(c));
		} catch (sn.esmt.projet.java.model.DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	chauffeur_tv.setItems(listes);
    }
 
    /**
     * la fonction creer un compte d'utilisateur*/
    @FXML
    void inscription(ActionEvent event) throws Exception {
    	
    	String login = loginUser.getText();
    	String pwd =  pwdUser.getText();
    	String role = roleUser.getText();
    	
    	User user = new User(login, pwd, role);
    	AdminUserDao dao= new AdminUserDao();
    	dao.createUser(user);    		
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("Confirmation");
   		alert.setHeaderText("creation du compte effectuez avec succès!!!");
   	    alert.showAndWait();
   	    
    	loginUser.setText("");	
    	roleUser.setText("");
    	pwdUser.setText("");    	
    }
    /**
     * la fonction reset user
     * *
     */
     

    @FXML
    void annuler(ActionEvent event) {
    	loginUser.setText("");	
    	roleUser.setText("");
    	pwdUser.setText("");  	
    }

    
    /**
     * la fonction  deconnexion*/

    @FXML
    void deconnexion(ActionEvent event) {
     	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Confirmation");
    	alert.setHeaderText(null);
    	alert.setContentText("Voulez-vous quitter l'application ?");
    	ButtonType buttonTypeOui = new ButtonType("Oui");
    	ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

    	alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeCancel);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonTypeOui){
    		
    	    Stage stage = (Stage) deconectBtn.getScene().getWindow();
    	    stage.close();
    	    System.exit(0);
    	} else if (result.get() == buttonTypeCancel) {
    	    
    	}
    }
    
    public void BindDataTrajet() throws Exception
    {
    	Connection conn =(Connection) DBConnexion.getConnection();
    	try {
    		
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT id_trajet FROM trajet");
            while (rs.next()) {
                //get string from db,whichever way 
            	Trajet t = new Trajet();
            	int id_trajet = t.getIdTrajet();
                data.add(rs.getInt(id_trajet), null);
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }


    	} 
    @FXML
    void supprimerUser() throws Exception {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Confirmation");
    	alert.setHeaderText(null);
    	alert.setContentText("Voulez-vous supprimer cet utilisateur ?");
    	ButtonType buttonTypeOui = new ButtonType("Oui");
    	ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

    	alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeCancel);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonTypeOui){
    		
    		IDaoUser<User> dao = new UserDAO() ;
			int selectedIndex = tableUser.getSelectionModel().getSelectedIndex();
			int selectedItem = id_User.getCellData(selectedIndex);
			if(selectedIndex >= 0){
			tableUser.getItems().remove(selectedIndex);
			dao.deleteUser(selectedItem);
			
			}
    	    
    	} else if (result.get() == buttonTypeCancel) {
    	    
    	}
    	
    }
    @FXML
    void supprimerChauffeur() throws Exception {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Confirmation");
    	alert.setHeaderText(null);
    	alert.setContentText("Voulez-vous supprimer cet utilisateur ?");
    	ButtonType buttonTypeOui = new ButtonType("Oui");
    	ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

    	alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeCancel);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonTypeOui){
    		
    		IDaoChauffeur<Chauffeur> dao = new AdminUserDao() ;
			int selectedIndex = chauffeur_tv.getSelectionModel().getSelectedIndex();
			int selectedItem = idChauf_colonne.getCellData(selectedIndex);
			if(selectedIndex >= 0){
			chauffeur_tv.getItems().remove(selectedIndex);
			dao.deleteChauf(selectedItem);
			
			}
    	    
    	} else if (result.get() == buttonTypeCancel) {
    	    
    	}
    	
    }
    @FXML
    void supprimerTrajet() throws Exception {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Confirmation");
    	alert.setHeaderText(null);
    	alert.setContentText("Voulez-vous supprimer cet utilisateur ?");
    	ButtonType buttonTypeOui = new ButtonType("Oui");
    	ButtonType buttonTypeCancel = new ButtonType("Non", ButtonData.CANCEL_CLOSE);

    	alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeCancel);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonTypeOui){
    		
    		IDaoTrajet<Trajet> dao = new AdminUserDao() ;
			int selectedIndex = trajet_tv.getSelectionModel().getSelectedIndex();
			int selectedItem = idTrajet_colonne.getCellData(selectedIndex);
			if(selectedIndex >= 0){
			chauffeur_tv.getItems().remove(selectedIndex);
			dao.deleteTra(selectedItem);
			
			}
    	    
    	} else if (result.get() == buttonTypeCancel) {
    	    
    	}
    	
    }
}

