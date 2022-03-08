/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.shooot.services.MatchCRUD;
import edu.shooot.utiles.MyConnection;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import edu.shooot.entities.Match;
import edu.shooot.services.MatchCRUD;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.util.Collections.list;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author khali
 */
public class AffichageMatchController implements Initializable {

   
    @FXML
    private TableColumn<Match, Integer> fxId_match;
    @FXML
    private TableColumn<Match, String> fxdate;
    @FXML
    private TableColumn<Match, Integer> fxId_equipe1;
    @FXML
    private TableColumn<Match, Integer> fxId_equipe2;
    @FXML
    private TableColumn<Match, Integer> fxId_comp;
    @FXML
    private TableColumn<Match, Integer> fxId_stat;
    @FXML
    private TableColumn<Match, Integer> fxId_prono;
    @FXML
    private TableView<Match> table;
    @FXML
    private Button fxBS;
    @FXML
    private Button FXBU;
    @FXML
    private Button fxBD;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TextField t7;
    
   
    @FXML
    private Button bs1;
      String query = null;
    Connection cnx = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
   Match Match = null ;
   
    ObservableList<Match> MatchList = FXCollections.observableArrayList();
   
    
  
   
    /**
     * Initializes the controller class.
     */
    private final ObservableList<Match> list = FXCollections.observableArrayList();
    @FXML
    private Button fxBS1;
    @FXML
    private Button fxBS11;
    @FXML
    private TextField filteredField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           affiche();
    } 
     
   
    public void affiche() {
        
       
        MatchCRUD M  =new MatchCRUD();
        
        ObservableList<Match> list = M.afficherMatchs2();
        
        
        fxId_match.setCellValueFactory(new PropertyValueFactory<>("id_match"));
        fxdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        fxId_equipe1.setCellValueFactory(new PropertyValueFactory<>("id_equipe1"));
        fxId_equipe2.setCellValueFactory(new PropertyValueFactory<>("id_equipe2"));
        fxId_comp.setCellValueFactory(new PropertyValueFactory<>("id_comp"));
        fxId_stat.setCellValueFactory(new PropertyValueFactory<>("id_stat"));
        fxId_prono.setCellValueFactory(new PropertyValueFactory<>("id_prono"));
  
        table.setItems(list);
        
       // affiche();
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//       
//        alert.setTitle("Match");
//        alert.setHeaderText("Ajouter Match");
//        alert.setContentText("Votre Match a été ajouter avec succès!");
//        alert.showAndWait();
//
////            clear();
    }

    
 

    @FXML
    private void selectaff(ActionEvent event) {
        Match c = table.getSelectionModel().getSelectedItem();
        t1.setText(String.valueOf(c.getId_match()));
        t2.setText(c.getDate());
        t3.setText(String.valueOf(c.getId_equipe1()));
        t4.setText(String.valueOf(c.getId_equipe2()));
        t5.setText(String.valueOf(c.getId_comp()));
        t6.setText(String.valueOf(c.getId_stat()));
        t7.setText(String.valueOf(c.getId_prono()));
        

    }

    @FXML
    private void updateselection(ActionEvent event) {
        Match c = table.getSelectionModel().getSelectedItem();

                            
                                String id= t1.getText();
                                int id_match=Integer.parseInt(id);
                                String date = t2.getText();
                                String id_eq1= t3.getText();
                                int id_equipe1=Integer.parseInt(id_eq1);
                                String id_eq2=t4.getText();
                                int id_equipe2=Integer.parseInt(id_eq2);
                                String idcomp=t5.getText();
                                int id_comp=Integer.parseInt(idcomp);
                                String idstat=t6.getText();
                                int id_stat=Integer.parseInt(idstat);
                                String idp=t7.getText();
                                int id_prono=Integer.parseInt(idp);
                                MatchCRUD jc = new MatchCRUD();
                                Match b1= new Match();
                                jc.modifierMatch (id_match,id_equipe1, id_equipe2, date, id_comp, id_stat,id_prono);
                                affiche();
                                
//                                refreshTable();
                                

    }

    @FXML
    private void deleteseletion(ActionEvent event) {
           String id= t1.getText();
           int id_match=Integer.parseInt(id);
           MatchCRUD mc =new MatchCRUD();
           Match m = new Match();
           mc.SupprimerMatch(id_match);
//           refreshTable();
           
    }
    
    private void getAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Match.fxml"));
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
    private void Statistique (ActionEvent event) {
   
        try {
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
            
                        Stage primaryStage= new Stage();
                        FXMLLoader FL = new FXMLLoader(getClass().getResource("Statistique.fxml"));
                        Parent root = FL.load();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        } catch (IOException ex) {
                        System.err.println(ex.getMessage());
   
                        
    
                        
                        
      
     
                        

    }
    }

    @FXML
    private void StatCarton(ActionEvent event) {
           try {
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
            
                        Stage primaryStage= new Stage();
                        FXMLLoader FL = new FXMLLoader(getClass().getResource("StatCarton.fxml"));
                        Parent root = FL.load();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                                      
                        }
    }

    @FXML
    private void StatCorner(ActionEvent event) {
         try {
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
            
                        Stage primaryStage= new Stage();
                        FXMLLoader FL = new FXMLLoader(getClass().getResource("StatCorner.fxml"));
                        Parent root = FL.load();
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                                      
                        }
    }
    
    
    //
