/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.gui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.oracle.util.Checksums.update;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import edu.shooot.entities.Joueur;
import edu.shooot.services.JoueurCRUD;
import edu.shooot.utils.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.control.ComboBox;
import edu.shooot.gui.StatJoueurController;

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
public class JoueurFrontController implements Initializable {

    @FXML
    private TableView<Joueur> tvJoueur;
    @FXML
    private TableColumn<Joueur, Integer> colId;
    @FXML
    private TableColumn<Joueur, String> colNom;
    @FXML
    private TableColumn<Joueur, Date> colDate;
    @FXML
    private TableColumn<Joueur, String> colEquipe;
    @FXML
    private TableColumn<Joueur, String> colPrix;
    @FXML
    private TableColumn<Joueur, String> colValeur;
    @FXML
    private TableColumn<Joueur, String> colImage;
    @FXML
    private TableColumn<Joueur, String> editcol;

    String query = null;
    Connection cnx = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Joueur Joueur = null ;
    
    ObservableList<Joueur>  JoueurList = FXCollections.observableArrayList();

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
            Parent parent = FXMLLoader.load(getClass().getResource("Joueur.fxml"));
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
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    
    
    
    
    
    

    
    private void refreshTable(){

        try {

            JoueurList.clear();

            JoueurCRUD jc = new JoueurCRUD();
            ResultSet rs = jc.afficherJoueur();

            while (rs.next()) {
                Joueur j;
                j = new Joueur(rs.getString("nom_joueur"), rs.getDate("dateNaiss"), rs.getString("nom_equipe"), rs.getString("prix"), rs.getString("value"), rs.getString("image"));
                
                JoueurList.add(j);
                j.setId_joueur(rs.getInt("id_joueur"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        tvJoueur.setItems(JoueurList);
    }
 
    
    private void table() {
        cnx = MyConnection.getInstance().getCnx();

        refreshTable();

        colId.setCellValueFactory(new PropertyValueFactory<>("id_joueur"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom_joueur"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("dateNaiss"));
        colEquipe.setCellValueFactory(new PropertyValueFactory<>("nom_equipe"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colValeur.setCellValueFactory(new PropertyValueFactory<>("value"));
        colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        

        Callback<TableColumn<Joueur, String>, TableCell<Joueur, String>> cellFoctory = (TableColumn<Joueur, String> param) -> {
            final TableCell<Joueur, String> cell = new TableCell<Joueur, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        
                        FontAwesomeIconView viewIcon = new FontAwesomeIconView(FontAwesomeIcon.EYE);

                        
                        viewIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#009688;"
                        );
                        
                        
                        viewIcon.setOnMouseClicked((MouseEvent event) -> {

                                 Joueur = tvJoueur.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("StatJoueurFront.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                System.err.println(ex.getMessage());
                            }
                            
                            StatJoueurController StatJoueurController = loader.getController();
                            
                            
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();

                            });

                        HBox managebtn = new HBox(viewIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        
                        HBox.setMargin(viewIcon, new Insets(2, 2, 0, 3));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };

        editcol.setCellFactory(cellFoctory);
        tvJoueur.setItems(JoueurList);
        
        

    }
    
}
