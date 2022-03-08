/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;

import edu.shoot.entities.Carte;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class CarteController implements Initializable {

    @FXML
    private AnchorPane produit;
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
    private Carte P;
    




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setData(Carte P,MyListener myListener) {
                    InputStream stream = null;

        try {
            this.myListener = myListener;
            //productID.setText(String.valueOf(P.getId()));
            
            
            
            
            //System.out.println(P);
            productID.setText(String.valueOf(P.getId()));
            levelLabel.setText(P.getNom());
            priceLable.setText(String.valueOf(P.getPrix()));
            stream = new FileInputStream(P.getImgcarte());
            Image image = new Image(stream);
            img.setImage(image);
            System.out.println(P);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @FXML
    private void click(MouseEvent event) {
     myListener.onClickListener(parseInt(productID.getText()));

    }

    }
    

