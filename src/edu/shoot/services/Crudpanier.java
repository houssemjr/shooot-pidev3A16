/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoot.services;


/**
 *
 * @author houssemjrad
 */
import edu.shoot.entities.*;
import edu.shoot.tests.*;
import edu.shoot.utiles.*;
import edu.shoot.utiles.MyConnection;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.shoot.entities.pan;


/**
 *
 * @author houssemjrad
 */
public class Crudpanier {
    
    public void ajouterPanier(panierr p)
    {
        String req="INSERT INTO `panierr`(`idp`, `nom`, `prenom`,`prix`) VALUES (?,?,?,?)";
          try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(req);
            ps.setInt(1,p.getIdp());
            ps.setString(2,p.getNom());
            ps.setString(3,p.getPrenom());
            ps.setFloat(4,p.getPrix());
            ps.executeUpdate();
            System.out.println("panier crée avec succées");

    }
          catch (SQLException ex){
               System.out.println("chay");
            System.err.println(ex.getMessage());

           }
              
          }
    
   public float prixtotalpanier() 
   {
     float total_a_payer=0;    
        // List<Panier> list = new ArrayList<>();

        try {
            String requete = "SELECT quantite,prix FROM panier WHERE id=?";
            
           Statement st = new MyConnection().getCnx().createStatement();
            ResultSet res = st.executeQuery(requete);
                 



                      while (res.next()) {
                total_a_payer +=res.getInt("quantite")*res.getFloat("prix") ;
                System.out.println("le total est ");
                

                            
              
                        } 
              System.out.println(total_a_payer);

              return total_a_payer ;
            

        } catch (SQLException ex) {
            System.out.println("makhedmetch");
                
                
            System.err.println(ex.getMessage());
        }
        
return total_a_payer ; 
      
    }
   
   
public ObservableList<panierr> afficherpanier1() {
        ObservableList<panierr> listePanier = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM panierr  ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                panierr c = new panierr();
                 c.setIdp(res.getInt("idp"));

               c.setNom(res.getString("nom"));
               c.setPrenom(res.getString("prenom"));
               c.setPrix(res.getFloat("prix"));
              
               listePanier.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("ey mochkla");
            System.out.println(ex.getMessage());
        }
        return listePanier;
    }








    public float calcultotal(panierr panier) throws SQLException{
       
        
            float total = 0;
            List<panierr> listePanier = new ArrayList();
            String requete = "SELECT * FROM panierr  ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                panierr c = new panierr();
                c.setIdp(res.getInt("idp"));
                
                c.setNom(res.getString("nom"));
                c.setPrenom(res.getString("prenom"));
                c.setPrix(res.getFloat("prix"));
                float x=c.getPrix();
                total=total+x;
                
                System.out.println(total);
                
                
                listePanier.add(c);
                
            }
            
                            return total;

        }
    
     public void supprimerPanier( ) {
        
        try {
            String requete = "DELETE FROM panierr WHERE prix>0 ";
            PreparedStatement prepare =  new MyConnection().getCnx().prepareStatement(requete);
            int nbEnregSup = prepare.executeUpdate();
            System.out.println("suppression");
            
        } catch (SQLException e) {
            System.out.println("Aucune suppression");
            
        }
        
    }
     
      public void suppidpan(int id) {
        
        try {
            String requete = "DELETE FROM panierr WHERE idp= ?";
            PreparedStatement prepare =  new MyConnection().getCnx().prepareStatement(requete);
            prepare.setInt(1, id);
            int nbEnregSup = prepare.executeUpdate();
            System.out.println("suppression");
            
        } catch (SQLException e) {
            System.out.println("Aucune suppression");
            
        }
        
    }

    }

    
    

