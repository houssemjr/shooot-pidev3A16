/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.services;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.shooot.entities.Joueur;
import edu.shooot.utils.MyConnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class JoueurCRUD {
   Connection cnx;
   public JoueurCRUD() {
       cnx = MyConnection.getInstance().getCnx();
    }

           
    public void ajouterJoueur(Joueur j) {
        try {
            String requete = "INSERT INTO joueur (nom_joueur,dateNaiss,nom_equipe,prix,value,image) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, j.getNom_joueur());
            pst.setDate(2, (java.sql.Date) j.getDateNaiss());
            pst.setString(3, j.getNom_equipe());
            pst.setString(4, j.getPrix());
            pst.setString(5, j.getValue());
            pst.setString(6, j.getImage());
            
            pst.executeUpdate();
            System.out.println("Votre joueur est ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Joueur> consulterJoueur() {
        List<Joueur> myListe = new ArrayList<>();

        try {
            String requete5 = "SELECT * FROM joueur ";
            Statement st = cnx.createStatement();
            st.executeQuery(requete5);
            ResultSet res = st.executeQuery(requete5);

            while (res.next()) {
                Joueur j = new Joueur();
                
                j.setId_joueur(res.getInt("id_joueur"));
                j.setNom_joueur(res.getString("nom_joueur"));
                j.setDateNaiss(res.getDate("dateNaiss"));
                j.setNom_equipe(res.getString("nom_equipe"));
                j.setPrix(res.getString("prix"));
                j.setValue(res.getString("value"));
                j.setImage(res.getString("image"));
                
                myListe.add(j);
            }
            System.out.println("Joueur consulté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myListe;

    }
    
    public boolean supprimerJoueur(int id_joueur) {
        boolean jSup = true;
        try {
            String requete3 = "DELETE FROM joueur WHERE id_joueur = ? ";
            PreparedStatement pst = cnx.prepareStatement(requete3);

            pst.setInt(1, id_joueur);
            pst.executeUpdate();
            System.out.println("Joueur supprimé!");
        } catch (SQLException ex) {
            jSup = false;
            System.err.println(ex.getMessage());
        }
        return jSup;

    }
    
    public boolean modifierJoueur(int id_joueur, String nom_equipe, String prix, String value, String image) {
        boolean jModif = true;
        try {
            String requete4 = "UPDATE joueur SET nom_equipe= ? , prix = ?, value = ?, image = ? WHERE id_joueur= ? ";
            PreparedStatement pst = cnx.prepareStatement(requete4);
            
            pst.setString(1, nom_equipe);
            pst.setString(2, prix);
            pst.setString(3, value);
            pst.setString(4, image);
            pst.setInt(5, id_joueur);

            pst.executeUpdate();
            System.out.println("Joueur modifié!");

        } catch (SQLException ex) {
            jModif = false;
            System.err.println(ex.getMessage());
        }
        return jModif;

    }
    
     public ResultSet afficherJoueur(){
          try {
              String requete ="SELECT * FROM joueur";
              Statement st =cnx.createStatement();
              ResultSet rs= st.executeQuery(requete);
              return rs;
          } catch (SQLException ex) {
              System.err.println(ex.getMessage());
          }
          return null;
           }
     
//     public ResultSet afficherJoueur(String nom_equipe){
//          try {
//              String requete ="SELECT nom_equipe FROM equipe ";
//              Statement st =cnx.createStatement();
//              ResultSet rs= st.executeQuery(requete);
//              return rs;
//          } catch (SQLException ex) {
//              System.err.println(ex.getMessage());
//          }
//          return null;
//           }
    
    
//   public void calculerAge() {
//       
//     Date date = new Date();
//        try {
////            String requete5 = "SELECT nom_joueur,dateNaiss FROM joueur";
//            String requete5 = " SELECT nom_joueur,dateNaiss,getdate() as CurrentDate,\n" +
//"                datediff(MONTH,dateNaiss, getdate())/12 - \n" +
//"                case when month(dateNaiss)=month(getdate()) and day(dateNaiss) > day(getdate()) then 1 else 0 end\n" +
//"                AS age FROM joueur";
//            Statement st = cnx.createStatement();
//            st.executeQuery(requete5);
//            ResultSet res = st.executeQuery(requete5);
//            
//            while (res.next()) {
//                Joueur j = new Joueur();
//                
//                java.util.Date AjoutDate = new java.util.Date("1987/06/24");
//                java.sql.Date sqlDate = new java.sql.Date(AjoutDate.getTime());
//                
//                LocalDate today = LocalDate.now(); 
//                
//                
//                
//                Period p = Period.between(sqlDate, today);
//                
//               
//
//                Timestamp currentDate = new Timestamp(date.getTime());
//                int tt = j.getDateNaiss().getYear()- currentDate.getYear();
//                
//                
//                
//                
//                j.setNom_joueur(res.getString("nom_joueur"));
//                j.setDateNaiss(res.getDate("dateNaiss"));
//                
//                System.out.println(res.getString("nom_joueur") + " " + j.getge() + " ans");
//
//                
//
//        
//            }
//            System.out.println("Age joueur consulté!");
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//   }
    
    
    
//    public void calculerAge() {
//        List<Billet> listeBillets = new ArrayList<Billet>();
//        listeBillets = recup_Liste_Billets();
//
//        Date date = new Date();
//        Timestamp currentDate = new Timestamp(date.getTime());
//       
//       
//        //archivage aprés 7 jours de la création du billet
//
//        listeBillets.stream()
//                .filter(b -> b.getCreated_on().getDate() - currentDate.getDate() > 7)
//                .forEach((P) -> {
//                    String requete = null;
//                    try {
//                        requete = "UPDATE billet SET "
//                                + "archived = 1 ";
//
//                        Statement st = laConnexion.createStatement();
//                        st.executeUpdate(requete);
//
//                    } catch (SQLException e) {
//                        System.out.println("erreur d'archivage billet");
//                    }
//                });
//    }



   
   
   
//   public int getAge(int year, int month, int day) {
//       Date now = new Date();
//       int nowMonth = now.getMonth()+1;
//       int nowYear = now.getYear()+1900;
//       int result = nowYear - year;
//       
//       if (month > nowMonth) {
//           result--; 
//       }
//       else if (month == nowMonth) {
//           int nowDay = now.getDate();
//           
//           if (day > nowDay) {
//               result--; 
//           } 
//       }
//       return result; 
//   }

    
   
   
//   public static int getAge(date dateOfBirth) {
//       
//       calendar today = Calendar.getInstance();
//       Calendar birthDate = Calendar.getInstance();
//       
//       int age = 0;
//       
//       birthDate.setTime(dateOfBirth);
//       if (birthDate.after(today)) {
//           throw new IllegalArgumentException("Can't be born in the future");
//        }
//       
//       age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
//       // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year 
//       if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) || 
//               (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){ 
//           age--;
//       
//       // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age 
//   }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) && 
//           (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){ 
//       age--; 
//   } 
//       
//       return age;
//   }


}
