/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import modeles.Classe;
import modeles.Detail;
import modeles.Professeur;

/**
 *
 * @author hp
 */
public class GestionProf implements IGestionProf {
    ArrayList<Professeur> bd = new ArrayList<>();

    @Override
    public Professeur rechercherProf(String numero) {
        for(Professeur p: bd){
            if(p.getNumero().compareTo(numero) == 0){
                return p;
            }
        }
        return null;
    }
    public Professeur addProfesseur(Professeur p) {
        bd.add(p);
        return p;
    }

    @Override
    public void addClasse(Professeur p,Classe c,int annee) {
        Detail detail = new Detail(annee,p,c);
        p.getDetails().add(detail);
    }

   
    
    public ArrayList<Professeur> listerProfs(){
        return bd;
    }
}
