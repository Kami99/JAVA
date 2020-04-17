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
import modeles.Professeur;

/**
 *
 * @author BETOE CHARLENE
 */
public class ProfDao  implements IDao<Professeur, Classe> {
private final String SQL_ALL="SELECT * FROM `person` WHERE `category` = \"Professeur\"";
private final String SQL_INSERT="INSERT INTO `class` (`wording`, `statement`) VALUES ( ?, ?);";
private final String SQL_BY="SELECT * FROM `person` WHERE `category` = \"Professeur\" and `numero` = ? ";
private final String SQL_CLASS_FILTER="SELECT `firstname`, `lastname`, `category`, `wording` FROM `person`, `detail`, `class` WHERE 1 = class.id";     
private final String SQL_YEAR_FILTER="SELECT `firstname`, `lastname`, `category`, `wording` FROM `person`, `detail`, `class` WHERE ? = year";     
private final String SQL_ID="SELECT * FROM `person` WHERE `id` = ? ";
private ClasseDao classeDao;

    public ProfDao() {
                     classeDao=new ClasseDao();
    }





ArrayList<Professeur> profs = new ArrayList<>();

    @Override
    public int create(Professeur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Professeur obj, Classe obj2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Professeur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Professeur> selectAll() {
       try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
                PreparedStatement ps=cnx.prepareStatement(SQL_ALL);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    Professeur pr= new Professeur();
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     

                    profs.add(pr);
                }
                
                return profs;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }     
                return null;
    }

    @Override
    public Professeur selectById(int id) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
                PreparedStatement ps=cnx.prepareStatement(SQL_ID);
                ps.setInt(2, id);
                ResultSet rs=ps.executeQuery();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("firstname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("grade"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;

    }

    @Override
    public Professeur selectBy(String field) {
      try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
                PreparedStatement ps=cnx.prepareStatement(SQL_BY);
                ps.setString(1, field);
                ResultSet rs=ps.executeQuery();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("firstname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;
    }

    @Override
    public Professeur selectBy(String classe, int annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professeur selectBy(int annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professeur selectBy(String numero, String classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ArrayList<Professeur>selectByCLasse( String classe) {
        
      return null;
    }

    @Override
    public Professeur selectBy(String numero, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
