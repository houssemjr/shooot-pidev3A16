/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.shooot.entities.Match;
import edu.shooot.entities.Statistique;
import edu.shooot.services.MatchCRUD;
import edu.shooot.services.StatistiqueCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author khali
 */
public class AjouterStatController implements Initializable {

    @FXML
    private Button btnAjouter;
    @FXML
    private TextField txTM;
    @FXML
    private TextField txB;
    @FXML
    private TextField txBu;
    @FXML
    private TextField txP;
    @FXML
    private TextField txCo;
    @FXML
    private TextField fxF;
    @FXML
    private TextField fxCa;
    @FXML
    private TextField txID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void SaveStat(ActionEvent event) {
          if ( txID.getText().isEmpty() ||
                  txTM.getText().isEmpty() || txB.getText().isEmpty()
                || txBu.getText().isEmpty() || txP.getText().isEmpty()
                || txCo.getText().isEmpty() || fxF.getText().isEmpty()
                || fxCa.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Les champs sont vides");
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();

        } else {
            
            int Id_match = Integer.parseInt(txID.getText());
            String TitreMatch = txTM.getText();
            int But = Integer.parseInt(txB.getText());
            String N_Buteur = txBu.getText();
            String N_Passeur = txP.getText();
            int Nb_Corner = Integer.parseInt(txCo.getText());
            int Nb_faute = Integer.parseInt(fxF.getText());
            int Nb_Carton = Integer.parseInt(fxCa.getText());

            Statistique s = new Statistique (Id_match,TitreMatch, But, N_Buteur, N_Passeur, Nb_Corner, Nb_faute, Nb_Carton);
            StatistiqueCRUD mc = new StatistiqueCRUD();
            mc.ajouterStatistique2(s);

            try {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();

                Stage primaryStage = new Stage();
                FXMLLoader FL = new FXMLLoader(getClass().getResource("StatAll.fxml"));
                Parent root = FL.load();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());

               
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connection");

            alert.setHeaderText(null);
                alert.setContentText("votre Statistique a été ajoutée avec succées !");
            
            alert.showAndWait();
        }
         Notifications.create()
                        .title("Notification")
                        .text("Vous  ajouté un Statistique!").darkStyle().position(Pos.BOTTOM_CENTER)
                        .showWarning();
  }
    
}
