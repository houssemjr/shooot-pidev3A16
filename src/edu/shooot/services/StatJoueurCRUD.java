/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.services;

import edu.shooot.entities.StatJoueur;
import edu.shooot.utils.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class StatJoueurCRUD {
    
    Connection cnx;
   public StatJoueurCRUD() {
       cnx = MyConnection.getInstance().getCnx();
    }
    
   public void ajouterStatJoueur(StatJoueur s) {
        try {
            String requete = "INSERT INTO stat_joueur (nom_joueur, nom_comp, but_comp, assist_comp) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, s.getNom_joueur());
            pst.setString(2, s.getNom_comp());
            pst.setInt(3, s.getBut_comp());
            pst.setInt(4, s.getAssist_comp());
            pst.executeUpdate();
            System.out.println("Stat joueur ajouté!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<StatJoueur> consulterStatJoueur() {
        List<StatJoueur> myListe = new ArrayList<>();

        try {
            String requete5 = "SELECT * FROM stat_joueur ";
            Statement st = cnx.createStatement();
            st.executeQuery(requete5);
            ResultSet res = st.executeQuery(requete5);

            while (res.next()) {
                StatJoueur s = new StatJoueur();
                
                s.setNom_joueur(res.getString("nom_joueur"));
                s.setNom_comp(res.getString("nom_comp"));
                s.setBut_comp(res.getInt("but_comp"));
                s.setAssist_comp(res.getInt("assist_comp"));

                
                myListe.add(s);
            }
            System.out.println("Stat joueur consulté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myListe;

    }
    
    
   public void consulterBut_Assist_total() {
       

        try {
            String requete5 = "SELECT nom_joueur,SUM(but_comp) as but_total,SUM(assist_comp) as assist_total FROM stat_joueur group by nom_joueur";
            Statement st = cnx.createStatement();
            st.executeQuery(requete5);
            ResultSet res = st.executeQuery(requete5);
            while (res.next()) {
                StatJoueur s = new StatJoueur();
                
                s.setNom_joueur(res.getString("nom_joueur"));
                s.setBut_total(res.getInt("but_total"));
                s.setBut_total(res.getInt("assist_total"));
                
                System.out.println("nom_joueur = " + res.getString("nom_joueur") + " but_total = " + res.getInt("but_total") + " assist_total = " + res.getInt("assist_total"));
            }
            System.out.println("Stat joueur consulté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    
    
public ResultSet afficherStatJoueur(){
          try {
              String requete ="SELECT nom_joueur, nom_comp, but_comp, assist_comp FROM stat_joueur ";
              Statement st =cnx.createStatement();
              ResultSet rs= st.executeQuery(requete);
              return rs;
          } catch (SQLException ex) {
              System.err.println(ex.getMessage());
          }
          return null;
           }




}
    
    

