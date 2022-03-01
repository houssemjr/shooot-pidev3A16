/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import shooot.entities.User;
import shooot.services.UserCRUD;


/**
 * FXML Controller class
 *
 * @author HP PC
 */
public class InscriptionUserController implements Initializable {

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
    }   
    
    @FXML
    private void saveUser(ActionEvent event) {
        String prenom=tfPrenom.getText();
        String nom=tfNom.getText();
        String userName=tfUn.getText();
        int num=Integer.parseInt(tfNum.getText());
        String email=tfEmail.getText();
        String pwd=tfPwd.getText();
        
        User U= new User(prenom,nom, num, email, userName, pwd);
        UserCRUD UCrud=new UserCRUD();
        UCrud.ajouterUser2(U);
                   
    }
    
    
    
}
