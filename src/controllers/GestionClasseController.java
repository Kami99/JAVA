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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modeles.Classe;
import services.GestionClasse;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class GestionClasseController implements Initializable {
    @FXML
    private TableView<Classe> tv_classe;
    @FXML
    private TableColumn<Classe, Integer> tv_id;
    @FXML
    private TableColumn<Classe, String> tv_libelle;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField txt_libelle;
    GestionClasse gc = new GestionClasse();

    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Classe> donnee = FXCollections.observableArrayList();
        Classe classe = new Classe("MAE 3");
        Classe classe2 = new Classe("TTL 3");
        gc.addClasse(classe); 
        gc.addClasse(classe2); 
        // TODO
              
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        donnee.addAll(gc.listerCLasse());
        tv_classe.setItems(donnee);
        tv_classe.refresh();
        System.out.println(gc.listerCLasse());
        System.out.println(tv_classe.getItems());
    }
    @FXML
    private void handleAjouterClasse(ActionEvent event) { 
        ObservableList<Classe> donnee = FXCollections.observableArrayList();
        System.out.println("classe ajout");
        String libelle = txt_libelle.getText();
        
        System.out.println(gc.listerCLasse());
        
        Classe classe = new Classe(libelle);
        gc.addClasse(classe);
        System.out.println(gc.listerCLasse());
        
        donnee.addAll(gc.listerCLasse());
        tv_classe.setItems(donnee);
        tv_classe.refresh();
        
    }
    
}
