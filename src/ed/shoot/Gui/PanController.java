/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;

import edu.shoot.entities.Carte;
import edu.shoot.entities.pan;
import edu.shoot.entities.panierr;
import edu.shoot.services.CrudCarte;
import edu.shoot.services.Crudpanier;
import edu.shoot.utiles.MyConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class PanController implements Initializable {

    @FXML
    private TableColumn<panierr, Integer> p1;
    @FXML
    private TableColumn<panierr, String> p2;
    @FXML
    private TableColumn<panierr, String> p3;
    @FXML
    private TableColumn<panierr, Float> p4;
    @FXML
    private TableView<panierr> tabp;
    @FXML
    private Button idref;
    @FXML
    private TextField totalapayer;
    @FXML
    private Button btnpayer;
    @FXML
    private Button btndelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPanier();
        // TODO
    }    
    
    public void showPanier(){
        Crudpanier cp = new Crudpanier();
         ObservableList<panierr> list =  cp.afficherpanier1();
        p1.setCellValueFactory(new PropertyValueFactory<>("idp"));
        
        p2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        p3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        p4.setCellValueFactory(new PropertyValueFactory<>("prix"));
                tabp.setItems(list);

   
                
                
        
        
        
    }
    

    @FXML
    private void ref1(ActionEvent event) {
        showPanier();
          try {
            Crudpanier dl = new Crudpanier();
            panierr pz = new panierr();
            float x=dl.calcultotal(pz);
            totalapayer.setText(String.valueOf(x));
        } catch (SQLException ex) {
            Logger.getLogger(PanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void totalap(ActionEvent event) {
      

        
    }

    @FXML
    private void btpayer(ActionEvent event) {
        Crudpanier pe = new Crudpanier();
        pe.supprimerPanier();
        
    }

    @FXML
    private void btdelete(ActionEvent event) {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation de suppression de carte");
                            alert.setHeaderText(null);
                            alert.setContentText("Vouliez vous supprimer vraiment la carte ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            

                            if (action.get() == ButtonType.OK) {
                              panierr c = tabp.getSelectionModel().getSelectedItem();

                               // String idd= tt1.getText();
                                //int id=Integer.parseInt(idd);
                                Crudpanier abb = new Crudpanier();
                                abb.suppidpan(c.getIdp());
                                showPanier();
                            }

    }
    
}
