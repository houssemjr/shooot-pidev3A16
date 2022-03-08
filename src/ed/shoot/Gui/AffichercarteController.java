/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.shoot.Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import edu.shoot.entities.Carte;
import edu.shoot.entities.panierr;
import edu.shoot.services.CrudCarte;
import edu.shoot.services.CrudPan;
import edu.shoot.services.Crudpanier;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author houssemjrad
 */
public class AffichercarteController implements Initializable {

    @FXML
    private TableView<Carte> tv;
    @FXML
    private TableColumn<Carte, String> c2;
    @FXML
    private TableColumn<Carte, String> c3;
    @FXML
    private TableColumn<Carte, Integer> c4;
    @FXML
    private TableColumn<Carte, Float> c5;
    @FXML
    private TableColumn<Carte, Integer> c6;
    @FXML
    private TableColumn<Carte, Integer> c1;
    @FXML
    private TextField tt1;
    @FXML
    private TextField tt3;
    @FXML
    private TextField tt2;
    @FXML
    private TextField tt4;
    @FXML
    private TextField tt5;
    @FXML
    private TextField tt6;
    @FXML
    private Button b3;
    @FXML
    private FontAwesomeIcon D1;
    @FXML
    private Button bpar;
    @FXML
    private ImageView imgva;
    @FXML
    private TextField tt7;
    @FXML
    private TableColumn<Carte, String> c7;
    @FXML
    private ImageView im2;
    @FXML
    private Button bask;
    @FXML
    private Button res;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCartes();
        // TODO
    }    
  public void showCartes(){
        CrudCarte U=new CrudCarte();
        ObservableList<Carte> list =  U.affichercarte1();
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        c2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        c3.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        c4.setCellValueFactory(new PropertyValueFactory<>("level"));
        c5.setCellValueFactory(new PropertyValueFactory<>("prix"));
        c6.setCellValueFactory(new PropertyValueFactory<>("id_premuim"));
        c7.setCellValueFactory(new PropertyValueFactory<>("imgcarte"));

        
        tv.setItems(list);
    
}
    @FXML
    private void getcarte(ActionEvent event) {
           Carte c = tv.getSelectionModel().getSelectedItem();
         

                tt2.setText(c.getNom());
        tt3.setText(c.getPrenom());
        tt4.setText(String.valueOf(c.getLevel()));
        tt5.setText(String.valueOf(c.getPrix()));
        tt6.setText(String.valueOf(c.getLevel()));
        tt7.setText(c.getImgcarte());
        
      

        
    }
    
   private void tablehandleButtonAction(java.awt.event.MouseEvent event) {
        Carte c = tv.getSelectionModel().getSelectedItem();
        
        tt2.setText(c.getNom());
        tt3.setText(c.getPrenom());
        tt4.setText(String.valueOf(c.getLevel()));
        tt5.setText(String.valueOf(c.getPrix()));
        tt6.setText(String.valueOf(c.getLevel()));

        
    }
        private void setCellValueFromTableToTextField() {
        tv.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Carte b = tv.getItems().get(tv.getSelectionModel().getSelectedIndex());
                tt2.setText(b.getNom());
                tt3.setText(b.getPrenom());
                
              tt1.setText(String.valueOf(b.getId()));

            }

        });
    }

      private int getIdCarte() {
        tv.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                int ids = tv.getSelectionModel().getSelectedItem().getId();

            }
        });
        return tv.getSelectionModel().getSelectedItem().getId();
    }

    @FXML
    private void updatecarte(ActionEvent event) {
         Carte c = tv.getSelectionModel().getSelectedItem();

                            
                                
                                String nom = tt2.getText();
                                String prenom = tt3.getText();
                                String Lv=tt4.getText();
                                int level=Integer.parseInt(Lv);
                                String pr=tt5.getText();
                                float prix=Float.parseFloat(pr);
                                String idp=tt6.getText();
                                int id_premuim =Integer.parseInt(idp);
                                String imgcarte = tt7.getText();
                                

                                
                                CrudCarte jc = new CrudCarte();
                                Carte b1= new Carte();
                                jc.modifiercarte(c.getId(),nom, prenom, level, prix, id_premuim,imgcarte);
                                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connection");

            alert.setHeaderText(null);
            alert.setContentText("votre carte a été modifié avec succées !");

            alert.showAndWait();
         

                               
                     
       
                                showCartes();
                                  
                               
        
        
    }

    @FXML
    private void deletecarte(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation de suppression de carte");
                            alert.setHeaderText(null);
                            alert.setContentText("Vouliez vous supprimer vraiment la carte ? ");
                            Optional<ButtonType> action = alert.showAndWait();
                            

                            if (action.get() == ButtonType.OK) {
                                         Carte c = tv.getSelectionModel().getSelectedItem();

                               // String idd= tt1.getText();
                                //int id=Integer.parseInt(idd);
                                CrudCarte abb = new CrudCarte();
                                abb.supprimercarte(c.getId());
                                showCartes();
                            }

    }

    @FXML
    private void dialogscroll(MouseEvent event) {
        
    }

    @FXML
    private void printpdf(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();

        Node root = this.tv;

        if (job != null) {
            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
            Printer printer = job.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
            boolean success = job.printPage(pageLayout, root);
            if (success) {
                job.endJob();
    }
}
    }

    @FXML
    private void direct(MouseEvent event) {
        
    }

    @FXML
    private void browse(ActionEvent event) {
         try {
            FileChooser filechooser = new FileChooser();
            //FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", ".JPG");
          //  FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", ".PNG");
         //   filechooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
            
            File file = filechooser.showOpenDialog(null);

            Image img = SwingFXUtils.toFXImage(ImageIO.read(file), null);
            imgva.setImage(img);
            if (file != null) {
                String cwd = System.getProperty("user.dir");
                String path = new File(cwd).toURI().relativize(file.toURI()).getPath();
                tt7.setText(file.getPath());
                System.out.println(path);
                
                
            }  
        } catch (IOException ex) {
            System.out.println(" yosr");        }
    }

    @FXML
    private void direct(ActionEvent event) {
                                String nom = tt2.getText();
                                String prenom = tt3.getText();
                                String pr=tt5.getText();
                                float prix=Float.parseFloat(pr);
                               Crudpanier jc = new Crudpanier();
                                panierr b1= new panierr(nom,prenom,prix);
                                System.out.println(b1);
                                   jc.ajouterPanier(b1);
    }

    @FXML
    private void reserver(ActionEvent event) {
        String nom = tt2.getText();
                                String prenom = tt3.getText();
                                String pr=tt5.getText();
                                float prix=Float.parseFloat(pr);
                               Crudpanier jc = new Crudpanier();
                                panierr b1= new panierr(nom,prenom,prix);
                                System.out.println(b1);
                                   jc.ajouterPanier(b1);
    }
    
}
