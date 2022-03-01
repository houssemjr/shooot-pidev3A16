/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.tests;

import edu.shooot.utils.MyConnection;
import edu.shooot.entities.Joueur;
import edu.shooot.entities.Equipe;
import edu.shooot.entities.StatJoueur;
import edu.shooot.services.JoueurCRUD;
import edu.shooot.services.EquipeCRUD;
import edu.shooot.services.StatJoueurCRUD;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author HP
 */
public class MainClass {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MyConnection cnx = new MyConnection();
        
        //ajout,suppression,modification,consultation des joueurs
        
          JoueurCRUD jcd = new JoueurCRUD();
          EquipeCRUD ecd = new EquipeCRUD();
          StatJoueurCRUD scd = new StatJoueurCRUD();
          java.util.Date AjoutDate = new java.util.Date("1987/06/24");
          java.sql.Date sqlDate = new java.sql.Date(AjoutDate.getTime());
          
          
//          Joueur j = new Joueur("Lionel Messiii", sqlDate, "Paris Saint-Germain", "9 milliard", "10 milliard", "https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwitter.com%2Flmdpsg%2Fstatus%2F1425204813810257922%3Flang%3Dfi&psig=AOvVaw37x3p_CJ5Oxb7l6dU-dO15&ust=1645228434440000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCOD1t9b3h_YCFQAAAAAdAAAAABAD");
//          jcd.ajouterJoueur(j);
//          jcd.supprimerJoueur(28);
//          jcd.modifierJoueur(15, "Paris Saint_Germain", "9999 million", "9999 milliard", "jjjj");
//          List <Joueur> listJoueur=jcd.consulterJoueur();
//          for(Joueur j:listJoueur){
//              System.out.println(j);
//          }
//          jcd.calculerAge();






//          Equipe e = new Equipe("pParis Saint_Germain", "France", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.stickpng.com%2Ffr%2Fimg%2Ficones-logos-emojis%2Ffootball%2Ffrance-premier-league%2Flogo-paris-st-germain&psig=AOvVaw3D7QFT_SB0sOBPoz5VT3ou&ust=1645229276980000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLirkej6h_YCFQAAAAAdAAAAABAD");
//          ecd.ajouterEquipe(e);
//          ecd.supprimerEquipe(3);
//          ecd.modifierEquipe(6, "yyy");
//          ObservableList <Equipe> listEquipe=ecd.consulterEquipe();
//          for(Equipe e:listEquipe){
//              System.out.println(e);
//          }





//
//          StatJoueur s = new StatJoueur("Youssef Msakni", "Coupe du monde", "80", "40");
//          scd.ajouterStatJoueur(s);
//          scd.consulterBut_Assist_total();
//          List <StatJoueur> listStat_joueur=scd.consulterStat_joueur();
//          for(StatJoueur s:listStat_joueur){
//              System.out.println(s);
//          }  




//        String dateNaiss ="1998/23/02";
//        String [] array = dateNaiss.split("/");
//        System.out.print(array[1]+"\n");
//        String dateNaisse = "1998/04/23";
//        String[] arrayString = dateNaisse.split("/");
//        int  arrayInt [] = {0,0,0};
//        for(int i=0 ; i<arrayString.length;i++){
//            arrayInt[i] = Integer.parseInt(arrayString[i]);
//        }
//        LocalDate date = LocalDate.of(arrayInt[0], arrayInt[1], arrayInt[2]);
//        LocalDate now = LocalDate.now();
//        Period period2 = Period.between(date, now);
//        System.out.println(+period2.getYears()+"ans "+" et "+period2.getMonths()+"mois");


     
    
    }
        
}
