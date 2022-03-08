/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;

import edu.shoot.entities.Carte;
import edu.shoot.services.CrudCarte;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class ConsulterCarteController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     * 
     */ 
    int id;
    CrudCarte PM = new CrudCarte();
    List<Carte> PL = PM.affichercarte();
    @FXML
    private Label levelLabel;
    @FXML
    private Label priceLable;
    @FXML
    private TextField productID;
    @FXML
    private ImageView img;
    @FXML
    private TextField idProduichosen;
    private MyListener myListener;
    private int setChosenFruit(Carte P) {
        

        InputStream stream = null;
        try {
           productID.setText(String.valueOf(P.getId()));
            
            
            
            
            //System.out.println(P);
         //   productID.setText(String.valueOf(P.getId()));
            levelLabel.setText(P.getNom());
            priceLable.setText(String.valueOf(P.getPrix()));
            stream = new FileInputStream(P.getImgcarte());
            Image image = new Image(stream);
            img.setImage(image);
            System.out.println(P);
            
//            stream = new FileInputStream(P.getLogo());
//            Image imaaage = new Image(stream);
//            logo.setImage(imaaage);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsulterCarteController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(ConsulterCarteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return P.getId();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        if (PL.size() > 0) {

            setChosenFruit(PL.get(0));
            myListener = new MyListener() {

                @Override
                public void onClickListener(int id_joueur) {

                    Carte P = PM.recupJoueur(id);
                    setChosenFruit(P);

                }
            };
        }

        
                         

        // listProduit.addAll(getData());
        int column = 0;
        int row = 1;
        for (Carte P : PL) {
            try {
                System.out.println(P);
                
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("carte.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                CarteController carteController = fxmlLoader.getController();
                carteController.setData(P,myListener);
                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException ex) {
                System.out.println("yeah");
                Logger.getLogger(ConsulterCarteController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
    }    
    
}
