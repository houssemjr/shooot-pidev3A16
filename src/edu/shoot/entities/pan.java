/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoot.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author houssemjrad
 */
public class pan {
    private int id_panier;
    private int id_client;
    
    private List<Carte> produits;

    public pan() {
        this.produits = new ArrayList();
    }

    public pan(int id_panier, int id_client) {
        this.id_panier = id_panier;
        this.id_client = id_client;
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", id_client=" + id_client + '}';
    }

    public List<Carte> getProduits() {
        return produits;
    }

    public void setProduits(List<Carte> produits) {
        this.produits = produits;
    }
    
    public void addProduits(Carte produit) {
        this.produits.add(produit);
        for (Iterator<Carte> iterator = produits.iterator(); iterator.hasNext();) {
            Carte next = iterator.next();
            System.out.println(next.getId());
        }
    }
    
    public void removeProduits(Carte produit) {
        this.produits.remove(produit);
    }
    
    
    
}
