/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoot.tests;

import edu.shoot.entities.Carte;
import edu.shoot.entities.Panier;
import edu.shoot.entities.panierr;

import edu.shoot.services.CrudCarte;
import edu.shoot.services.CrudPan;
import edu.shoot.services.Crudpanier;
import edu.shoot.utiles.MyConnection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houssemjrad
 */
public class Shoot10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            MyConnection mc = new MyConnection();
            Carte car= new Carte ("khalill","barrak",12,14f,41);
            CrudCarte aj = new CrudCarte();
            
            //aj.ajouterCarte(car);
            
            Carte car2= new Carte ("test","test",12,12f,30);
            
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
panierr s = new panierr ("houssem","jrad",12f);
panierr d=new panierr();
Crudpanier ll = new Crudpanier();
ll.ajouterPanier(s);
float x= ll.calcultotal(d);
System.out.println(x);
        } catch (SQLException ex) {
            Logger.getLogger(Shoot10.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}
