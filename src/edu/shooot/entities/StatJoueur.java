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
public class StatJoueur {
    private String nom_joueur;
    private String nom_comp;
    private int but_comp;
    private int assist_comp;
    private int but_total;
    private int assist_total;

    
    public StatJoueur() {
    }

    public StatJoueur(String nom_joueur, String nom_comp, int but_comp, int assist_comp, int but_total, int assist_total) {
        this.nom_joueur = nom_joueur;
        this.nom_comp = nom_comp;
        this.but_comp = but_comp;
        this.assist_comp = assist_comp;
        this.but_total = but_total;
        this.assist_total = assist_total;
    }
    
    public StatJoueur(String nom_joueur, String nom_comp, int but_comp, int assist_comp) {
        this.nom_joueur = nom_joueur;
        this.nom_comp = nom_comp;
        this.but_comp = but_comp;
        this.assist_comp = assist_comp;
    }
    
    public StatJoueur(int but_total, int assist_total) {
        this.but_total = but_total;
        this.assist_total = assist_total;
    }

    public String getNom_joueur() {
        return nom_joueur;
    }

    public String getNom_comp() {
        return nom_comp;
    }

    public int getBut_comp() {
        return but_comp;
    }

    public int getAssist_comp() {
        return assist_comp;
    }

    public int getBut_total() {
        return but_total;
    }

    public int getAssist_total() {
        return assist_total;
    }

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

    public void setNom_comp(String nom_comp) {
        this.nom_comp = nom_comp;
    }

    public void setBut_comp(int but_comp) {
        this.but_comp = but_comp;
    }

    public void setAssist_comp(int assist_comp) {
        this.assist_comp = assist_comp;
    }

    public void setBut_total(int but_total) {
        this.but_total = but_total;
    }

    public void setAssist_total(int assist_total) {
        this.assist_total = assist_total;
    }

    @Override
    public String toString() {
        return "StatJoueur{" + "nom_joueur=" + nom_joueur + ", nom_comp=" + nom_comp + ", but_comp=" + but_comp + ", assist_comp=" + assist_comp + ", but_total=" + but_total + ", assist_total=" + assist_total + '}';
    }

    

    
    
    
    
}
