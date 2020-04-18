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
    public Professeur rechercherProf(String numero, String nom, String prenom) {
        return profDao.selectBy(numero, nom, prenom);
    }
    public Professeur addProfesseur(Professeur p) {
        return p;
    }
    //Si le prof existe
    public int addProfesseur(Detail detail, Professeur p, String classe) {
        return profDao.create(detail, p, classe);
    }
    //Si lle prof n'existe pas
    public int addProfesseur(Professeur prof, Detail detail, String classe) {
        return profDao.create(prof, detail, classe);
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
        public ArrayList<Professeur> filterByAnnee(int annee){
        return profDao.selectBy(annee);
    }
}
