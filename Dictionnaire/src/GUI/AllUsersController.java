/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mydictionary.Entities.DictionnaireA;
import mydictionary.Entities.DictionnaireF;
import mydictionary.Services.EnDictionaryServices;
import mydictionary.Services.FrDictionaryServices;

/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class AllUsersController implements Initializable {

     @FXML
     private Label Title;
     @FXML
     private TableView<DictionnaireA> tabc;
     @FXML
     private TableColumn<DictionnaireA, String> Word;
     @FXML
     private TableColumn<DictionnaireA, String> Type;
     @FXML
     private TableColumn<DictionnaireA, String> Translated;
     @FXML
     private TableColumn<DictionnaireA, String> Example1;
     @FXML
     private TableColumn<DictionnaireA, String> Example2;
     @FXML
     private TextField TypeField;
     @FXML
     private TextField TranslatedField;
     @FXML
     private TextField Example1Field;
     @FXML
     private TextField Example2Field;
     @FXML
     private TextField WordFieldd;
     String currentLanguage;
     @FXML
     private Button Deletebtn;
     @FXML
     private Button Cancelbtn;
     @FXML
     private Button Addbtnn;

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {
       
          //Example1.cellValueFactoryProperty()
     }

     @FXML
     private void getCategorie(MouseEvent event) {
          
          
     }

     @FXML
     private void Delete(ActionEvent event) {
          
     }

     @FXML
     private void verify(ActionEvent event) {
          if ("FR".equals(currentLanguage)){
               FrDictionaryServices fds = new FrDictionaryServices();
               DictionnaireF df = new DictionnaireF(WordFieldd.getText(), TypeField.getText(), TranslatedField.getText(), Example1Field.getText(), Example2Field.getText());
               fds.ajouter(df);
          }
          else {
               
               EnDictionaryServices fds = new EnDictionaryServices();
               DictionnaireA de = new DictionnaireA(WordFieldd.getText(), TypeField.getText(), TranslatedField.getText(), Example1Field.getText(), Example2Field.getText());
               fds.ajouter(de);
               
               
          }
     }

     @FXML
     private void Cancel(ActionEvent event) {
          
     }

     void ConvertLanguage(String Language) {
          if (Language.equals("FR")) {
               WordFieldd.setPromptText("Donner le mot en français");
               TypeField.setPromptText("Donnez le type de mot");
               TranslatedField.setPromptText("Donner le mot en anglais!");
               Example1Field.setPromptText("Donner un exemple de mot en français");
               Example2Field.setPromptText("Donner un exemple de mot en anglais");
               Addbtnn.setText("Add");
               Cancelbtn.setText("Cancel");
               Deletebtn.setText("Delete");
               currentLanguage = "FR";
          } else {
               WordFieldd.setPromptText("Enter the word in English");
               TypeField.setPromptText("Enter the type of the word");
               TranslatedField.setPromptText("Enter the word in French");
               Example1Field.setPromptText("Enter an example in English");
               Example2Field.setPromptText("Enter an example in french");
               Addbtnn.setText("Ajouter");
               Cancelbtn.setText("Annuler");
               Deletebtn.setText("Supprimer");

          }
     }

}
