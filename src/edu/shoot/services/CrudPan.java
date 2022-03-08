/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoot.services;

import edu.shoot.entities.Carte;
import edu.shoot.entities.pan;
import edu.shoot.entities.panierr;
import edu.shoot.utiles.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssemjrad
 */
public class CrudPan {
      public static void main(String[] args) {
        
    }
    
    public float calcultotal(pan panier){
        List<Carte> produits = new ArrayList();
        produits = panier.getProduits();
        
        float total = 0;
        
        for (Iterator<Carte> iterator = produits.iterator(); iterator.hasNext();) {
            Carte next = iterator.next();
            total += next.getPrix();
        }
        
        return total;
    }
    
    public void ajouterpan(panierr p)
    {
          try {
              String req="INSERT INTO `panierr`(`idp`, `nom`, `prenom`,`prix`) VALUES (?,?,?,?)";
              PreparedStatement ps= new MyConnection().getCnx().prepareStatement(req);
              ps.setInt(1,p.getIdp());
              ps.setString(2,p.getNom());
               ps.setString(2,p.getPrenom());

              ps.setFloat(3,p.getPrix());
              ps.executeUpdate();
              System.out.println("panier crée avec succées");
          } catch (SQLException ex) {
              Logger.getLogger(CrudPan.class.getName()).log(Level.SEVERE, null, ex);
          }
            

        
        
    }
    public void facturefrompanier(pan panier){
        
    }

    public void ajoutpan(panierr s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
