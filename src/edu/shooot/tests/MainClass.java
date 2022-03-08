/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.tests;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.shooot.entities.Match;
import edu.shooot.services.MatchCRUD;
import edu.shooot.services.StatistiqueCRUD;
import edu.shooot.utiles.MyConnection;
import edu.shooot.entities.*;
import edu.shooot.services.*;
import edu.shooot.tests.*;
import edu.shooot.utiles.*;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;



/**
 *
 * @author khali
 */
public class MainClass {
 public static void main (String[] args) {
     //MyConnection mc =  MyConnection();
//     Match M= new Match(1,2,"14/4/2022",11,22,33);
//     MatchCRUD mcd= new MatchCRUD();
      //Match M2 = new Match(4,11,"11/1/2002",17,4,15);
//    mcd.ajouterMatch2(M2);
    //MatchCRUD dbc=new MatchCRUD();
    //Match M3 =new  Match (10,15,"14/1/2012",11,21,14);
     //dbc.ajouterMatch2(M2);
//    //dbc.modifierMatch(53,13,13,"13/12/1312",14,14,14);
//   // MatchCRUD smd= new MatchCRUD();
//    //smd.SupprimerMatch(53);
   StatistiqueCRUD scd= new StatistiqueCRUD();
 Statistique S2 = new Statistique(21,"Journée 18 " , 3,"Joao Félix","Angel Correa",4,18,4);
 scd.ajouterStatistique2(S2);
//    //scd.modifierStatistique(9, 3, "SeifEddine Ben Karim", "Yassine Gharbi", 12, 5, 2);
   //StatistiqueCRUD ssd= new StatistiqueCRUD();
   // ssd.SupprimerStatistique("Journée 8 ");
     //dbc.modifierMatch(3,15,15,"13/12/1312",14,14,26);
     //MatchCRUD tid = new MatchCRUD();
//     Date dateNow = new Date();
//     int []tabDateInt=new int[5];
//     tabDateInt[0]=dateNow.getDate();
//     tabDateInt[1]=dateNow.getMonth();
//     tabDateInt[2]=dateNow.getYear();
//     tabDateInt[3]=dateNow.getHours();
//     tabDateInt[4]=dateNow.getMinutes();
//     long timeStampDateNow = dbc.calculTimeStamp(tabDateInt);
//     String date = "26/02/2022 15:50";
//     int []tabDate=new int[5];
//     tabDate=dbc.convertDateTotabInt(date);
//     long timeStamp = dbc.calculTimeStamp(tabDate);
//     long timeStampDuree = timeStamp - timeStampDateNow;
//     String msg = dbc.msgTimeLeft(timeStampDuree);
//     System.out.println(msg);
//     System.out.println(dateNow);
     
     
     
    
//List <Match> listMatch=mcd.afficherMatchs();
//        
//    
//    
//    
//    for ( Match Match : listMatch){
//        System.out.println(Match);
//    }
    List <Statistique> listStatistique=scd.afficherStatistique();
//    
//        
//    
//    
//    
    for (Statistique Statistique : listStatistique){
        System.out.println(Statistique);
//    }
//       
//
        scd.MoyenneBut(9);
//    
//             
//    }
//     
//            
//        
//       // LocalDate now = LocalDate.now();
//        
//       // LocalTime time = LocalTime.now();
//      //  LocalTime futureTime= time.plus(120, ChronoUnit.MINUTES);
//       // Duration duration = Duration.between(time, futureTime);
//       // LocalDate date = null;
//        //Period period2 = Period.between(date, now);
//       // System.out.println(duration.toHours()+ "Hours");
}
 }
 }