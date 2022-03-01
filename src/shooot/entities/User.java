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
public class User {
    private int id;
    private String prenom;
    private String nom;
    private String email;
    private int num;
    private String userName;
    private String pwd;

    public User() {
    }

    
    public User(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public User(String prenom, String nom, String userName) {
        this.prenom = prenom;
        this.nom = nom;
        this.userName = userName;
    }

    public User(String prenom, String nom, String userName, String pwd) {
        this.prenom = prenom;
        this.nom = nom;
        this.userName = userName;
        this.pwd = pwd;
    }

    public User(String prenom, String nom, int num, String email, String userName, String pwd) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.num = num;
        this.userName = userName;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
    
    

    public String getUserName() {
        return userName;
    }


    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", num=" + num + ", userName=" + userName + ", pwd=" + pwd + '}';
    }

   
    
    
  
    
}
