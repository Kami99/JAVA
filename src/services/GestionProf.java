/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProfDao;
import java.util.ArrayList;
import modeles.Classe;
import modeles.Detail;
import modeles.Professeur;

/**
 *
 * @author hp
 */
public class GestionProf implements IGestionProf {
        private ProfDao profDao;

    public GestionProf() {
                profDao=new ProfDao();

    }

    @Override
    public Professeur rechercherProf(String numero) {
        return profDao.selectBy(numero);
    }
    public Professeur addProfesseur(Professeur p) {
        return p;
    }

    @Override
    public void addClasse(Professeur p,Classe c,int annee) {
        Detail detail = new Detail(annee,p,c);
        p.getDetails().add(detail);
    }

   
    
    public ArrayList<Professeur> listerProfs(){
        return profDao.selectAll();
    }
        
    public ArrayList<Professeur> filterByclasse(String classe){
        return profDao.selectByCLasse(classe);
    }
}
