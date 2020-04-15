/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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
    private DatePicker datePicker_filter;
    @FXML
    private ComboBox<?> cmb_classe_filter;
    @FXML
    private Button btn_inscrire;
    @FXML
    private TableColumn<?, ?> tv_nom;
    @FXML
    private TableColumn<?, ?> tv_prenom;
    @FXML
    private TableColumn<?, ?> tv_classe;
    @FXML
    private TableColumn<?, ?> tv_anneScolaire;
    @FXML
    private Button btn_ok;
    @FXML
    private TextField txt_anne;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
