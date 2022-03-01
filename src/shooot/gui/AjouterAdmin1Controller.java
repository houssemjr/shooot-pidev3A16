/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shooot.entities.Admin;
import shooot.services.AdminCRUD;

/**
 * FXML Controller class
 *
 * @author HP PC
 */
public class AjouterAdmin1Controller implements Initializable {
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
    private Button btnAjouter;
    @FXML
    private TableView <Admin> tableAdmin;
    @FXML
    private TableColumn<Admin, String> colPrenom;
    @FXML
    private TableColumn<Admin, String> colNom;
    @FXML
    private TableColumn<Admin, Integer> colNum;
    @FXML
    private TableColumn<Admin, String> colEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showAdmins();
    }   
      @FXML
    private void saveAdmin(ActionEvent event) {
        String prenom=tfPrenom.getText();
        String nom=tfNom.getText();
        int num=Integer.parseInt(tfNum.getText());
        String email=tfEmail.getText();
        String pwd=tfPwd.getText();
        
        Admin A= new Admin(prenom,nom,num,email,pwd);
        AdminCRUD ACrud=new AdminCRUD();
        ACrud.ajouterAdmin(A);
        showAdmins();
           
    }
    
    
    public void showAdmins(){
        AdminCRUD A=new AdminCRUD();
        ObservableList<Admin> list =  A.affichageAdmin2();
     
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableAdmin.setItems(list);
    }
    
}
