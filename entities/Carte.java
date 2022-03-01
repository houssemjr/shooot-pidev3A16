/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoootpi.entities;
import edu.shoootpi.services.CrudCarte;

/**
 *
 * @author houssemjrad
 */
public class Carte {
    int id;
    String nom;
    String prenom;
    int level;
    float prix;
    int id_premuim;
    public  Carte (){
        
    }

    public Carte( String nom, String prenom, int level, float prix, int id_premuim) {
        this.nom = nom;
        this.prenom = prenom;
        this.level = level;
        this.prix = prix;
        this.id_premuim = id_premuim;
    }

    public Carte(int id, String nom, String prenom, int level, float prix, int id_premuim) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.level = level;
        this.prix = prix;
        this.id_premuim = id_premuim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setId_premuim(int id_premuim) {
        this.id_premuim = id_premuim;
    }

    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getLevel() {
        return level;
    }

    public float getPrix() {
        return prix;
    }

    public int getId_premuim() {
        return id_premuim;
    }

    @Override
    public String toString() {
        return "Carte{" + "nom=" + nom + ", prenom=" + prenom + ", level=" + level + ", prix=" + prix + ", id_premuim=" + id_premuim + '}';
    }
    
   
            
    
}
