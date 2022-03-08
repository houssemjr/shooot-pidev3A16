/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.entities;

/**
 *
 * @author khali
 */
public class Statistique {
   
    private int id_match;
    private String TitreMatch;
    private int But;
    private String N_Buteur;
    private String N_Passeur;
    private int Nb_Corner;
    private int Nb_faute;
    private int Nb_Carton;
    

    public  Statistique() {
    }

    public Statistique (int id_match, String TitreMatch, int But, String N_Buteur, String N_Passeur, int Nb_Corner, int Nb_faute, int Nb_Carton) {
        
        this.id_match = id_match;
        this.TitreMatch = TitreMatch;
        this.But = But;
        this.N_Buteur = N_Buteur;
        this.N_Passeur = N_Passeur;
        this.Nb_Corner = Nb_Corner;
        this.Nb_faute = Nb_faute;
        this.Nb_Carton= Nb_Carton;
    }

    public Statistique(String TitreMatch, int But, String N_Buteur, String N_Passeur, int Nb_Corner, int Nb_faute, int Nb_Carton) {
        this.TitreMatch = TitreMatch;
        this.But = But;
        this.N_Buteur = N_Buteur;
        this.N_Passeur = N_Passeur;
        this.Nb_Corner = Nb_Corner;
        this.Nb_faute = Nb_faute;
        this.Nb_Carton = Nb_Carton;
    }

    public int getid_match() {
        return id_match;
    }
    public void setid_match(int id_match) {
        this.id_match = id_match;
    }
     public String getTitreMatch() {
        return TitreMatch;
    }

    public void setTitreMatch(String TitreMatch) {
        this.TitreMatch = TitreMatch;
    }
    
    public int getBut() {
        return But;
    }

    public void setBut(int But) {
        this.But = But;
    }

    public String getN_Buteur() {
        return N_Buteur;
    }

    public void setN_Buteur(String N_Buteur) {
        this.N_Buteur = N_Buteur;
    }

    public String getN_Passeur() {
        return N_Passeur;
    }

    public void setN_Passeur(String N_Passeur) {
        this.N_Passeur = N_Passeur;
    }

    public int getNb_Corner() {
        return Nb_Corner;
    }

    public void setNb_Corner(int Nb_Corner) {
        this.Nb_Corner = Nb_Corner;
    }

    public int getNb_faute() {
        return Nb_faute;
    }

    public void setNb_faute(int Nb_faute) {
        this.Nb_faute = Nb_faute;
    }

    public int getNb_Carton() {
        return Nb_Carton;
    }

    public void setNb_Carton(int Nb_Carton) {
        this.Nb_Carton = Nb_Carton;
    }

    @Override
    public String toString() {
        return "Statistique{" + "id_match=" + id_match +", TitreMatch=" + TitreMatch + ", But=" + But + ", N_Buteur=" + N_Buteur + ", N_Passeur=" + N_Passeur + ", Nb_Corner=" + Nb_Corner + ", Nb_faute=" + Nb_faute + ", Nb_Carton=" + Nb_Carton + '}';
    }

   
    
}
