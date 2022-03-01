/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.entities;

/**
 *
 * @author HP PC
 */
public class Admin {
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private String pwd;
    private int num;

    public Admin() {
    }

    
    public Admin(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public Admin(String prenom, String nom, int num, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.num=num;
        this.email = email;
    }

    public Admin(String prenom, String nom, String email, String pwd) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.pwd = pwd;
    }


    public Admin(String prenom, String nom,int num, String email, String pwd) {
        
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.pwd = pwd;
        this.num = num;
    }
    
    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public int getNum() {
        return num;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", pwd=" + pwd + ", num=" + num + '}';
    }
    
    

    
}
