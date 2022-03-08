/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;
import javafx.application.Application;
import javafx.scene.control.DatePicker;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.time.LocalDate;
import java.util.*;


/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class MainController implements Initializable {

    @FXML
    private Pane z1;
    @FXML
    private VBox VBox;
    @FXML
    private Button btn_seconnecter;
    @FXML
    private Button btn_sinscrire;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
            TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
            t.setToX(VBox.getLayoutX() * 2.2);
            t.play();
    }       

    @FXML
    private void openSignin(ActionEvent event) {
      TranslateTransition t= new TranslateTransition(Duration.seconds(1),VBox);
            t.setToX(VBox.getLayoutX() * 20.25);
            t.play();
    }

    @FXML
    private void openSignup(ActionEvent event) {
          TranslateTransition t = new TranslateTransition(Duration.seconds(1),VBox);
        t.setToX(1);
        t.play();
    }
    
}
