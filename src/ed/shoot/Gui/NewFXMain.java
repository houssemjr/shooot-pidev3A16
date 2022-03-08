/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafx.stage.StageStyle.TRANSPARENT;

/**
 *
 * @author houssemjrad
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
            Parent root =FXMLLoader.load(getClass().getResource("pan.fxml"));
            //  Parent root =FXMLLoader.load(getClass().getResource("Dialog.fxml"));
            
            
            
            
            Scene scene = new Scene(root);
          //  scene.setFill(Color.TRANSPARENT);
            
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setTitle("Shoot app v 1.0");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
