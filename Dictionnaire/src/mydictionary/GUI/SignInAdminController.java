/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class SignInAdminController implements Initializable {

     @FXML
     private TextField Sign_in_Email;
     @FXML
     private PasswordField Sign_In_Password;
     @FXML
     private Button BtnSignIn;
     @FXML
     private Button back;

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {
          
          // TODO
     }  
     @FXML
      private void SignInAdmin(ActionEvent event) {
            try {
               Stage stage = (Stage) BtnSignIn.getScene().getWindow();
               stage.close();
               Parent root = FXMLLoader.load(getClass().getResource("LanguageChooser.fxml"));
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
      private void Retour(ActionEvent event){
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
      
     
}
