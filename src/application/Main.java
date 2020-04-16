/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author BETOE CHARLENE
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
            Parent root = FXMLLoader.load(getClass().getResource("/views/Main.fxml"));
            stage.getIcons().add(new Image("images/Logo.jpeg"));        
            stage.setTitle("School Management");   
            stage.isResizable();       



        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
