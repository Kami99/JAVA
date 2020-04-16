/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import services.FunctionController;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class GestionEtudiantController implements Initializable {

    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prenom;
    @FXML
    private TextField txt_numero;
    @FXML
    private ComboBox<?> cmb_classe;
    @FXML
    private ComboBox<?> cmb_classe_filter;
    @FXML
    private Button btn_ok;
    @FXML
    private TextField txt_anne;
    @FXML
    private ComboBox<?> cmbx_classeFilter;
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
    private Button btn_exit;
    private String nameController=null;
    FunctionController function= new FunctionController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSearchOk(ActionEvent event) {
    }

    @FXML
    private void handleInscription(ActionEvent event) {
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

    
}
