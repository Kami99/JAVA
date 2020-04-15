/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import modeles.Classe;
import services.GestionClasse;
import services.GestionProf;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class GestionProfesseurController implements Initializable {

    @FXML
    private TableView<Classe> tv_classe;
    @FXML
    private DatePicker datePicker_annee;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private ComboBox<String> cmb_classe;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TableColumn<Classe, String> tv_libelleClasse;
    GestionProf gp = new GestionProf();   
    GestionClasse gc = new GestionClasse();



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<Classe> donnee = FXCollections.observableArrayList();
    
    

        
    }    
    
}
