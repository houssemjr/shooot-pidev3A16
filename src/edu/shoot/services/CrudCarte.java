/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoot.services;

import edu.shoot.entities.*;
import edu.shoot.entities.Carte;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author houssemjrad
 */
public class CrudCarte {
    
    
    Connection cnx;
   public CrudCarte() {
       cnx = MyConnection.getInstance().getCnx();
    }
   
    public void ajouterCarte(Carte c)
    {
        String req= "INSERT INTO `cartes`(`nom`, `prenom`, `level`, `prix`, `id_premuim`,`imgcarte`) VALUES (?,?,?,?,?,?)";
                
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(req);
            ps.setString(1,c.getNom());
            ps.setString(2,c.getPrenom());
            ps.setInt(3,c.getLevel());
            ps.setFloat(4,c.getPrix());
            ps.setInt(5,c.getId_premuim());
            ps.setString(6,c.getImgcarte());

            ps.executeUpdate();
            System.out.println("Carte crée avec succées");
            }catch (SQLException ex) {
                System.out.println("chay");
            System.err.println(ex.getMessage());
        }
                
        
    }
    public void modifiercarte(int id ,String nom , String prenom, int level, float prix, int id_premuim,String imgcarte)
    {
        String requete="UPDATE `cartes` SET `nom`=?,`prenom`=?,`level`=?,`prix`=?,`id_premuim`=?,`imgcarte`=?  WHERE id=?";
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setInt(3,level);
            ps.setFloat(4,prix);
            ps.setInt(5,id_premuim);            
            ps.setString(6, imgcarte);

            ps.setInt(7,id);
            ps.executeUpdate();
            System.out.println("Carte crée avec succées");
            
        }
        catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
        }
        
        
        
    }

    
    
      public List<Carte> affichercarte() {
        List<Carte> listeCarte = new ArrayList();
        try {
            String requete = "SELECT * FROM cartes  ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Carte c = new Carte();
               c.setId(res.getInt("id"));

               c.setNom(res.getString("nom"));
               c.setPrenom(res.getString("prenom"));
               c.setLevel(res.getInt("level"));
               c.setPrix(res.getFloat("prix"));
               c.setId_premuim(res.getInt("id_premuim"));
               c.setImgcarte(res.getString("imgcarte"));
              
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
          
          public void updatelev(int level)
          {
            String requete="UPDATE `cartes` SET `level`=? WHERE id=1";
             try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete);
             ps.setInt(1,level);
             //ps.setInt(2,id);
             ps.executeUpdate();
                         System.out.println("mise a jour fait  avec succées");



            
             }
            catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
        }
              
          }
          
          public int detectlevel( )
          {
              int lvl=-1;
              try {
              String requete ="SELECT 'level' FROM cartes WHERE 'id'=1";
              Statement dl=new MyConnection().getCnx().createStatement();
              
              ResultSet res=dl.executeQuery(requete);
              while (res.next())
              {
                  Carte ll=new Carte ();
                  ll.setLevel(res.getInt("level"));

                    lvl= ll.getLevel();
                     System.out.println(lvl);


                   return ll.getLevel();
}
              }
              catch(SQLException ex) {
            System.out.println("insertionaaa problem");
            System.out.println(ex.getMessage());
                  
              }

              return lvl ;
  
              
          }
              public ObservableList<Carte> getCarte() {
        ObservableList<Carte> list = FXCollections.observableArrayList();
 
       
        try {
             String requete = "SELECT * FROM cartes  ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Carte et = new Carte();
               // et.setId(res.getInt("id"));
                et.setNom(res.getString("nom"));
                et.setPrenom(res.getString("prenom"));
                et.setLevel(res.getInt("level"));
                et.setPrix(res.getFloat("prix"));
                et.setId_premuim(res.getInt("id_premuim"));
                
                list.add(et);
            }
        } catch (SQLException ex) {
System.out.println("ey mochkla2");
            System.out.println(ex.getMessage());        }
        return list;
 
    }
              
     
          
          public void updatelevel(int id) 
          {
              
              try {
                  String req="SELECT `nbbut` FROM `joueur` WHERE id_joueur=1";
                  Statement st = new MyConnection().getCnx().createStatement();

                ResultSet res = st.executeQuery(req);
                System.out.println("test");


                 while (res.next()) {

                     
                     joueur j = new joueur();

                     j.setNbbut(res.getInt("nbbut"));
                    // j.setId(res.getInt("id_joueur"));
                     int x=j.getNbbut();
                     System.out.print("------------------------");

                     

                     System.out.print(x);
                     
                    if (x==3){
                         CrudCarte lv = new CrudCarte();
                         CrudCarte ms= new CrudCarte();
                       int r= ms.detectlevel();
                       System.out.println(r);
                        
                         
                         lv.updatelev((x+r));
                        
                        } 
 
                        
                         
                         
                         
                     
                   
                     
                     
                 }
                

                  
                  
                  
                  
            }
              catch(SQLException ex) {
            System.out.println(" exception 2 problem");
            System.out.println(ex.getMessage());
                  
              }
              
              
          }
          public ObservableList<Carte> affichercarte1() {
        ObservableList<Carte> listeCarte = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM cartes  ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Carte c = new Carte();
               c.setId(res.getInt("id"));
               c.setNom(res.getString("nom"));
               c.setPrenom(res.getString("prenom"));
               c.setLevel(res.getInt("level"));
               c.setPrix(res.getFloat("prix"));
               c.setId_premuim(res.getInt("id_premuim"));
                c.setImgcarte(res.getString("imgcarte"));

              
               listeCarte.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("ey mochkla");
            System.out.println(ex.getMessage());
        }
        return listeCarte;
    }
          
          public void addtocart(){
            
              
          }
          
          public Carte getCarte(int idC) {
       
                      Carte c = new Carte();

        try {
            String requete = "SELECT * FROM cartes WHERE id=?  ";
            PreparedStatement prepare =new MyConnection().getCnx().prepareStatement(requete);
            prepare.setInt(1,idC);
            ResultSet res = prepare.executeQuery();
            while (res.next()) {
                c.setId(res.getInt("id"));
                
                c.setNom(res.getString("nom"));
                c.setPrenom(res.getString("prenom"));
                c.setLevel(res.getInt("level"));
                c.setPrix(res.getFloat("prix"));
                c.setId_premuim(res.getInt("id_premuim"));
                c.setImgcarte(res.getString("imgcarte"));
                
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudCarte.class.getName()).log(Level.SEVERE, null, ex);
        }
      return c;
        }
                public List<Carte> affichercarteprix(float prix ) {
        List<Carte> listeCarte = new ArrayList();
        try {
            String requete = "SELECT * FROM cartes WHERE prix=? ";
                            Carte c = new Carte();

            PreparedStatement st = new MyConnection().getCnx().prepareStatement(requete);
            st.setFloat(1,c.getPrix());
            ResultSet res = st.executeQuery();            
            

            while (res.next()) {
               c.setId(res.getInt("id"));

               c.setNom(res.getString("nom"));
               c.setPrenom(res.getString("prenom"));
               c.setLevel(res.getInt("level"));
               c.setPrix(res.getFloat("prix"));

               c.setId_premuim(res.getInt("id_premuim"));
               c.setImgcarte(res.getString("imgcarte"));
              
               listeCarte.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("ey mochkla prix");
            System.out.println(ex.getMessage());
        }
        return listeCarte;
    }
              
          
          
          
          
          public Carte recupJoueur(int id) {
        Carte c = new Carte();

        try {
            String requete = "SELECT * FROM cartes WHERE id=?";
            PreparedStatement prepare = cnx.prepareStatement(requete);
            prepare.setInt(1, id);

            ResultSet res = prepare.executeQuery();

            while (res.next()) {
                  c.setId(res.getInt("id"));
               c.setNom(res.getString("nom"));
               c.setPrenom(res.getString("prenom"));
               c.setLevel(res.getInt("level"));
               c.setPrix(res.getFloat("prix"));
               c.setId_premuim(res.getInt("id_premuim"));
               c.setImgcarte(res.getString("imgcarte"));
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

    }
          
          
    
