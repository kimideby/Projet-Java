package sn.esmt.projet.java.controler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import sn.esmt.projet.java.model.User;

public class ListCtrl {


    @FXML
    private TableView<User> tableUser;

    @FXML
    private TableColumn<?, ?> t_role;

    @FXML
    private TextField searchField;

    

    @FXML
    private TableColumn<?, ?> id_login;



    @FXML
    private TableColumn<?, ?> immatBus;


    @FXML
    private TableColumn<?, ?> parkBus;

   

    @FXML
    private TableColumn<?, ?> ligneBus;

    @FXML
    private TableColumn<?, ?> idBus;


    @FXML
    private ChoiceBox<?> genderChoice;


    @FXML
    private TableColumn<?, ?> sourceBus;


    @FXML
    private TableColumn<?, ?> destBus;


    @FXML
    private TableView<?> tableBus;


    @FXML
    private TableColumn<?, ?> id_User;


    @FXML
    private ChoiceBox<?> etatchoice;

    @FXML
    private TextField age;

    @FXML
    void annuler(ActionEvent event) {

    }

    @FXML
    void inscription(ActionEvent event) {

    }

    @FXML
    void addChauffeur(ActionEvent event) {

    }

    @FXML
    void resetChauffeur(ActionEvent event) {

    }

    
    
    @FXML
    void addBus(ActionEvent event) {

    }

}
