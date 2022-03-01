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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class PanierController implements Initializable {

    @FXML
    private TableView<Panier> pt;
    @FXML
    private TableColumn<Panier, Integer> p1;
    @FXML
    private TableColumn<Panier, Integer> p2;
    @FXML
    private TableColumn<Panier, Integer> p3;
    @FXML
    private TableColumn<Panier, Float> p4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
          public void showPanier(){
        Crudpanier U=new Crudpanier();
        ObservableList<Panier> list =  U.afficherpanier1();
        p1.setCellValueFactory(new PropertyValueFactory<>("id_panier"));
        
        p2.setCellValueFactory(new PropertyValueFactory<>("id"));
        p3.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        p4.setCellValueFactory(new PropertyValueFactory<>("prix"));
        pt.setItems(list);
    
}
    @FXML
    private void REFRESHPT(MouseEvent event) {
        showPanier();
        
    }
    
}
