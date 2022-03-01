/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoootpi.entities;

/**
 *
 * @author houssemjrad
 */
public class joueur {
    int id ;
    int nbbut;
    public joueur(){
    
}
    public joueur(int id, int nbbut) {
        this.id = id;
        this.nbbut = nbbut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbbut(int nbbut) {
        this.nbbut = nbbut;
    }

    public int getId() {
        return id;
    }

    public int getNbbut() {
        return nbbut;
    }

    @Override
    public String toString() {
        return "joueur{" + "id=" + id + ", nbbut=" + nbbut + '}';
    }
    
    
}
