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
private final String SQL_CLASS_FILTER="SELECT `firstname`, `lastname`, `category`, `grade` , `numero` FROM `person`, `detail` WHERE ? = detail.class_id ";     
private final String SQL_ANNEE_FILTER="SELECT `firstname`, `lastname`, `category`, `grade` , `numero` FROM `person`, `detail` WHERE `year` = ? AND detail.prof_id=person.id";     
private final String SQL_ID="SELECT * FROM `person` WHERE `id` = ? ";
private ClasseDao classeDao;
    private MysqlDB mysql;


    public ProfDao() {
        classeDao=new ClasseDao();
        mysql=new MysqlDB();
    }
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
     ArrayList<Professeur> profs=null;
          try {
     profs=new ArrayList<Professeur>(); 
        mysql.initPS(SQL_ALL);       
       ResultSet rs =mysql.executeSelect();
        while(rs.next()){
            Professeur pr= new Professeur();
            pr.setId(rs.getInt("id"));         
            pr.setNom(rs.getString("firstname"));  
            pr.setPrenom(rs.getString("lastname"));   
            pr.setCategory(rs.getString("category"));
            pr.setNumero(rs.getString("numero"));

            profs.add(pr);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
    }
                  return profs;

    }

    @Override
    public Professeur selectById(int id) {
        try {
                mysql.initPS(SQL_ID);
                mysql.getPstm().setInt(1, id);
                ResultSet rs = mysql.executeSelect();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;

    }

    @Override
    public Professeur selectBy(String field) {
      try {
                mysql.initPS(SQL_BY);
                mysql.getPstm().setString(1, field);
                ResultSet rs=mysql.executeSelect();
                Professeur pr= new Professeur();
                if(rs.first()){
                    pr.setId(rs.getInt("id"));         
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                }
                if(pr!=null){
                    return pr;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            }        
    return null;
    }

    @Override
    public ArrayList<Professeur> selectBy(int annee) {
        ArrayList<Professeur> profs=null;
          try {
                profs=new ArrayList<Professeur>(); 
                mysql.initPS(SQL_ANNEE_FILTER);
                mysql.getPstm().setInt(1, annee);
                ResultSet rs=mysql.executeSelect();
                while(rs.next()){
                   Professeur pr= new Professeur();
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                    profs.add(pr);
                }
                return profs;           
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
      return null;
    
    }

    @Override
    public Professeur selectBy(String numero, String classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ArrayList<Professeur>selectByCLasse( String classe) {
    ArrayList<Professeur> profs=null;
          try {
     profs=new ArrayList<Professeur>(); 
                mysql.initPS(SQL_CLASS_FILTER);
                mysql.getPstm().setInt(1, classeDao.selectBy(classe).getId());
                ResultSet rs=mysql.executeSelect();
                while(rs.next()){
                   Professeur pr= new Professeur();
                    pr.setNom(rs.getString("firstname"));   
                    pr.setPrenom(rs.getString("lastname"));     
                    pr.setNumero(rs.getString("numero"));  
                    pr.setGrade(rs.getString("grade"));  
                    pr.setCategory(rs.getString("category"));
                    profs.add(pr);
                }
                return profs;           
            } catch (SQLException ex) {
                Logger.getLogger(ClasseDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
      return null;
    }

    @Override
    public Professeur selectBy(String numero, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
