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
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author khali
 */
public class StatAllController implements Initializable {

    @FXML
    private TableColumn<Statistique, Integer> fxId_match;
    @FXML
    private TableColumn<Statistique, String> fxTitreMatch;
    @FXML
    private TableColumn<Statistique, Integer> fxBut;
    @FXML
    private TableColumn<Statistique, String> fxButeur;
    @FXML
    private TableColumn<Statistique, String> fxPasseur;
    @FXML
    private TableColumn<Statistique, Integer> fxCorner;
    @FXML
    private TableColumn<Statistique, Integer> fxFaute;
    @FXML
    private TableColumn<Statistique, Integer> fxCarton;
    @FXML
    private TextField t11;
    @FXML
    private TextField t22;
    @FXML
    private TextField t33;
    @FXML
    private TextField t44;
    @FXML
    private TextField t55;
    @FXML
    private TextField t66;
    @FXML
    private TextField t77;
    @FXML
    private Button bs;
    @FXML
    private Button BU;
    @FXML
    private Button BD;
    @FXML
    private TableView<Statistique> table1;
    String query = null;
    Connection cnx = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
   Statistique Statistique = null ;
   
    ObservableList<Statistique> StatistiqueList = FXCollections.observableArrayList();
     private final ObservableList<Statistique> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           affiche();
    } 
      public void affiche() {
        
       
        StatistiqueCRUD S  =new StatistiqueCRUD();
        
        ObservableList<Statistique> list = S.afficherStatistique2();
        
        
        fxId_match.setCellValueFactory(new PropertyValueFactory<>("id_match"));
        fxTitreMatch.setCellValueFactory(new PropertyValueFactory<>("TitreMatch"));
        fxBut.setCellValueFactory(new PropertyValueFactory<>("But"));
        fxButeur.setCellValueFactory(new PropertyValueFactory<>("N_Buteur"));
        fxPasseur.setCellValueFactory(new PropertyValueFactory<>("N_Passeur"));
        fxCorner.setCellValueFactory(new PropertyValueFactory<>("Nb_Corner"));
        fxFaute.setCellValueFactory(new PropertyValueFactory<>("Nb_faute"));
        fxCarton.setCellValueFactory(new PropertyValueFactory<>("Nb_Carton"));
  
        table1.setItems(list);
        
    
}

    @FXML
    private void selectaff(ActionEvent event) {
        Statistique c = table1.getSelectionModel().getSelectedItem();
       
        t11.setText(c.getTitreMatch());
        t22.setText(String.valueOf(c.getBut()));
        t33.setText(c.getN_Buteur());
        t44.setText(c.getN_Passeur());
        t55.setText(String.valueOf(c.getNb_Corner()));
        t66.setText(String.valueOf(c.getNb_faute()));
        t77.setText(String.valueOf(c.getNb_Carton()));
    }

    @FXML
    private void updateselection(ActionEvent event) {
         Statistique = table1.getSelectionModel().getSelectedItem();

                                StatistiqueCRUD jc = new StatistiqueCRUD();
                                Statistique BU= new Statistique();
                                
                                String TitreMatch= t11.getText();
                                String B = t22.getText();
                                int But=Integer.parseInt(B);
                                String N_Buteur= t33.getText();
                                String N_Passeur= t44.getText();
                                String NbCo=t55.getText();
                                int Nb_Corner=Integer.parseInt(NbCo);
                                String NbF=t66.getText();
                                int Nb_faute=Integer.parseInt(NbF);
                                String NbCa=t77.getText();
                                int Nb_Carton=Integer.parseInt(NbCa);
                               
                                
                                jc.modifierStatistique(Statistique.getid_match(), TitreMatch,But, N_Buteur, N_Passeur, Nb_Corner, Nb_faute,Nb_Carton);
                                affiche();
    }

    @FXML
    private void deleteselection(ActionEvent event) {
        String TitreMatch= t11.getText();
           
           StatistiqueCRUD sc =new StatistiqueCRUD();
           Statistique s= new Statistique();
           sc.SupprimerStatistique(TitreMatch);
//           refreshTable();
    }
}
