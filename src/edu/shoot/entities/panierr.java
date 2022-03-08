/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoot.entities;

/**
 *
 * @author houssemjrad
 */
public class panierr {
    int idp;
    String nom;
    String prenom;
    Float prix;

    @Override
    public String toString() {
        return "panierr{" + "idp=" + idp + ", nom=" + nom + ", prenom=" + prenom + ", prix=" + prix + '}';
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getIdp() {
        return idp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Float getPrix() {
        return prix;
    }

    public panierr() {
    }

    public panierr(int idp, String nom, String prenom, Float prix) {
        this.idp = idp;
        this.nom = nom;
        this.prenom = prenom;
        this.prix = prix;
    }

    public panierr(String nom, String prenom, Float prix) {
        this.nom = nom;
        this.prenom = prenom;
        this.prix = prix;
    }
    
}
