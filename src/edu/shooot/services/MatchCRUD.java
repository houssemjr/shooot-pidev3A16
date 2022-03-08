/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.services;


import edu.shooot.entities.Match;
import edu.shooot.utiles.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author khali
 */
public class MatchCRUD {
    Connection cnx;
    public MatchCRUD(){
        cnx=MyConnection.getInstance().getCnx();             
    }
   
    public void ajouterMatch() {
        try {
            String requete="INSERT INTO `match`(`id_equipe1`, `id_equipe2`, `date`, `id_comp`, `id_stat`, `id_prono`)"
                    + "VALUES(2,3,'14/4/2022',11,22,33)";
            Statement st = new MyConnection().getCnx().createStatement();
            st.executeUpdate(requete);
           System.out.println("Match ajouté avec succès");   
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
   public void ajouterMatch2(Match m){
        try {
            String requete2 ="INSERT INTO `match`(`id_equipe1`, `id_equipe2`, `date`, `id_comp`, `id_stat`, `id_prono`)"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement pst= new MyConnection().getCnx().prepareStatement(requete2);
            pst.setInt(1, m.getId_equipe1());
            pst.setInt(2, m.getId_equipe2());
            pst.setString(3, m.getDate());
            pst.setInt(4, m.getId_comp());
            pst.setInt(5, m.getId_stat());
            pst.setInt(6, m.getId_prono());
            pst.executeUpdate();
            System.out.println("Votre match est ajouté");
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
   }


public List<Match> afficherMatchs() {
    List<Match> myList = new ArrayList();
        try{
       
            String requete3 = "SELECT * FROM `match`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Match m = new Match();
                m.setId_match(rs.getInt(1));
                m.setId_equipe1(rs.getInt(2));
                m.setId_equipe2(rs.getInt(3));
                m.setDate(rs.getString("date"));
                m.setId_comp(rs.getInt(5));
                m.setId_stat(rs.getInt(6));
                m.setId_prono(rs.getInt(7));
                myList.add(m);
            }
   
        } catch (SQLException ex){     
              System.out.println(ex.getMessage());
            }
        return myList;
       
    }
public ObservableList<Match> afficherMatchs2() {
        ObservableList<Match> myList=FXCollections.observableArrayList();
        try{
       
            String requete3 = "SELECT * FROM `match`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Match m = new Match();
                m.setId_match(rs.getInt(1));
                m.setId_equipe1(rs.getInt(2));
                m.setId_equipe2(rs.getInt(3));
                m.setDate(rs.getString("date"));
                m.setId_comp(rs.getInt(5));
                m.setId_stat(rs.getInt(6));
                m.setId_prono(rs.getInt(7));
                myList.add(m);
            }
   
        } catch (SQLException ex){     
              System.out.println(ex.getMessage());
            }
        return myList;
       
    }
public Match recup(int idM) {
        Match m = new Match();
        try{
         
            String requete3 = "SELECT * FROM `match` where id_match=?";
            PreparedStatement prepare =cnx.prepareStatement(requete3);
            prepare.setInt(1, idM);
            ResultSet rs = prepare.executeQuery();
            while (rs.next()){
               
                m.setId_match(rs.getInt(1));
                m.setId_equipe1(rs.getInt(2));
                m.setId_equipe2(rs.getInt(3));
                m.setDate(rs.getString("date"));
                m.setId_comp(rs.getInt(5));
                m.setId_stat(rs.getInt(6));
                m.setId_prono(rs.getInt(7));
               
            }
   
        } catch (SQLException ex){     
              System.out.println(ex.getMessage());
            }
        return m;
       
    }


public void modifierMatch(int id_match ,int id_equipe1 , int id_equipe2, String date, int id_comp, int id_stat, int id_prono)
    {
        String requete="UPDATE `match` SET `id_equipe1`=?,`id_equipe2`=?,`date`=?,`id_comp`=?,`id_stat`=?,`id_prono`=?   WHERE id_match=?";
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete);
            ps.setInt(1,id_equipe1);
            ps.setInt(2,id_equipe2);
            ps.setString(3,date);
            ps.setInt(4,id_comp);
            ps.setInt(5,id_stat);
            ps.setInt(6,id_prono);
           
         
            ps.executeUpdate();
            System.out.println("match modifié avec succées");

        }
        catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
        }

    }
public void SupprimerMatch (int id_match )
    {
        String requete1="DELETE FROM `match` WHERE id_match=?";
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete1);
            ps.setInt(1,id_match);
            ps.executeUpdate();
            System.out.println("match supprimé avec succées");

        }
        catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
            
        }
    }

    public void ajouterMatch(Match m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
}


//  public  int[] convertDateTotabInt(String date){
//      String tabDate []= date.split(" / :");
//      System.out.println(tabDate);
//      int [] tabDateInt = new int[5] ;
//      for(int i=0;i<tabDateInt.length;i++){
//          tabDateInt[i]=Integer.parseInt(tabDate[i]);
//      }
//      return tabDateInt;
//  }
//  
//  public long calculTimeStamp(int[] tabIntDate){
//      int year366 = tabIntDate[3]/4;
//      int year365 = tabIntDate[3]-year366;
//      long timestamp =(year365*365*24*60)+(year366*366*24*60);
//      return timestamp;
//  }
//  
//  public String msgTimeLeft(long timestamp){
//      int days = (int)timestamp%365;
//      int hours = (int)timestamp%24;
//      int minutes = (int)hours%60;
//      String timeLeftMsg ="time left until the match "+Integer.toString(days)+" days and" +Integer.toString(hours)+" hours and "+Integer.toString(minutes)+" minutes";
//      return timeLeftMsg;
//  }
//
//}


  
