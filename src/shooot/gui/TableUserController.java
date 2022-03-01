/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.gui;


import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shooot.entities.User;
import shooot.services.UserCRUD;

/**
 * FXML Controller class
 *
 * @author HP PC
 */
public class TableUserController implements Initializable {

    @FXML
    private TableColumn<User, String> colPrenom;
    @FXML
    private TableColumn<User, String> colNom;
    @FXML
    private TableColumn<User, String> colUn;
    @FXML
    private TableColumn<User, Integer> colNum;
    @FXML
    private TableColumn<User, String> colEmail;
    @FXML
    private TableView<User> tableUser;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPwd;
    @FXML
    private TextField tfPwd2;
    @FXML
    private TextField tfUn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showUsers();
    }    
    
    

    
    public void showUsers(){
        UserCRUD U=new UserCRUD();
        ObservableList<User> list =  U.affichageUsers2();
     
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colUn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableUser.setItems(list);
    }
    
       

    @FXML
    private User getData(ActionEvent event) {
           User U = tableUser.getSelectionModel().getSelectedItem();
        
        tfNom.setText(U.getNom());
        tfPrenom.setText(U.getPrenom());
        tfUn.setText(U.getUserName());
        tfNum.setText(String.valueOf(U.getNum()));
        tfEmail.setText(U.getEmail());
        return U;
    }
     
 

    @FXML
    private void UpdateSelection(ActionEvent event) {
         String prenom=tfPrenom.getText();
        String nom=tfNom.getText();
        String userName=tfUn.getText();
        int num=Integer.parseInt(tfNum.getText());
        String email=tfEmail.getText();
        String pwd=tfPwd.getText();
        
        UserCRUD U=new UserCRUD();
        U.updateUser(userName, nom, prenom, num, email, pwd);
        showUsers();
    }
       
    @FXML
    private void DeleteSelection(ActionEvent event){
        User U1=getData(event);
        UserCRUD uc=new UserCRUD();
        
        uc.supprimerUser(U1.getUserName());
        showUsers();
        
    }
}
