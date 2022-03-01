/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.services;

import edu.shooot.entities.Equipe;
import edu.shooot.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author HP
 */
public class EquipeCRUD {
    Connection cnx;
   public EquipeCRUD() {
       cnx = MyConnection.getInstance().getCnx();
    }
    
   public void ajouterEquipe(Equipe e) {
        try {
            String requete = "INSERT INTO equipe (nom_equipe, pays, logo) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, e.getNom_equipe());
            pst.setString(2, e.getPays());
            pst.setString(3, e.getLogo());
            
            pst.executeUpdate();
            System.out.println("Votre equipe est ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<Equipe> consulterEquipe() {
        ObservableList<Equipe> list = FXCollections.observableArrayList();

        try {
            String requete5 = "SELECT * FROM equipe ";
            Statement st = cnx.createStatement();
            st.executeQuery(requete5);
            ResultSet res = st.executeQuery(requete5);

            while (res.next()) {
                Equipe e = new Equipe();
                
                e.setId_equipe(res.getInt("id_equipe"));
                e.setNom_equipe(res.getString("nom_equipe"));
                e.setPays(res.getString("pays"));
                e.setLogo(res.getString("logo"));
                
                list.add(e);
            }
            System.out.println("Equipe consulté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;

    }
    
    public boolean supprimerEquipe(int id_equipe) {
        boolean eSup = true;
        try {
            String requete3 = "DELETE FROM equipe WHERE id_equipe = ? ";
            PreparedStatement pst = cnx.prepareStatement(requete3);

            pst.setInt(1, id_equipe);
            pst.executeUpdate();
            System.out.println("Equipe supprimé!");
        } catch (SQLException ex) {
            eSup = false;
            System.err.println(ex.getMessage());
        }
        return eSup;

    }
    public boolean modifierEquipe(int id_equipe, String logo) {
        boolean eModif = true;
        try {
            String requete4 = "UPDATE equipe SET logo= ? WHERE id_equipe= ? ";
            PreparedStatement pst = cnx.prepareStatement(requete4);
            
            pst.setString(1, logo);
            pst.setInt(2, id_equipe);

            pst.executeUpdate();
            System.out.println("Equipe modifié!");

        } catch (SQLException ex) {
            eModif = false;
            System.err.println(ex.getMessage());
        }
        return eModif;

    }
    
    public ResultSet afficherEquipe(){
          try {
              String requete ="SELECT * FROM equipe";
              Statement st =cnx.createStatement();
              ResultSet rs= st.executeQuery(requete);
              return rs;
          } catch (SQLException ex) {
              System.err.println(ex.getMessage());
          }
          return null;
           }
}
