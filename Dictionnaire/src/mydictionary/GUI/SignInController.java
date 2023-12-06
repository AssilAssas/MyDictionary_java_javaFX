/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mydictionary.Entities.User;
import mydictionary.Services.UserServices;

/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class SignInController implements Initializable {

     @FXML
     private Button SignIN;
     @FXML
     private TextField username;
     @FXML
     private PasswordField password;

     @FXML
     private Label PrintMassage;
     @FXML
     private Button signup;

     @Override
     public void initialize(URL url, ResourceBundle rb) {
          // TODO
     }

     public static boolean isEmpty1(String str) {
          return str == null || str.isEmpty();
     }
//     public void changeScene(String fxmlFile  )  {
//    // Load the FXML file for the new scene
//    try {FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
//
//    // Get the root node of the new scene
//    Parent root = loader.load();
//
//    // Create a new Scene object with the root node
//    Scene scene = new Scene(root);
//
//    // Get the Stage object from any node in the current scene
//    Stage stage = (Stage) SignIN.getScene().getWindow();
//
//    // Set the new scene on the Stage object
//    stage.setScene(scene);}
//    catch (IOException ex) {
//         System.out.println(ex.getMessage());
//    }
//}

     @FXML
     private void SignIn(ActionEvent event) {
          System.out.println("SignIn");
          UserServices us = new UserServices();
          if (us.Connexion(username.getText(), password.getText()) == null) {

               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("MyDictionary :: ERROR MESSAGE");
               alert.setHeaderText(null);
               alert.setContentText("INVALID LOGIN !!");
               alert.showAndWait();
         
              

          } else {
//               Alert alert = new Alert(Alert.AlertType.INFORMATION);
//               alert.setTitle("MyDictionary :: BIENVENNUE");
//               alert.setHeaderText(null);
//               alert.setContentText("Logged In!!");
//               alert.showAndWait();
//               String s = "Translator.fxml";
//               changeScene(s);
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("TranslatorUser.fxml"));
        try {
            Parent root = loader.load();
             TranslatorUserController adc = loader.getController();
        // bqck is the  button of login 
             back.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
          }
         
          

     }

     @FXML
     private void Retour(ActionEvent event) {
          HomePagOnAction();

     }
     @FXML 
     private Button back;
      public void SignUpPagOnAction() {
          try {
               Stage stage = (Stage) signup.getScene().getWindow();
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
  
      public void TranslatorPagOnAction() {
          try {
               Stage stage = (Stage) SignIN.getScene().getWindow();
               stage.close();
               Parent root = FXMLLoader.load(getClass().getResource("Translator.fxml"));
               Stage registerStage = new Stage();
               registerStage.initStyle(StageStyle.UNDECORATED);
               registerStage.setScene(new Scene(root,1000 ,600 ));
               registerStage.show();

          } catch (Exception e) {
               e.printStackTrace();
               e.getCause();
          }

     }

     @FXML
     private void SignUp(ActionEvent event) {
          SignUpPagOnAction();
     }

}
