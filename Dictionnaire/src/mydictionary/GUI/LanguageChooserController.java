/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mydictionary.Entities.Traduction;
import mydictionary.Services.ExportService;
import mydictionary.Services.ImportService;

/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class LanguageChooserController implements Initializable {

     @FXML
     private Label Name;
     @FXML
     private ImageView fr;
     @FXML
     private ImageView uk;
     @FXML
     private ImageView logo;
     @FXML
     private Button back;
     @FXML
     private Button back1;
     @FXML
     private Button back2;




     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {

        String path = "C:\\Users\\ZOLDYCK\\OneDrive\\Documents\\NetBeansProjects\\Dictionnaire\\src\\images\\51BWcaYk0vL.png";
        String pathfr = "C:\\Users\\ZOLDYCK\\OneDrive\\Documents\\NetBeansProjects\\Dictionnaire\\src\\images\\fr.png";
        String pathuk = "C:\\Users\\ZOLDYCK\\OneDrive\\Documents\\NetBeansProjects\\Dictionnaire\\src\\images\\uk.png"; 
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStreamfr = null;
        FileInputStream fileInputStreamuk = null;
        
        try {
            fileInputStream = new FileInputStream(path);
             fileInputStreamfr = new FileInputStream(pathfr);
              fileInputStreamuk = new FileInputStream(pathuk);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LanguageChooserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Create an Image object with the InputStream
        Image image = new Image(fileInputStream);
        Image imagefr = new Image(fileInputStreamfr);
        Image imageuk = new Image(fileInputStreamuk);
        logo.setImage(image);
        fr.setImage(imagefr);
        uk.setImage(imageuk);
     }

     @FXML
     private void GoFrensh(MouseEvent event) {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
          try {
               Parent root = loader.load();
               AdminController adc = loader.getController();
               adc.ConvertLanguage("FR");
               Name.getScene().setRoot(root);
          } catch (IOException ex) {
               System.out.println(ex.getMessage());
          }

     }

     @FXML
     private void GoEnglish(MouseEvent event) {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin.fxml"));
          try {
               Parent root = loader.load();
               AdminController adc = loader.getController();
               adc.ConvertLanguage("EN");
               Name.getScene().setRoot(root);
          } catch (IOException ex) {
               System.out.println(ex.getMessage());
          }
     }
     @FXML 
     private void Retour (ActionEvent event) {
          HomePagOnAction();
          
     }
     public void HomePagOnAction() {
          try {
               Stage stage = (Stage) back.getScene().getWindow();
               stage.close();
               Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
               Stage registerStage = new Stage();
               registerStage.initStyle(StageStyle.UNDECORATED);
               registerStage.setScene(new Scene(root, 1000, 600));
               registerStage.show();

          } catch (Exception e) {
               e.printStackTrace();
               e.getCause();
          }

     }

     @FXML
     private void exportData(ActionEvent event) {
     
     
     }

     @FXML
     private void importData(ActionEvent event) {
          String filePath="";
          ImportService IS = new ImportService();
     try {
         IS.importFromFile(filePath);
     }
     catch (Exception e) { 
          e.getMessage();
     }}

   

}
