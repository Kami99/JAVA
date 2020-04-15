/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import modeles.Classe;
import modeles.Detail;
import modeles.Professeur;
import services.GestionClasse;
import services.GestionProf;
import services.ServiceDetail;

/**
 * FXML Controller class
 *
 * @author BETOE CHARLENE
 */
public class ListerProfesseurController implements Initializable {

    @FXML
    private TextField txt_numeroFilter;
    @FXML
    private Button btn_ok;
    @FXML
    private DatePicker txt_anneFilter;
    @FXML
    private TableColumn<Professeur, String> tv_nom;
    @FXML
    private TableColumn<Professeur, String> tv_prenom;
    @FXML
    private TableView<Classe> tv_classe;
    @FXML
    private ComboBox<String> cmb_classeFilter;
    @FXML
    private TableView<Professeur> tv_Professeur;
    @FXML
    private TableColumn<Classe, String> tv_classeLibelle;
    GestionProf gp=new GestionProf();       
    GestionClasse gc=new GestionClasse();   

    Professeur p=new Professeur("Karim", "Ndong", "4");  
    Professeur p2=new Professeur("lacrim", "Algerien", "14");  
    Professeur p3=new Professeur("Niro", "92i", "8");
    
    Classe c=new Classe("MAE");      
    Classe c1=new Classe("KOL");  
    Classe c2=new Classe("OVB");  
    Detail d1=new Detail(2017, p, c1);    
    Detail d2=new Detail(2018, p, c2);
    
    ServiceDetail sd= new ServiceDetail();
    




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ObservableList<Professeur> donneeProfesseur = FXCollections.observableArrayList();
    sd.addDetail(d1);    
    sd.addDetail(d1);
    gc.addClasse(c);    
    gc.addClasse(c1);
    gc.addClasse(c2);
    gp.addProfesseur(p);  
    gp.addProfesseur(p2);
    gp.addProfesseur(p3);
        for (Classe classe : gc.listerCLasse()) {
                    cmb_classeFilter.getItems().add(classe.getLibelle());
        }
    
    tv_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    tv_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    donneeProfesseur.addAll(gp.listerProfs());
    tv_Professeur.setItems(donneeProfesseur);
    tv_Professeur.refresh();
    System.out.println(gc.listerCLasse());
    System.out.println(tv_Professeur.getItems());
    }    
    @FXML
    private void handleSearchProfesseur(ActionEvent event){
        ObservableList<Professeur> donneeProfesseur = FXCollections.observableArrayList();
        String numero= txt_numeroFilter.getText();
        Professeur resultProf = gp.rechercherProf(numero);
        if(resultProf!=null){
            donneeProfesseur.addAll(resultProf);
            tv_Professeur.setItems(donneeProfesseur);
            tv_Professeur.refresh();
            System.out.println(resultProf);

        }
        

    }

    @FXML
    private void handleanneFilter(ActionEvent event) {

        
        
    }

    @FXML
    private void handleClassFilter(ActionEvent event) {
       ObservableList<Professeur> donneeProfesseur = FXCollections.observableArrayList();
       ArrayList<Professeur> pList= new ArrayList<>();
        String classe= cmb_classeFilter.getValue();
        ArrayList<Professeur> resultProf = sd.rechercherProf(classe);
        if(resultProf!=null){
            donneeProfesseur.addAll(resultProf);
            tv_Professeur.setItems(donneeProfesseur);
            tv_Professeur.refresh();
            System.out.println(resultProf);

        }  
    }
    }
    
