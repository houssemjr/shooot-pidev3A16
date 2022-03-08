/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;

import edu.shoot.entities.Carte;
import edu.shoot.services.CrudCarte;
import edu.shoot.utiles.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class SearchCarteController implements Initializable {

  @FXML
    private TableColumn<Carte, Integer> cl1;
    @FXML
    private TableColumn<Carte, String> cl2;
    @FXML
    private TableColumn<Carte, String> cl3;
    @FXML
    private TableColumn<Carte, Integer> cl4;
    @FXML
    private TableColumn<Carte, Float> cl5;
    @FXML
    private TableColumn<Carte, Integer> cl6;
    @FXML
    private TableColumn<Carte, String> cl7;
    @FXML
    private TextField nsearch;
    @FXML
    private TableView<Carte> tab1;
    java.sql.Connection cnx = MyConnection.getInstance().getCnx();
        CrudCarte PM = new CrudCarte();
         List<Carte> PL = PM.affichercarte();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCartes();
    }    
        public void showCartes(){
        CrudCarte U=new CrudCarte();
        ObservableList<Carte> list =  U.affichercarte1();
        cl1.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        cl2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cl3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        cl4.setCellValueFactory(new PropertyValueFactory<>("level"));
        cl5.setCellValueFactory(new PropertyValueFactory<>("prix"));
        cl6.setCellValueFactory(new PropertyValueFactory<>("id_premuim"));
        cl7.setCellValueFactory(new PropertyValueFactory<>("imgcarte"));

        
        tab1.setItems(list);
    
}
   
    @FXML
    private void dll(ActionEvent event) {
        
                    try {
                        
            ObservableList<Carte> list =  PM.affichercarte1();
            
            list.setAll();
            int n = 0;
            
            
            
            String req = "SELECT * FROM cartes WHERE nom = ? ";
            PreparedStatement pst = cnx.prepareStatement(req);
//            pst.setInt(1, s);

pst.setString(1, String.valueOf(nsearch.getText()));
ResultSet rs = pst.executeQuery();
Carte f = new Carte();
while (rs.next()) {
    n = 2;
    
    System.out.println("lenaaa");
    f.setId(rs.getInt("id"));

               f.setNom(rs.getString("nom"));
               f.setPrenom(rs.getString("prenom"));
               f.setLevel(rs.getInt("level"));
               f.setPrix(rs.getFloat("prix"));

               f.setId_premuim(rs.getInt("id_premuim"));
               f.setImgcarte(rs.getString("imgcarte"));
    list.add(f);
   tab1.setItems(list);
    
}
cl7.setCellValueFactory(new PropertyValueFactory<Carte, String>("Image"));
cl3.setCellValueFactory(new PropertyValueFactory<Carte, String>("prenom"));
cl2.setCellValueFactory(new PropertyValueFactory<Carte, String>("nom"));
cl1.setCellValueFactory(new PropertyValueFactory<Carte, Integer>("id"));
cl4.setCellValueFactory(new PropertyValueFactory<Carte, Integer>("level"));
cl5.setCellValueFactory(new PropertyValueFactory<Carte, Float>("prix"));
cl6.setCellValueFactory(new PropertyValueFactory<Carte, Integer>("id_premuim"));
tab1.setItems(list);


if (n == 0) {
    Alert alt = new Alert(Alert.AlertType.ERROR, "il n'y a pas un film de ce nom", javafx.scene.control.ButtonType.OK);
    alt.showAndWait();
    showCartes();
}
        } catch (SQLException ex) {
            Logger.getLogger(ConsulterCarteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
