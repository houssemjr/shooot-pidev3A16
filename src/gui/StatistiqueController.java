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
import edu.shooot.utiles.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author khali
 */
public class StatistiqueController implements Initializable {
     Connection cnx = null;
    @FXML
    private BarChart<String, Integer> barChart;
    
    @FXML
    private TableView<Statistique> fxtable2;
    @FXML
    private TableColumn<Statistique, Integer> fxId_match;
    @FXML
    private TableColumn<Statistique, Integer> fxBut;
    @FXML
    private TableColumn<Statistique, String> fxN_Buteur;
    @FXML
    private TableColumn<Statistique, String> fxN_Passeur;
    @FXML
    private TableColumn<Statistique, Integer> fxNb_Corner;
    @FXML
    private TableColumn<Statistique, Integer> fxNb_faute;
    @FXML
    private TableColumn<Statistique, Integer> fxNb_Carton;
    @FXML
    private TableColumn<Statistique, String> fxTitreMatch;
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           affiche();
           stat1();
    }    
    public void affiche() {
        
        StatistiqueCRUD S  =new StatistiqueCRUD();
        ObservableList<Statistique> list = S.afficherStatistique2();
        
        fxId_match.setCellValueFactory(new PropertyValueFactory<>("id_match"));
        fxTitreMatch.setCellValueFactory(new PropertyValueFactory<>("TitreMatch"));
        fxBut.setCellValueFactory(new PropertyValueFactory<>("But"));
        fxN_Buteur.setCellValueFactory(new PropertyValueFactory<>("N_Buteur"));
        fxN_Passeur.setCellValueFactory(new PropertyValueFactory<>("N_Passeur"));
        fxNb_Corner.setCellValueFactory(new PropertyValueFactory<>("Nb_Corner"));
        fxNb_faute.setCellValueFactory(new PropertyValueFactory<>("Nb_faute"));
        fxNb_Carton.setCellValueFactory(new PropertyValueFactory<>("Nb_Carton"));
        fxtable2.setItems(list);
    }
    void stat1() {
        cnx = MyConnection.getInstance().getCnx();
        
         String req = " SELECT TitreMatch,But from statistique ";
         
        barChart.setTitle("Statistique des matchs selon le nombre de but");
        
        
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        
        
        try {
            PreparedStatement ste = (PreparedStatement) cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                
            }
            barChart.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
