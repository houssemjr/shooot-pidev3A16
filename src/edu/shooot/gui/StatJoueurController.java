/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import edu.shooot.entities.StatJoueur;
import edu.shooot.services.StatJoueurCRUD;
import edu.shooot.utils.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import edu.shooot.entities.Equipe;
import edu.shooot.entities.Joueur;
import edu.shooot.entities.StatJoueur;
import edu.shooot.services.EquipeCRUD;
import edu.shooot.services.JoueurCRUD;
import edu.shooot.services.StatJoueurCRUD;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class StatJoueurController implements Initializable {

    @FXML
    private JFXButton btnRetour;
    @FXML
    private TableView<StatJoueur> tvStat;
    @FXML
    private TableColumn<StatJoueur, String> colJoueur;
    @FXML
    private TableColumn<StatJoueur, String> colComp;
    @FXML
    private TableColumn<StatJoueur, String> colBut;
    @FXML
    private TableColumn<StatJoueur, String> colAssist;
    @FXML
    private JFXTextField tfJoueur;
    @FXML
    private JFXTextField tfComp;
    @FXML
    private JFXTextField tfBut;
    @FXML
    private JFXTextField tfAssist;
    @FXML
    private JFXButton btnAjouter;
    
    String query = null;
    Connection cnx = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    StatJoueur StatJoueur = null; 
    
    
    
    ObservableList<StatJoueur>  StatJoueurList = FXCollections.observableArrayList();
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table();
        refreshTable();
    }    
    
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void CLOSE(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void homee(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("Joueur.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    

    
    void clear() {
        tfJoueur.setText(null);
        tfComp.setText(null);
        tfBut.setText(null);
        tfAssist.setText(null);
        
    }
    
    @FXML
    private void AjouterStat(ActionEvent event) {
        
        String nom_joueur = tfJoueur.getText();
        String nom_comp = tfComp.getText();
        String but = tfBut.getText();
        int but_comp = Integer.parseInt(but);
        String assist = tfAssist.getText();
        int assist_comp = Integer.parseInt(assist);
        
        
        
        StatJoueur s = new StatJoueur(nom_joueur, nom_comp, but_comp, assist_comp);
        StatJoueurCRUD sc = new StatJoueurCRUD();
        sc.ajouterStatJoueur(s);
        refreshTable();
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        alert.setTitle("Stat joueur");
        alert.setHeaderText("Ajouter Stat Joueur");
        alert.setContentText("Vos stat joueur ont été ajouter avec succès!");
        alert.showAndWait();

            clear();
    }
   
    
    
    
    private void getAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("StatJoueur.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void refreshTable(){

        try {

            StatJoueurList.clear();

            StatJoueurCRUD jc = new StatJoueurCRUD();
            ResultSet rs = jc.afficherStatJoueur();

            while (rs.next()) {
                StatJoueur j;
                j = new StatJoueur(rs.getString("nom_joueur"), rs.getString("nom_comp"), rs.getInt("but_comp"), rs.getInt("assist_comp"));
                
                StatJoueurList.add(j);
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        tvStat.setItems(StatJoueurList);
    }
    
    
    private void table() {
        cnx = MyConnection.getInstance().getCnx();

        refreshTable();

        colJoueur.setCellValueFactory(new PropertyValueFactory<>("nom_joueur"));
        colComp.setCellValueFactory(new PropertyValueFactory<>("nom_comp"));
        colBut.setCellValueFactory(new PropertyValueFactory<>("but_comp"));
        colAssist.setCellValueFactory(new PropertyValueFactory<>("assist_comp"));

        

        tvStat.setItems(StatJoueurList);
        
        


    }
   
    
}