//    void clear() {
//        fxId_match.setText(null);
//        fxdate.setText(null);
//        fxId_equipe1.setText(null);
//        fxId_equipe2.setText(null);
//        fxId_comp.setText(null);
//        fxId_stat.setText(null);
//        fxId_prono.setText(null);
//        fxIM.setText(null);
//       
//    }
//    
//    
//    
//    private void refreshTable() {
//
//       
// try {
//
//            MatchList.clear();
//
//            query = "SELECT * FROM match";
//
//            preparedStatement = cnx.prepareStatement(query);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//              
//                Match m = new Match();
//                m.setId_match(rs.getInt(1));
//                m.setId_equipe1(rs.getInt(2));
//                m.setId_equipe2(rs.getInt(3));
//                m.setDate(rs.getString("date"));
//                m.setId_comp(rs.getInt(5));
//                m.setId_stat(rs.getInt(6));
//                m.setId_prono(rs.getInt(7));
//                m.setImage(rs.getString("Image"));
//                MatchList.add(m);
//                table.setItems(MatchList);
//
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//              
//    }
//
//private void close(MouseEvent event) {
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.close();
//    }
//
//    private void loadDate() {
//        cnx = MyConnection.getInstance().getCnx();
//
//   refreshTable();
//      
//        fxId_match.setCellValueFactory(new PropertyValueFactory<>("id_match"));
//        fxdate.setCellValueFactory(new PropertyValueFactory<>("date"));
//        fxId_equipe1.setCellValueFactory(new PropertyValueFactory<>("id_equipe1"));
//        fxId_equipe2.setCellValueFactory(new PropertyValueFactory<>("id_equipe2"));
//        fxId_comp.setCellValueFactory(new PropertyValueFactory<>("id_comp"));
//        fxId_stat.setCellValueFactory(new PropertyValueFactory<>("id_stat"));
//        fxId_prono.setCellValueFactory(new PropertyValueFactory<>("id_prono"));
//        fxdate.setCellValueFactory(new PropertyValueFactory<>("Image"));
//       
//
//    
//
//        Callback<TableColumn<Match, String>, TableCell<Match, String>> cellFoctory = (TableColumn<Match, String> param) -> {
//            final TableCell<Match, String> cell = new TableCell<Match, String>() {
//                @Override
//                public void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//                    //that cell created only on non-empty rows
//                    if (empty) {
//                        setGraphic(null);
//                        setText(null);
//
//                    } else {
//
//                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
//                        //FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
//                        //FontAwesomeIconView edittIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
//                        //FontAwesomeIconView viewIcon = new FontAwesomeIconView(FontAwesomeIcon.EYE);
//
//                        deleteIcon.setStyle(
//                                " -fx-cursor: hand ;"
//                                + "-glyph-size:28px;"
//                                + "-fx-fill:#000000;"
//                        );
//                   
//
//
//                      
//                      
//                        deleteIcon.setOnMouseClicked((MouseEvent event0)-> {
//                           
//                         
//
//                        });
//                      
//
//
//
//                        HBox managebtn = new HBox(deleteIcon);
//                        //managebtn.setStyle("-fx-alignment:center");
//                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
//                      // HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
//                        //HBox.setMargin(viewIcon, new Insets(2, 2, 0, 3));
//                        //HBox.setMargin(viewIcon, new Insets(2, 2, 0, 3));
//
//                        setGraphic(managebtn);
//
//                        setText(null);
//
//                    }
//                }
//
//            };
//
//            return cell;
//        };
//
//        editcol.setCellFactory(cellFoctory);
//        table.setItems(MatchList);


    @FXML
    private void ekteb(ActionEvent event) {
        list.setAll();
        int n = 0;

        try {

            String req = "SELECT * FROM match WHERE id_match= ? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, String.valueOf(filteredField.getText()));
            ResultSet res = pst.executeQuery();
            Match m = new Match();
            while (res.next()) {
                n = 2;

                 m.setId_match(res.getInt(1));
                m.setId_equipe1(res.getInt(2));
                m.setId_equipe2(res.getInt(3));
                m.setDate(res.getString("date"));
                m.setId_comp(res.getInt(5));
                m.setId_stat(res.getInt(6));
                m.setId_prono(res.getInt(7));
                list.add(m);

                table.setItems(list);
            }
        fxId_match.setCellValueFactory(new PropertyValueFactory<>("id_match"));
        fxdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        fxId_equipe1.setCellValueFactory(new PropertyValueFactory<>("id_equipe1"));
        fxId_equipe2.setCellValueFactory(new PropertyValueFactory<>("id_equipe2"));
        fxId_comp.setCellValueFactory(new PropertyValueFactory<>("id_comp"));
        fxId_stat.setCellValueFactory(new PropertyValueFactory<>("id_stat"));
        fxId_prono.setCellValueFactory(new PropertyValueFactory<>("id_prono"));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (n == 0) {
            Alert alt = new Alert(Alert.AlertType.ERROR, "il n'y a pas un match de ce ID", javafx.scene.control.ButtonType.OK);
            alt.showAndWait();
         affiche();
        }
    }

}
     
    
 
   

    

