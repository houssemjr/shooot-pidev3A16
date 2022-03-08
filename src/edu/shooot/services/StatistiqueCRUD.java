/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.services;

/**
 *
 * @author khali
 */

import com.sun.org.apache.bcel.internal.generic.Select;
import edu.shooot.entities.Match;
import edu.shooot.entities.Statistique;
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
import static javax.management.Query.match;
/**
 *
 * @author khali
 */
public class StatistiqueCRUD {
    Connection cnx;
    public StatistiqueCRUD(){
        cnx=MyConnection.getInstance().getCnx();  
    }
   
   
    public void ajouterStatistique() {
        try {
            String requete="INSERT INTO `statistique`(`Id_match`, `TitreMatch`, `But`, `N_Buteur`, `N_Passeur`, `Nb_Corner`, `Nb_faute`, `Nb_Carton`) VALUES"
                    + " ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]','[value-8]')";
            Statement st = new MyConnection().getCnx().createStatement();
            st.executeUpdate(requete);
           System.out.println("Statistique analysée avec succès");   
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
   public void ajouterStatistique2(Statistique s){
        try {
            String requete2 ="INSERT INTO `statistique`(`Id_match` ,`TitreMatch` ,`But`, `N_Buteur`, `N_Passeur`, `Nb_Corner`, `Nb_faute`, `Nb_Carton`)"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst= new MyConnection().getCnx().prepareStatement(requete2);
            
            pst.setInt(1, s.getid_match());
            pst.setString(2, s.getTitreMatch());
            pst.setInt(3, s.getBut());
            pst.setString(4, s.getN_Buteur());
            pst.setString(5, s.getN_Passeur());
            pst.setInt(6, s.getNb_Corner());
            pst.setInt(7, s.getNb_faute());
            pst.setInt(8, s.getNb_Carton());
            pst.executeUpdate();
            System.out.println("Votre statistique est analysée");
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
   }


public List<Statistique> afficherStatistique() {
    List<Statistique> myList = new ArrayList();
        try{
       
            String requete3 = "SELECT * FROM `statistique`";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Statistique s = new Statistique();
                s.setid_match(rs.getInt(1));
                s.setTitreMatch(rs.getString("TitreMatch"));
                s.setBut(rs.getInt(3));
                s.setN_Buteur(rs.getString("N_Buteur"));
                s.setN_Passeur(rs.getString("N_Passeur"));
                s.setNb_Corner(rs.getInt(6));
                s.setNb_faute(rs.getInt(7));
                s.setNb_Carton(rs.getInt(8));
                myList.add(s);
            }
   
        } catch (SQLException ex){     
              System.out.println(ex.getMessage());
            }
        return myList;
       
    }
public ObservableList<Statistique> afficherStatistique2() {
        ObservableList<Statistique> myList=FXCollections.observableArrayList();
        try{
       
            String requete4 = "SELECT * FROM `statistique`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while (rs.next()){
                Statistique s = new Statistique();
                s.setid_match(rs.getInt(1));
                s.setTitreMatch(rs.getString("TitreMatch"));
                s.setBut(rs.getInt(3));
                s.setN_Buteur(rs.getString("N_Buteur"));
                s.setN_Passeur(rs.getString("N_Passeur"));
                s.setNb_Corner(rs.getInt(6));
                s.setNb_faute(rs.getInt(7));
                s.setNb_Carton(rs.getInt(8));
                myList.add(s);
            }
   
        } catch (SQLException ex){     
              System.out.println(ex.getMessage());
            }
        return myList;
       
    }

public void modifierStatistique(int Id_Match, String TitreMatch,int But ,String N_Buteur , String N_Passeur, int Nb_Corner, int Nb_faute, int Nb_Carton)
    {
        String requete="UPDATE `Statistique` SET `TitreMatch`=?,`But`=?,`N_Buteur`=?,`N_Passeur`=?,`Nb_Corner`=?,`Nb_faute`=?,`Nb_Carton`=? WHERE id_match=? ";
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete);
        
            ps.setString(1,TitreMatch);
            ps.setInt(2,But);
            ps.setString(3,N_Buteur);
            ps.setString(4,N_Passeur);
            ps.setInt(5,Nb_Corner);
            ps.setInt(6,Nb_faute);
            ps.setInt(7,Nb_Carton);
            ps.setInt(8,Id_Match);
            ps.executeUpdate();
            System.out.println("Statistique modifié avec succées");

        }
        catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
        }

    }
public void SupprimerStatistique (String TitreMatch )
    {
        String requete1="DELETE FROM `statistique` WHERE TitreMatch=?";
        try {
            PreparedStatement ps= new MyConnection().getCnx().prepareStatement(requete1);
            ps.setString(1,TitreMatch);
            ps.executeUpdate();
            System.out.println("statistique supprimé avec succées");

        }
        catch (SQLException ex) {
                System.out.println("chay2");
            System.err.println(ex.getMessage());
            
        }
    }

    public void MoyenneBut (int id_match){
      
        try{
       
          // String requete = "SELECT  s.statistique from match m , but b where s.id_match= " + match.getId_match()";       
            Statement st = new MyConnection().getCnx().createStatement();
            Statistique s =new  Statistique();                            
              ResultSet but = st.executeQuery("M `statistique` WHERE id_match=9"); 
            //  s.setInt(3,5);
                if (but.next()) {
                 System.out.println("buta is" + but.getFloat(1)); 
                 }
            
   
        } catch (SQLException ex){     
              System.out.println(ex.getMessage());
            }
        
 }
    public ResultSet afficherStatButCartonCorner(){
          try {
              String requete ="SELECT N_Buteur,SUM(but) as but_total,SUM(Nb_Carton) as Nb_Carton,SUM(Nb_Corner) as Nb_Corner FROM statistique group by Id_match";
              Statement st =cnx.createStatement();
              ResultSet rs= st.executeQuery(requete);
              return rs;
          } catch (SQLException ex) {
              System.err.println(ex.getMessage());
          }
          return null;
           }
}
