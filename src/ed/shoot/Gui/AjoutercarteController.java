/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;

import edu.shoot.entities.Carte;
import edu.shoot.services.CrudCarte;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class AjoutercarteController implements Initializable {

    @FXML
    private Button boutonajouter;
    @FXML
    private TextField a1;
    @FXML
    private TextField a2;
    @FXML
    private TextField a3;
    @FXML
    private TextField a4;
    @FXML
    private TextField a5;
    @FXML
    private ImageView imgv;
    @FXML
    private TextField a6;
    @FXML
    private Button parcouririmage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterCarte(ActionEvent event) {
        if (a1.getText().isEmpty() || a2.getText().isEmpty()  || a3.getText().isEmpty() || a4.getText().isEmpty() 
                        || a5.getText().isEmpty() 
                        || a6.getText().isEmpty())
        {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Les champs sont vides");
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();

        } else {
        String nom = a1.getText();
        String prenom = a2.getText();
        int level = Integer.parseInt(a3.getText());
        float prix = Float.parseFloat(a4.getText());
        int id_premuim = Integer.parseInt(a5.getText());
        String imgcarte=a6.getText();
        
         Carte c =new Carte (nom,prenom,level,prix,id_premuim,imgcarte);
         CrudCarte cc = new CrudCarte();
         cc.ajouterCarte(c);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connection");

            alert.setHeaderText(null);
            alert.setContentText("votre carte a été crée avec succées !");

            alert.showAndWait();
        }
    }

    @FXML
    private void parcouririmg(ActionEvent event) {
         try {
            FileChooser filechooser = new FileChooser();
            //FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", ".JPG");
          //  FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", ".PNG");
         //   filechooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            
            File file = filechooser.showOpenDialog(null);

            Image img = SwingFXUtils.toFXImage(ImageIO.read(file), null);
            imgv.setImage(img);
            if (file != null) {
                String cwd = System.getProperty("user.dir");
                String path = new File(cwd).toURI().relativize(file.toURI()).getPath();
                a6.setText(file.getPath());
                System.out.println(path);
                
                
            }  
        } catch (IOException ex) {
            System.out.println(" yosr");        }
    }
    
}
