/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javafx.css.StyleOrigin.USER_AGENT;
import jdk.nashorn.internal.parser.JSONParser;
import shooot.entities.User;
import shooot.tools.MyConnection;
import shooot.entities.Encrypte;

/**
 *
 * @author HP PC
 */
public class UserCRUD {
    
    String cryptedText;
    Connection cnx2;
    private final String USER_AGENT = "Mozilla/5.0";
    
    public UserCRUD(){
        cnx2=MyConnection.getInstance().getCnx();             
    }
    
    private String encrypte(String text){
        Encrypte E=new Encrypte();
        
        cryptedText=E.EcryptePwd(text);
        return cryptedText;
    }
    
    public void ajouterUser(){
        try{
            String requete ="INSERT INTO user (nom,prenom,userName,pwd) VALUES ('seif','ben karim','payouk','123')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("personne ajouté avec succés");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void ajouterUser2(User u) {
        try {
            String requete = "INSERT INTO user (nom,prenom,num,email,userName,pwd) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst =cnx2.prepareStatement(requete);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setInt(3, u.getNum());
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getUserName());
            pst.setString(6, encrypte(u.getPwd()));

            pst.executeUpdate();
            System.out.println("personne ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<User> affichageUsers() {
        List<User> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM user";
            Statement st = cnx2.createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                User u = new User();
                
                u.setId(res.getInt(1));
                u.setNom(res.getString("nom"));
                u.setPrenom(res.getString("prenom"));
                u.setNum(res.getInt(4));
                u.setEmail(res.getString(5));
                u.setUserName(res.getString("userName"));
                
                
                myList.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    return myList;
    }
    
      public ObservableList<User> affichageUsers2() {
        ObservableList<User> myList = FXCollections.observableArrayList();
        try {
            String requete = "SELECT * FROM user";
            Statement st = cnx2.createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                User u = new User();
                
                u.setId(res.getInt(1));
                u.setNom(res.getString("nom"));
                u.setPrenom(res.getString("prenom"));
                u.setNum(res.getInt(4));
                u.setEmail(res.getString(5));
                u.setUserName(res.getString("userName"));
                
                
                myList.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    return myList;
    }
    
    public void supprimerUser(String userName){
        try{
            String requete ="DELETE FROM user WHERE userName=?";
            PreparedStatement pst =cnx2.prepareStatement(requete);
            
            pst.setString(1 ,userName);
            
            pst.executeUpdate();
            System.out.println("user supprimé avec succés");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void updateUser(String userName,String nom,String prenom,int num, String email, String mdp) {
        try {
            String requete = "UPDATE User SET nom=?, prenom=?, num=?, email=?, pwd=? WHERE userName=?";
            PreparedStatement pst =cnx2.prepareStatement(requete);
            
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setInt(3, num);
            pst.setString(4, email);
            pst.setString(5, encrypte(mdp));
            pst.setString(6, userName);

            pst.executeUpdate();
            System.out.println("personne modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   public User checkUser(String login, String pwd){
        try{
        String url = "http://localhost/webservice/logincheck.php";
        URL obj = new URL(url);
        /*HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();*/
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "login="+login+"&password="+encrypte(pwd);

        // Send post request*//-
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        /**/
        String json_string = response.toString();

        //JSONParser j = new JSONParser();

        System.out.println("javaapplication1.NewClass.sendPost()" + json_string);

        if(json_string.contains("erreur")){
            System.err.println("utilisateur n'existe pas"); 
            return null;
        }else{
            System.err.println("utilisateur avec id "+json_string);
            int id = Integer.parseInt(json_string);
            User user = rechercherUser(id);
            System.out.println("userrr : "+user);
            SessionService sessionService = new SessionService();
            sessionService.setUser(user);

            return user;
        }
 /**/
        }catch(Exception e){
            System.err.println("erreur : "+e.getMessage());
            return null;
        }
    }
   
    public User rechercherUser(int id) throws SQLException {

        try {

            String requete = "select * from user where id='" + id + "'";

            PreparedStatement pst = cnx2.prepareStatement(requete);

            //pst.setInt(1, id);
            //pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery(requete);
            User u = null;

            while (rs.next()) {

                u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setNum(rs.getInt(4));
                u.setEmail(rs.getString(5));
                u.setUserName(rs.getString("userName"));

                System.out.println(u);
                return u;

            }
        }
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }return null;
        
    }
    
    
    public User checkUser1(String login, String pwd) {
        
        try {

            String requete = "select * from user where email ='"+login+"'" ;

            PreparedStatement pst = cnx2.prepareStatement(requete);
             

            //pst.setInt(1, id);
            //pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery(requete);
            User u = null;
            if(rs.getString("pwd")==encrypte(pwd)){

            while (rs.next()) {
               
                u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setNum(rs.getInt(4));
                u.setEmail(rs.getString(5));
                u.setUserName(rs.getString("userName"));
                
            } 

                //System.out.println(u);
                SessionService sessionService = new SessionService();
                sessionService.setUser(u);
                return u;

            }
            SessionService sessionService = new SessionService();
            sessionService.setUser(u);
            return u;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
}

    

