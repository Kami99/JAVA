/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modeles.Classe;
import services.FunctionController;
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
    private Button btn_enregistrer;
    @FXML
    private ComboBox<String> cmb_classe;
    @FXML
    private TableColumn<Classe, String> tv_libelleClasse;
    GestionProf gp = new GestionProf();   
    GestionClasse gc = new GestionClasse();
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_numero;
    @FXML
    private TextField txt_prenom;
    @FXML
    private Button btn_home;
    @FXML
    private Button btn_Gestion_Classe;
    @FXML
    private Button btn_GestionProf;
    @FXML
    private Button btn_List_prof;
    @FXML
    private Button btn_G_Etudiant;
    @FXML
    private TextField txt_annee;
    @FXML
    private Button btn_exit;
    private String nameController=null;
    FunctionController function= new FunctionController();
    @FXML
    private Button btn_searchProf;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<Classe> donnee = FXCollections.observableArrayList();
    
    

        
    }    

   

    @FXML
    private void handlechangeViewHome(ActionEvent event) throws IOException {
        nameController="Main";
        function.changeViews(btn_home, nameController);
    }

    @FXML
    private void handlechangeViewClasse(ActionEvent event) throws IOException {
         nameController="GestionClasse";
         function.changeViews(btn_Gestion_Classe, nameController);
    }

    @FXML
    private void handleChangeViewProfesseur(ActionEvent event) throws IOException {
         nameController="GestionProfesseur";     
         function.changeViews(btn_GestionProf, nameController);
    }

    @FXML
    private void handleChangeViewListe(ActionEvent event) throws IOException {
         nameController="ListerProfesseur";     
         function.changeViews(btn_List_prof, nameController);
    }

    @FXML
    private void handleChangeViewEtudiant(ActionEvent event) throws IOException {
         nameController="GestionEtudiant";     
         function.changeViews(btn_G_Etudiant, nameController);
    }
    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        function.closeWindow(btn_exit);
    }

    @FXML
    private void handleSearch(ActionEvent event) {
    }

    
}
