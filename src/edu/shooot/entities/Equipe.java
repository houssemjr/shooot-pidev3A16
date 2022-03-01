/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.entities;

/**
 *
 * @author HP
 */
public class Equipe {
    private int id_equipe;
    private String nom_equipe;
    private String pays;
    private String logo;
    
    public Equipe() {
    }

    public Equipe(int id_equipe, String nom_equipe, String pays, String logo) {
        this.id_equipe = id_equipe;
        this.nom_equipe = nom_equipe;
        this.pays = pays;
        this.logo = logo;
    }

    public Equipe(String nom_equipe, String pays, String logo) {
        this.nom_equipe = nom_equipe;
        this.pays = pays;
        this.logo = logo;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public String getNom_equipe() {
        return nom_equipe;
    }

    public String getPays() {
        return pays;
    }

    public String getLogo() {
        return logo;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public void setNom_equipe(String nom_equipe) {
        this.nom_equipe = nom_equipe;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id_equipe=" + id_equipe + ", nom_equipe=" + nom_equipe + ", pays=" + pays + ", logo=" + logo + '}';
    }

   
    
   
    
    
}
