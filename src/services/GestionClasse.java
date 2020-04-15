/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import modeles.Classe;

/**
 *
 * @author hp
 */
public class GestionClasse implements IGestionClasse {
    ArrayList<Classe> bd = new ArrayList<>();

    @Override
    public Classe addClasse(Classe c) {
        bd.add(c);
        return c;
    }

    @Override
    public ArrayList<Classe> listerCLasse() {
        return bd;
    }
    
}
