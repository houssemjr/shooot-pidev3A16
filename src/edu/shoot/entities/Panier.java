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
public class Panier {
    
    int id_panier;
    int id;
    int quantite;
    float prix;
public Panier(){
    
}

    public Panier(int id, int quantite, float prix) {
        this.id = id;
        this.quantite = quantite;
        this.prix = prix;
    }

    public Panier(int id_panier, int id, int quantite, float prix) {
        this.id_panier = id_panier;
        this.id = id;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getId_panier() {
        return id_panier;
    }

    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", id=" + id + ", quantite=" + quantite + ", prix=" + prix + '}';
    }
    
    
    
}
