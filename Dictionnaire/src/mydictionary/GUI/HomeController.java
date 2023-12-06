/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class HomeController implements Initializable {

     @FXML
     private Button showSignin;
     @FXML
     private Button Showadmin;
     @FXML
     private ImageView logo;
     @FXML
     private Label Name;
     @FXML
     private Button showSignup;
     @FXML
     private ImageView cover;
     

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {
            String path = "C:\\Users\\ZOLDYCK\\OneDrive\\Documents\\NetBeansProjects\\Dictionnaire\\src\\images\\51BWcaYk0vL.png";
            String path1 = "C:\\Users\\ZOLDYCK\\OneDrive\\Documents\\NetBeansProjects\\Dictionnaire\\src\\images\\4664332_6761.jpg";
            
       
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream1 = null;
         
        try {
            fileInputStream = new FileInputStream(path);
            fileInputStream1 = new FileInputStream(path1);
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LanguageChooserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Create an Image object with the InputStream
        Image image = new Image(fileInputStream);
        Image image1 = new Image(fileInputStream1);
      
        logo.setImage(image);
        cover.setImage(image1);
        
        
     }

    
          
     
     @FXML
     
     private void showSignup(ActionEvent event) {
          SignUpPagOnAction();
          
     }

     @FXML
     private void showSignin(ActionEvent event) {
            SignInPagOnAction();
     }

     @FXML
     private void showlogAdmin(ActionEvent event) {
          SignInAdminPagOnAction();
          
     }
      public void SignUpPagOnAction() {
          try {
               Stage stage = (Stage) showSignup.getScene().getWindow();
               stage.close();
               Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
               Stage registerStage = new Stage();
               registerStage.initStyle(StageStyle.UNDECORATED);
               registerStage.setScene(new Scene(root,1000 ,600 ));
               registerStage.show();

          } catch (Exception e) {
               e.printStackTrace();
               e.getCause();
          }

     }
       public void SignInPagOnAction() {
          try {
               Stage stage = (Stage) showSignup.getScene().getWindow();
               stage.close();
               Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
               Stage registerStage = new Stage();
               registerStage.initStyle(StageStyle.UNDECORATED);
               registerStage.setScene(new Scene(root,1000 ,600 ));
               registerStage.show();

          } catch (Exception e) {
               e.printStackTrace();
               e.getCause();
          }

     }
        public void SignInAdminPagOnAction() {
          try {
               Stage stage = (Stage) showSignup.getScene().getWindow();
               stage.close();
               Parent root = FXMLLoader.load(getClass().getResource("SignInAdmin.fxml"));
               Stage registerStage = new Stage();
               registerStage.initStyle(StageStyle.UNDECORATED);
               registerStage.setScene(new Scene(root,1000 ,600 ));
               registerStage.show();

          } catch (Exception e) {
               e.printStackTrace();
               e.getCause();
          }

     }
        
        
}
