/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import edu.shooot.entities.Equipe;
import edu.shooot.entities.Joueur;
import edu.shooot.entities.StatJoueur;
import edu.shooot.services.EquipeCRUD;
import edu.shooot.services.JoueurCRUD;
import edu.shooot.services.StatJoueurCRUD;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FrontBackController implements Initializable {

    @FXML
    private Label retour;
    @FXML
    private Label retour1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
   @FXML
    private void Front(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("Front.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    @FXML
    private void Back(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("Back.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
