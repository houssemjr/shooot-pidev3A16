/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shooot.entities.Admin;
import shooot.entities.Encrypte;
import shooot.tools.MyConnection;

/**
 *
 * @author HP PC
 */
public class AdminCRUD {
    String cryptedText2;
    Connection cnx2;
    
    public AdminCRUD(){
        cnx2=MyConnection.getInstance().getCnx();             
    }
    
    private String encrypte2(String text){
        Encrypte E=new Encrypte();
        
        cryptedText2=E.EcryptePwd(text);
        return cryptedText2;
    }
    
    public void ajouterAdmin(Admin A) {
        try {
            String requete = "INSERT INTO admin (nom,prenom,numero,email,pwd) VALUES (?,?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete);
            pst.setString(1, A.getNom());
            pst.setString(2, A.getPrenom());
            pst.setInt(3,A.getNum());
            pst.setString(4, A.getEmail());
            pst.setString(5, encrypte2(A.getPwd()));

            pst.executeUpdate();
            System.out.println("Admin ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @return
     */
    public List<Admin> affichageAdmin() {
        List<Admin> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM `admin`";
            Statement st = cnx2.createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Admin a = new Admin();
                
                a.setId(res.getInt(1));
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setNum(res.getInt("numero"));
                a.setEmail(res.getString("email"));
                
                
                
                myList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    return myList;
    }
    
    
        public ObservableList<Admin> affichageAdmin2() {
        ObservableList<Admin> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM `admin`";
            Statement st = cnx2.createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Admin a = new Admin();
                
                
                a.setNom(res.getString("nom"));
                a.setPrenom(res.getString("prenom"));
                a.setNum(res.getInt("numero"));
                a.setEmail(res.getString("email"));
                
                
                
                myList.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    return myList;
    }
}
