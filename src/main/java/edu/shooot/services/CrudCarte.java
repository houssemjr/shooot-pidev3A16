package edu.shooot.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.shooot.entities.Carte;
import edu.shooot.utils.MyConnection;
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



/**
 *
 * @author houssemjrad
 */
public class CrudCarte {
    
    
    public void ajouterCarte(Carte c)
    {
        String req= "INSERT INTO `cartes`(`nom`, `prenom`, `level`, `prix`, `id_premuim`) VALUES (?,?,?,?,?)";
                
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(req);
            ps.setString(1,c.getNom());
            ps.setString(2,c.getPrenom());
            ps.setInt(3,c.getLevel());
            ps.setFloat(4,c.getPrix());
            ps.setInt(5,c.getId_premuim());
            ps.executeUpdate();
            System.out.println("Carte crée avec succées");
            }catch (SQLException ex) {
                System.out.println("chay");
            System.err.println(ex.getMessage());
        }
                
        
    }
    public void modifiercarte(int id ,String nom , String prenom, int level, float prix, int id_premuim)
    {
        String requete="UPDATE `cartes` SET `nom`=?,`prenom`=?,`level`=?,`prix`=?,`id_premuim`=? WHERE id=?";
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setInt(3,level);
            ps.setFloat(4,prix);
            ps.setInt(5,id_premuim);
            ps.setInt(6,id);
            ps.executeUpdate();
            System.out.println("Carte crée avec succées");
            
        }
        catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
        }
        
        
        
    }
  /*  public void modifiercarte(int id ,String nom , String prenom, int level, float prix, int id_premuim)
    {
        String requete="UPDATE `cartes` SET `nom`=?,`prenom`=?,`level`=?,`prix`=?,`id_premuim`=? WHERE id=?";
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setInt(3,level);
            ps.setFloat(4,prix);
            ps.setInt(5,id_premuim);
            ps.setInt(6,id);
            ps.executeUpdate();
            System.out.println("Carte crée avec succées");
            
        }
        catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
        }}*/
          public List<Carte> affichercarte() {
        List<Carte> listeCarte = new ArrayList();
        try {
            String requete = "SELECT * FROM cartes  ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Carte c = new Carte();

               c.setNom(res.getString("nom"));
               c.setPrenom(res.getString("prenom"));
               c.setLevel(res.getInt("level"));
               c.setPrix(res.getFloat("prix"));
               c.setId_premuim(res.getInt("id_premuim"));
              
               listeCarte.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("ey mochkla");
            System.out.println(ex.getMessage());
        }
        return listeCarte;
    }
          public void supprimercarte(int id) {
        
        try {
            String requete = "DELETE FROM cartes WHERE id = ?";
            PreparedStatement prepare =  new MyConnection().getCnx().prepareStatement(requete);
            prepare.setInt(1, id);
            int nbEnregSup = prepare.executeUpdate();
            System.out.println("suppression");
            
        } catch (SQLException e) {
            System.out.println("Aucune suppression");
            
        }
        
    }
          
          
          
    }
