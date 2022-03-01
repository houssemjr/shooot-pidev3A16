/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import edu.shooot.entities.Equipe;
import edu.shooot.services.EquipeCRUD;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import edu.shooot.entities.Equipe;
import edu.shooot.services.EquipeCRUD;
import edu.shooot.utils.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
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

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EquipeFrontController implements Initializable {

    @FXML
    private TableView<Equipe> tvEquipe;
    @FXML
    private TableColumn<Equipe, Integer> colId;
    @FXML
    private TableColumn<Equipe, String> colNom;
    @FXML
    private TableColumn<Equipe, String> colPays;
    @FXML
    private TableColumn<Equipe, String> colLogo;
    @FXML
    private TableColumn<Equipe, String> editcol;

    String query = null;
    Connection cnx = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Equipe Equipe = null ;
    
    ObservableList<Equipe>  EquipeList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

         table();
         refreshTable();
         
    }    
    
    @FXML
    private void getAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Equipe.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void home(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("Front.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(JoueurFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
  
    
   @FXML
    private void refreshTable() {

        try {

            EquipeList.clear();

            EquipeCRUD ec = new EquipeCRUD();
            ResultSet rs = ec.afficherEquipe();

            while (rs.next()) {
                Equipe e;
                e = new Equipe(rs.getString("nom_equipe"), rs.getString("pays"), rs.getString("logo"));
                
                EquipeList.add(e);
                e.setId_equipe(rs.getInt("id_equipe"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        tvEquipe.setItems(EquipeList);
    }
 
    
    private void table() {
        cnx = MyConnection.getInstance().getCnx();

        refreshTable();

        colId.setCellValueFactory(new PropertyValueFactory<>("id_equipe"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        colPays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        colLogo.setCellValueFactory(new PropertyValueFactory<>("logo"));
        

               

        
        tvEquipe.setItems(EquipeList);
        
        

    }
    
    
    
    
}
