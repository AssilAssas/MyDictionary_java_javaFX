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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

     /**
      * Initializes the controller class.
      */
      
      @FXML
     private TextField USERNAME ;
     @FXML 
     private Button SignIN;
     @FXML
     private PasswordField PASSWORD ;
     @Override
     public void initialize(URL url, ResourceBundle rb) {
          // TODO
     } 
     public static boolean isEmpty1(String str) {
    return str == null || str.isEmpty();
}
     @FXML
      private void SignIn(ActionEvent event)  {
           UserServices ob = new UserServices();
           User u = new User("","");
           u.setUserName(USERNAME.getText());
           u.setPassword(PASSWORD.getText());
           
           
//          try {
//           if (isEmpty1(USERNAME.getText()) ||isEmpty1( PASSWORD.getText()))
//         
//                   {
//                        System.out.println("honiiiiiiiiiiiiiii");
//
//               Alert alert = new Alert(Alert.AlertType.ERROR);
//               alert.setTitle("Travel Me :: Error Message");
//               alert.setHeaderText(null);
//               alert.setContentText("Entrer all blank fields !!");
//               alert.showAndWait();
//      
//      }
//           else {
//               
//               User u = new User("","");
//                if (USERNAME.getText()!= null)
//             u.setUserName(USERNAME.getText());
//                
//                if (PASSWORD.getText()!= null )
//                 u.setPassword(PASSWORD.getText());
//                
//                    
////                u.setUserName(u.getUserName());
////                u.setPassword(u.getPassword());
//                
//                UserServices ob = new UserServices();
//               if (ob.verifUser(u)){
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//               alert.setTitle("MyDictionary :: BIENVENNUE");
//               alert.setHeaderText(null);
//               alert.setContentText("Logged In!!");
//               alert.showAndWait();
//                    
//                    
//               }
//               else {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//               alert.setTitle("MyDictionary :: ERROR MESSAGE");
//               alert.setHeaderText(null);
//               alert.setContentText("INVALID LOGIN !!");
//               alert.showAndWait();
//               }
//         }}
//           catch (NullPointerException e){
//                
//                System.out.println("EXCEPTION");
                //   }
              
                if (ob.verifUser(u))
                {
                     
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("MyDictionary :: BIENVENNUE");
               alert.setHeaderText(null);
               alert.setContentText("Logged In!!");
               alert.showAndWait();
                }
                else {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("MyDictionary :: ERROR MESSAGE");
               alert.setHeaderText(null);
               alert.setContentText("INVALID LOGIN !!");
               alert.showAndWait();
                }
}
   public void LoginPagOnAction(){
        try{
            Stage stage =(Stage) SignIN.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 520,420));
            registerStage.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }   
     
}
