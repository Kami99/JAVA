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
import modeles.Classe;

/**
 *
 * @author BETOE CHARLENE
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    private final String SQL_ALL="SELECT * FROM `class`";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         ArrayList<Classe> classes = null;

        Class.forName("com.mysql.jdbc.Driver");
        Connection cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_management", "root", "");
        PreparedStatement ps=cnx.prepareStatement("SELECT * FROM `class`");
        ResultSet rs = ps.executeQuery();
        System.out.println(rs);
        while(rs.next()){
            System.out.println(rs.getInt("id"));    
            System.out.println(rs.getString("wording"));   


        }
        /*
        while(rs.next()){
            Classe cl= new Classe();
            cl.setId(rs.getInt("id"));   
            cl.setLibelle(rs.getString("wording"));
            classes.add(cl);
                    }
        if(classes!=null){
            System.out.println(classes);
        }*/
          

    }
    
}
