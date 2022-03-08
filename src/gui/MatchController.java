/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.shooot.entities.Match;
import edu.shooot.services.MatchCRUD;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author khali
 */
public class MatchController implements Initializable {

    @FXML
    private Label t;
    @FXML
    private TextField txId_match;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfId_equipe1;
    @FXML
    private TextField tfId_equipe2;
    @FXML
    private TextField tfId_statistique;
    @FXML
    private TextField tfId_competition;
    @FXML
    private TextField tfId_pronostic;
    @FXML
    private Button btnAjouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void SaveMatch(ActionEvent event) {

        if (txId_match.getText().isEmpty() || tfDate.getText().isEmpty()
                || tfId_equipe1.getText().isEmpty() || tfId_equipe2.getText().isEmpty()
                || tfId_competition.getText().isEmpty() || tfId_statistique.getText().isEmpty()
                || tfId_pronostic.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Les champs sont vides");
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();

        } else {

            int Id_match = Integer.parseInt(txId_match.getText());
            String Date = tfDate.getText();
            int Id_equipe1 = Integer.parseInt(tfId_equipe1.getText());
            int Id_equipe2 = Integer.parseInt(tfId_equipe2.getText());
            int Id_comp = Integer.parseInt(tfId_competition.getText());
            int Id_stat = Integer.parseInt(tfId_statistique.getText());
            int Id_prono = Integer.parseInt(tfId_pronostic.getText());

            Match m = new Match(Id_match, Date, Id_equipe1, Id_equipe2, Id_comp, Id_stat, Id_prono);
            MatchCRUD mc = new MatchCRUD();
            mc.ajouterMatch2(m);

            try {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();

                Stage primaryStage = new Stage();
                FXMLLoader FL = new FXMLLoader(getClass().getResource("AffichageMatch.fxml"));
                Parent root = FL.load();
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());

               
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Connection");

            alert.setHeaderText(null);
            alert.setContentText("votre Match a été ajoutée avec succées !");
            
            alert.showAndWait();
        }
         Notifications.create()
                        .title("Notification")
                        .text("Vous  ajouté un Match!").darkStyle().position(Pos.BOTTOM_CENTER)
                        .showWarning();


      //  Image myImage = new Image(getClass().getResourceAsStream("Equipe1.png")) {};
// 
    }
}
