/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.gui;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shooot.entities.User;
import shooot.services.UserCRUD;

/**
 * FXML Controller class
 *
 * @author HP PC
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPwd;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void acceuil(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("AjouterAdmin.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    @FXML
    private void connecter(ActionEvent event) {
       
        String login = tfEmail.getText();
        String password = tfPwd.getText();
       
        UserCRUD UC = new UserCRUD();
        UC.checkUser1(login, password);
    
        
        User user=new User();     /**
        redirection if connected
        */
        if(user != null){
            try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("tableUser.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }

    
}
