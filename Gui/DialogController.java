/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoootpi.Gui;

import edu.shoootpi.entities.Carte;
import edu.shoootpi.entities.Panier;
import edu.shoootpi.services.CrudCarte;
import edu.shoootpi.services.Crudpanier;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class DialogController implements Initializable {

    @FXML
    private TableColumn<Carte,Integer> tc1;
    @FXML   
    private TableColumn<Carte, Float> tc2;
    @FXML
    private TableView<Carte> tv2;
    @FXML
    private Button btntarif;
    @FXML
    private TextField tar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

      
       public void showCartes(){
        CrudCarte U=new CrudCarte();
        ObservableList<Carte> list =  U.affichercarte1();
        tc1.setCellValueFactory(new PropertyValueFactory<>("id"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tv2.setItems(list);
    }

    @FXML
    private void refresht(MouseEvent event) {
        showCartes();
    }

    @FXML
    private void tarif(ActionEvent event) {
        Crudpanier cp = new Crudpanier();
        Panier pp = new Panier ();
        float y =cp.prixtotalpanier();
        
       tar.setText(String.valueOf(y));

        
         
        
        
        
        
        
    }
    



    
}
