/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.entities;

import java.util.Date;



/**
 *
 * @author HP
 */
public class Joueur {
    private int id_joueur;
    private String nom_joueur;
    private Date dateNaiss;
    private String nom_equipe;
    private String prix;
    private String value;
    private String image;

    public Joueur() {
    }

    public Joueur(int id_joueur, String nom_joueur, Date dateNaiss, String nom_equipe, String prix, String value, String image) {
        this.id_joueur = id_joueur;
        this.nom_joueur = nom_joueur;
        this.dateNaiss = dateNaiss;
        this.nom_equipe = nom_equipe;
        this.prix = prix;
        this.value = value;
        this.image = image;
    }

    public Joueur(String nom_joueur, Date dateNaiss, String nom_equipe, String prix, String value, String image) {
        this.nom_joueur = nom_joueur;
        this.dateNaiss = dateNaiss;
        this.nom_equipe = nom_equipe;
        this.prix = prix;
        this.value = value;
        this.image = image;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public String getNom_joueur() {
        return nom_joueur;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public String getPrix() {
        return prix;
    }

    public String getValue() {
        return value;
    }

    public String getImage() {
        return image;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Joueur{" + "id_joueur=" + id_joueur + ", nom_joueur=" + nom_joueur + ", dateNaiss=" + dateNaiss + ", nom_equipe=" + nom_equipe + ", prix=" + prix + ", value=" + value + ", image=" + image + '}';
    }

   
    

    
    
    

}