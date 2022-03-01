/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoootpi.Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import edu.shoootpi.entities.Carte;
import edu.shoootpi.services.CrudCarte;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class AjoutercarteController implements Initializable {

    @FXML
    private TextField a1;
    @FXML
    private TextField a2;
    @FXML
    private TextField a3;
    @FXML
    private TextField a4;
    @FXML
    private Button boutonajouter;

    @FXML
    private AnchorPane w1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouterCarte(ActionEvent event) {
        String nom = a1.getText();
        String prenom = a2.getText();
        int level = Integer.parseInt(a3.getText());
        float prix = Float.parseFloat(a4.getText());
        int id_premuim = Integer.parseInt(a4.getText());
        
         Carte c =new Carte (nom,prenom,level,prix,id_premuim);
         CrudCarte cc = new CrudCarte();
         cc.ajouterCarte(c);

    }

}
