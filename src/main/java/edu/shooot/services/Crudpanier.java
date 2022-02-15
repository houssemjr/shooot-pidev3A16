/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.services;
import edu.shooot.entities.*;
import edu.shooot.services.*;
import edu.shooot.tests.*;
import edu.shooot.utils.*;
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


/**
 *
 * @author houssemjrad
 */
public class Crudpanier {
    
    public void ajouterPanier(Panier p)
    {
        String req="INSERT INTO `panier`(`id`, `quantité`, `prix`) VALUES (?,?,?)";
          try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(req);
            ps.setInt(1,p.getId());
            ps.setInt(2,p.getQuantite());
            ps.setFloat(3,p.getPrix());
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
            String requete = "SELECT quantite,prix FROM panier WHERE id=2";
            
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
    
}
