/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoootpi.Gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import edu.shoootpi.entities.Carte;
import edu.shoootpi.services.CrudCarte;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class AffichercarteController implements Initializable {

    @FXML
    private TableView<Carte> tv;
    @FXML
    private TableColumn<Carte, String> c2;
    @FXML
    private TableColumn<Carte, String> c3;
    @FXML
    private TableColumn<Carte, Integer> c4;
    @FXML
    private TableColumn<Carte, Float> c5;
    @FXML
    private TableColumn<Carte, Integer> c6;
    @FXML
    private TextField tt1;
    @FXML
    private TextField tt3;
    @FXML
    private TextField tt2;
    @FXML
    private TextField tt4;
    @FXML
    private TextField tt5;
    @FXML
    private TextField tt6;
    @FXML
    private TableColumn<Carte, Integer> c1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCartes();
        
    }   
    
    public void updatetable(){
        
        
    }
    
        public void showCartes(){
        CrudCarte U=new CrudCarte();
        ObservableList<Carte> list =  U.affichercarte1();
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        c2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        c3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        c4.setCellValueFactory(new PropertyValueFactory<>("level"));
        c5.setCellValueFactory(new PropertyValueFactory<>("prix"));
        c6.setCellValueFactory(new PropertyValueFactory<>("id_premuim"));
        tv.setItems(list);
    
}
   private void tablehandleButtonAction(MouseEvent event) {
        Carte c = tv.getSelectionModel().getSelectedItem();
        
        tt2.setText(c.getNom());
        tt3.setText(c.getPrenom());
        tt4.setText(String.valueOf(c.getLevel()));
        tt5.setText(String.valueOf(c.getPrix()));
        tt6.setText(String.valueOf(c.getLevel()));

        
    }
        private void setCellValueFromTableToTextField() {
        tv.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Carte b = tv.getItems().get(tv.getSelectionModel().getSelectedIndex());
                tt2.setText(b.getNom());
                tt3.setText(b.getPrenom());
                
              tt1.setText(String.valueOf(b.getId()));

            }

        });
    }

      private int getIdCarte() {
        tv.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                int ids = tv.getSelectionModel().getSelectedItem().getId();

            }
        });
        return tv.getSelectionModel().getSelectedItem().getId();
    }
      
      

   

    @FXML
    private void getcarte(ActionEvent event) {
        Carte c = tv.getSelectionModel().getSelectedItem();
        tt1.setText(String.valueOf(c.getId()));
        tt2.setText(c.getNom());
        tt3.setText(c.getPrenom());
        tt4.setText(String.valueOf(c.getLevel()));
        tt5.setText(String.valueOf(c.getPrix()));
        tt6.setText(String.valueOf(c.getId_premuim()));
    }

    @FXML
    private void updatecarte(ActionEvent event) {
    
    
        Carte c = tv.getSelectionModel().getSelectedItem();

                            
                                String idd= tt1.getText();
                                int id=Integer.parseInt(idd);
                                String nom = tt2.getText().toString();
                                String prenom = tt3.getText().toString();
                                String Lv=tt4.getText();
                                int level=Integer.parseInt(Lv);
                                String pr=tt5.getText();
                                float prix=Float.parseFloat(pr);
                                String idp=tt6.getText();
                                int id_premuim =Integer.parseInt(idp);
                                
                                CrudCarte jc = new CrudCarte();
                                Carte b1= new Carte();
                                jc.modifiercarte(id,nom, prenom, level, prix, id_premuim);
                                
                                showCartes();
        
                               

                            
                        
                            
                        


    }

    @FXML
    private void deletecarte(ActionEvent event) {
                                        String idd= tt1.getText();
                                int id=Integer.parseInt(idd);
                                CrudCarte abb = new CrudCarte();
                                abb.supprimercarte(id);
                                showCartes();

    }

    @FXML
    private void dialogscroll(javafx.scene.input.MouseEvent event) throws IOException {
    

        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("Dialog.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            
//                            ReservaController addReservController = loader.getController();
//                            addReservController. insertRecord();
                                                     
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();

        
                
               
        
    }
}
