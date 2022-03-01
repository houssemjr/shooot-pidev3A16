/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoootpi.entities;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
/**
 *
 * @author houssemjrad
 */
public class abonnement {
    int id_abonnement;
    String Date_debut;
    String Date_fin;
    int id_client;
    float montan_payer;
    String type_abonnement;
    
    public abonnement() {
    
}

    public abonnement(int id_abonnement, String Date_debut, String Date_fin, int id_client, float montan_payer, String type_abonnement) {
        this.id_abonnement = id_abonnement;
        this.Date_debut = Date_debut;
        this.Date_fin = Date_fin;
        this.id_client = id_client;
        this.montan_payer = montan_payer;
        this.type_abonnement = type_abonnement;
        
        
    }

    public int getId_abonnement() {
        return id_abonnement;
    }

    public String getDate_debut() {
        return Date_debut;
    }

    public String getDate_fin() {
        return Date_fin;
    }

    public int getId_client() {
        return id_client;
    }

    public float getMontan_payer() {
        return montan_payer;
    }

    public String getType_abonnement() {
        return type_abonnement;
    }

    public void setId_abonnement(int id_abonnement) {
        this.id_abonnement = id_abonnement;
    }

    public void setDate_debut(String Date_debut) {
        this.Date_debut = Date_debut;
    }

    public void setDate_fin(String Date_fin) {
        this.Date_fin = Date_fin;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setMontan_payer(float montan_payer) {
        this.montan_payer = montan_payer;
    }

    public void setType_abonnement(String type_abonnement) {
        this.type_abonnement = type_abonnement;
    }

    @Override
    public String toString() {
        return "abonnement{" + "id_abonnement=" + id_abonnement + ", Date_debut=" + Date_debut + ", Date_fin=" + Date_fin + ", id_client=" + id_client + ", montan_payer=" + montan_payer + ", type_abonnement=" + type_abonnement + '}';
    }
    
    
}
