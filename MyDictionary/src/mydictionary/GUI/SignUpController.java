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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mydictionary.Entities.User;
import mydictionary.Services.UserServices;

/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class SignUpController implements Initializable {

    @FXML
     private TextField cin;
     @FXML
     private TextField adresse;
     @FXML
     private TextField username;
    
     @FXML
     private PasswordField pwd;

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {
          // TODO
     }

     @FXML
     private void Signup(ActionEvent event) {
          if (username.getText().isEmpty()
                  | pwd.getText().isEmpty()
                  | adresse.getText().isEmpty()
                  | cin.getText().isEmpty()) {

               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Travel Me :: Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Entrer all blank fields !!");
               alert.showAndWait();

          } else {
               
               int cin1 = Integer.parseInt(cin.getText());
               User u = new User(cin1, username.getText(), adresse.getText(), pwd.getText() );
             UserServices us = new UserServices();
               us.ajouter(u);
               
               System.out.println("ajout avec succee");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("MyDictionary :: BIENVENNUE");
               alert.setHeaderText(null);
               alert.setContentText("Thanks for registering !!");
               alert.showAndWait();
          }
     }

     @FXML
     private void Retour(ActionEvent event) {
     }

     
}
