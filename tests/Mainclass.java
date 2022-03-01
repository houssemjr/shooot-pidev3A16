package edu.shoootpi.tests;
import java.util.Date; 
import edu.shoootpi.utils.MyConnection;
import edu.shoootpi.entities.*;
import edu.shoootpi.entities.abonnement;
import edu.shoootpi.services.CrudCarte;
import edu.shoootpi.services.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.util.concurrent.TimeUnit;
import java.util.Locale;
import java.text.SimpleDateFormat; 
import java.time.Duration;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.awt.geom.*;
import java.awt.*;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 

/**
 *
 */
public class Mainclass {
 public static void main (String[] args){
     MyConnection mc = new MyConnection();
     Carte car= new Carte ("khalill","barrak",12,14f,41);
CrudCarte aj = new CrudCarte();

 //aj.ajouterCarte(car);

     Carte car2= new Carte ("yosraa","sahnounaaa",12,12f,30);
     
  //   aj.modifiercarte(3,"maissa","rezgui",12,12f,30);
     
     List<Carte> listecart=aj.affichercarte();
     for (Carte c:listecart ){
         System.out.println(c);
     }
//aj.supprimercarte(3);


Crudpanier ap = new Crudpanier();
Panier pan = new Panier(2,30,12);
//ap.ajouterPanier(pan);
//ap.prixtotalpanier();
aj.updatelevel(1);
List<Carte> listecart2=aj.affichercarte();
     for (Carte c:listecart2 ){
         System.out.println(c);
     }



 
 }
 
 
 

    
 


    




}