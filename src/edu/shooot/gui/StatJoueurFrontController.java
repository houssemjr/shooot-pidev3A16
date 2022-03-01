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
import edu.shooot.entities.Joueur;
import edu.shooot.services.JoueurCRUD;
import edu.shooot.gui.JoueurFrontController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
public class StatJoueurFrontController implements Initializable {
    @FXML
    private Label retour;
    
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
    
    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    private void CLOSE(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
//    @FXML
//    private void retour_joueur(javafx.scene.input.MouseEvent event) throws IOException {
//             
//            
//                            FXMLLoader loader = new FXMLLoader ();
//                            loader.setLocation(getClass().getResource("JoueurFront.fxml"));
//                            try {
//                                loader.load();
//                            } catch (IOException ex) {
//                                System.out.println(ex.getMessage());
//                            }
//                            
////                            ReservaController addReservController = loader.getController();
////                            addReservController. insertRecord();
//                                                     
//                            Parent parent = loader.getRoot();
//                            Stage stage = new Stage();
//                            stage.setScene(new Scene(parent));
//                            stage.initStyle(StageStyle.UTILITY);
//                            stage.show();
//         
//    
//    }


    private void back(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("JoueurFront.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(JoueurFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void home(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            
            Stage primaryStage= new Stage();
            FXMLLoader FL = new FXMLLoader(getClass().getResource("JoueurFront.fxml"));
            Parent root = FL.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
//    private void getAddView(MouseEvent event) {
//        try {
//            Parent parent = FXMLLoader.load(getClass().getResource("StatJoueurFront.fxml"));
//            Scene scene = new Scene(parent);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.initStyle(StageStyle.UTILITY);
//            stage.show();
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
    
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




