/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.shooot.entities.Statistique;
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
public class StatCartonController implements Initializable {
Connection cnx = null;
    
 
   
    @FXML
    private TableColumn<Statistique, Integer> fxNb_Carton;
    @FXML
    private TableColumn<Statistique, String> fxTitreMatch;
    @FXML
    private BarChart<String, Integer> BarChart2;
    @FXML
    private TableView<Statistique> fxtable22;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        affiche();
        stat2();
    }  
    public void affiche() {
        
        StatistiqueCRUD S  =new StatistiqueCRUD();
        ObservableList<Statistique> list = S.afficherStatistique2();
        
      
        fxTitreMatch.setCellValueFactory(new PropertyValueFactory<>("TitreMatch"));
        fxNb_Carton.setCellValueFactory(new PropertyValueFactory<>("Nb_Carton"));
        fxtable22.setItems(list);
    }
    void stat2() {
        cnx = MyConnection.getInstance().getCnx();
        
            String req = " SELECT TitreMatch,Nb_Carton from statistique ";
         
        BarChart2.setTitle("Statistique des matchs selon le nombre de Carton");
        
        
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        
        
        try {
            PreparedStatement ste = (PreparedStatement) cnx.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                
            }
            BarChart2.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(StatCartonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
