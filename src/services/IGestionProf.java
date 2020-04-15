/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import modeles.Classe;
import modeles.Professeur;

/**
 *
 * @author hp
 */
public interface IGestionProf {
    public Professeur rechercherProf(String numero);
    public void addClasse(Professeur p,Classe c,int annee);

    
}
