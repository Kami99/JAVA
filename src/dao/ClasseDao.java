/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeles.Classe;
import modeles.Personne;

/**
 *
 * @author BETOE CHARLENE
 */
public class ClasseDao implements IDao<Classe, Personne> {
private final String SQL_ALL="Select * From class ";
private final String SQL_BY_ID="Select * From class where wording = ?";

private final String SQL_INSERT="INSERT INTO `class` (`wording`, `statement`) VALUES ( ?, ?);";
ArrayList<Classe> classes = new ArrayList<>();


    @Override
    public int create(Classe obj) {
       int result=0;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
        PreparedStatement ps=cnx.prepareStatement(SQL_INSERT);
        ps.setString(1, obj.getLibelle());  
        ps.setBoolean(2, obj.isStatement());
        result=ps.executeUpdate();


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
 
    }

    @Override
    public int create(Classe obj, Personne obj2) {
        throw new UnsupportedOperationException("Vous ne pouvez pas executez cette méthode"); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public boolean update(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Classe> selectAll() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
        PreparedStatement ps=cnx.prepareStatement(SQL_ALL);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Classe cl= new Classe();
            cl.setId(rs.getInt("id"));         
            cl.setLibelle(rs.getString("wording"));
            classes.add(cl);

        
        }
        if(classes != null){
        return classes;
        }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    }     
        return null;
    }

    @Override
    public Classe selectById(int id) {       
    return null;
    }


    @Override
    public Classe selectBy(String field) {
           try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
                PreparedStatement ps=cnx.prepareStatement(SQL_BY_ID);
                ps.setString(1, field);
                ResultSet rs=ps.executeQuery();
                Classe cl= new Classe();
                if(rs.first()){
                    cl.setId(rs.getInt("id")); 
                    cl.setLibelle(rs.getString("wording"));        
                    }
                if(cl!=null){
                    return cl;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }     
    return null;
    }

    @Override
    public Classe selectBy(String classe, int annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe selectBy(int annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe selectBy(String numero, String classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe selectBy(String numero, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
}
