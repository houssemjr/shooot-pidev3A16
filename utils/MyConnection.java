package edu.shoootpi.utils;

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
    public String url = "jdbc:mysql://localhost:3306/shooot";
    public String login = "root";
    public String pwd = "";
    public Connection cnx;
    

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

    
}