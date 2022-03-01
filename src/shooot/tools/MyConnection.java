/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP PC
 */
public class MyConnection {
    
    public String url="jdbc:mysql://localhost:3306/shooot";
    public String login="root";
    public String pwd="";
    Connection cnx;
    public static MyConnection instance;

    
    private MyConnection(){
        try{
            cnx = DriverManager.getConnection(url,login,pwd);
            System.out.println("connexion etablie !");
        }catch(SQLException e){
            System.err.println(e.getMessage()); 
        }
    }
    
    public Connection getCnx(){
        return  (Connection) cnx;
    }
    
    public static MyConnection getInstance() {
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }

}
