/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.shooot.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.Clock;

/**
 *
 * @author khali
 */
public class Match {

    private int id_match;
    private int id_equipe1;
    private int id_equipe2;
    private String date;
    private int id_comp;
    private int id_stat;
    private int id_prono;


    public Match() {
    }

    public Match( int id_equipe1, int id_equipe2, String date, int id_comp, int id_stat, int id_prono) {
        
        this.id_equipe1 = id_equipe1;
        this.id_equipe2 = id_equipe2;
        this.date = date;
        this.id_comp = id_comp;
        this.id_stat = id_stat;
        this.id_prono = id_prono;
     
    }
    public Match(int Id_match , String date ,int id_equipe1, int id_equipe2, int id_comp, int id_stat, int id_prono) {
        
        this.id_match = Id_match;
        this.date = date;
        this.id_equipe1 = id_equipe1;
        this.id_equipe2 = id_equipe2;
        this.id_comp = id_comp;
        this.id_stat = id_stat;
        this.id_prono = id_prono;

    }

    public Match(int aInt, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public int getId_equipe1() {
        return id_equipe1;
    }

    public void setId_equipe1(int id_equipe1) {
        this.id_equipe1 = id_equipe1;
    }

    public int getId_equipe2() {
        return id_equipe2;
    }

    public void setId_equipe2(int id_equipe2) {
        this.id_equipe2 = id_equipe2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_comp() {
        return id_comp;
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    public int getId_stat() {
        return id_stat;
    }

    public void setId_stat(int id_stat) {
        this.id_stat = id_stat;
    }

    public int getId_prono() {
        return id_prono;
    }

    public void setId_prono(int id_prono) {
        this.id_prono = id_prono;
    }
     
    @Override
    public String toString() {
        return "Match{" + "id_match=" + id_match + ", id_equipe1=" + id_equipe1 + ", id_equipe2=" + id_equipe2 + ", date=" + date + ", id_comp=" + id_comp + ", id_stat=" + id_stat + ", id_prono=" + id_prono +  '}';
    }
    public void printDurée(){
        String[] arrayString = this.date.split("/");
        int  arrayInt [] = {0,0,0};
        for(int i=0 ; i<arrayString.length;i++){
            arrayInt[i] = Integer.parseInt(arrayString[i]);
        }
        LocalDate date = LocalDate.of(arrayInt[0], arrayInt[1], arrayInt[2]);
        LocalDate now = LocalDate.now();
        Period period = Period.between(date, now);
        System.out.println(+period.getDays()+"jours "+" ,"+period.getChronology()+"heures"+period.getChronology()+"minutes");
}
}
