/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shoot.utiles;

/**
 *
 * @author houssemjrad
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class MyConnection {
    //Design Patter - Singleton
    public String url = "jdbc:mysql://localhost:3306/dbshoot";
    public String login = "root";
    public String pwd = "";
    public Connection cnx;
    public static MyConnection instance;
    

    public MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.out.println("test");
            System.out.println(ex.getMessage());
        }
    }

    public Connection getCnx() {    
        return cnx;
    }
  public static MyConnection getInstance() {
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }

    
}