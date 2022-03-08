/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

/**
 *
 * @author khali
 */
public class FXMain extends Application {
    
    @Override
    public void start (Stage primaryStage)throws Exception {
        
        try {
           Parent root = FXMLLoader.load(getClass().getResource("StatAll.fxml"));
         //  Parent root = FXMLLoader.load(getClass().getResource("AjouterStat.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("Match.fxml"));
             //Parent root = FXMLLoader.load(getClass().getResource("StatMatch.fxml"));
             //Parent root = FXMLLoader.load(getClass().getResource("StatCarton.fxml"));
             // Parent root = FXMLLoader.load(getClass().getResource("Statistique.fxml"));
              //Parent root = FXMLLoader.load(getClass().getResource("AffichageMatch.fxml"));
           
            Scene scene = new Scene(root);
            
       //primaryStage.setTitle("AffichageMatch!");
       // primaryStage.setTitle("Statistique");
         primaryStage.setTitle("Match!");
       primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
       }
    }
//    @Override 
//    public void start(Stage primaryStage) { 
//        // Création des séries. 
//        final List<BarChart.Series> seriesList = new LinkedList<>(); 
//        final String[] categoriesComp= {"2012", "2013", "2014"}; 
//        final String[] seriesNames = {"Esapgne", "Angleterre", "Italie", "France"}; 
//        final int[][] allValues = { 
//            {43, 55, 42}, 
//            {60, 39, 29}, 
//            {38, 55, 49}, 
//            {52, 37, 30},}; 
//        final double minY = 0; 
//        double maxY = -Double.MAX_VALUE; 
//        for (int seriesIndex = 0; seriesIndex < seriesNames.length; seriesIndex++) { 
//            final BarChart.Series series = new BarChart.Series<>(); 
//            series.setName(seriesNames[seriesIndex]); 
//            final int[] values = allValues[seriesIndex]; 
//            for (int categoryIndex = 0; categoryIndex < categoriesComp.length; categoryIndex++) { 
//                final int value = values[categoryIndex]; 
//                final String category = categoriesComp[categoryIndex]; 
//                maxY = Math.max(maxY, value); 
//                final BarChart.Data data = new BarChart.Data(category, value); 
//                series.getData().add(data); 
//            } 
//            seriesList.add(series); 
//        } 
//        // Création du graphique. 
//        final CategoryAxis xAxis = new CategoryAxis(); 
//        xAxis.getCategories().setAll(categoriesComp); 
//        xAxis.setLabel("Années"); 
//        final NumberAxis yAxis = new NumberAxis(minY, maxY, 500); 
//        yAxis.setLabel("But/Journée"); 
//        final BarChart chart = new BarChart(xAxis, yAxis); 
//        chart.setTitle("Idée Pronostic"); 
//        chart.getData().setAll(seriesList); 
//        // Montage de l'IU. 
//        final StackPane root = new StackPane(); 
//        root.getChildren().add(chart); 
//        final Scene scene = new Scene(root); 
//        primaryStage.setTitle("Statistique de But!"); 
//        primaryStage.setScene(scene); 
//        primaryStage.show(); 
//    } 

   /**
    * @param args the command line arguments
     */
   public static void main(String[] args) {
       launch(args);
   }
    
}
