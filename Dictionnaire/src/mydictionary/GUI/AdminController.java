/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.GUI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mydictionary.Entities.DictionnaireA;
import mydictionary.Entities.DictionnaireF;
import mydictionary.Entities.Traduction;
import mydictionary.Services.EnDictionaryServices;
import mydictionary.Services.ExportService;
import mydictionary.Services.FrDictionaryServices;
import mydictionary.Services.ImportService;

/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class AdminController implements Initializable {

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
     private Button Cancelbtn;
     @FXML
     private Button Addbtnn;
     @FXML
     private Button Modifybtn;
     @FXML
     private Button back;
     @FXML
     private Button Importbtn;
     @FXML
     private Button Exportbtn;

     /**
      * Initializes the controller class.
      */
     @Override
     public void initialize(URL url, ResourceBundle rb) {

          tabc.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, selectedWord) -> {
               if (selectedWord != null) {
                    WordFieldd.setText(selectedWord.getMot());
                    TypeField.setText(selectedWord.getType());
                    TranslatedField.setText(selectedWord.getTraduction());
                    Example1Field.setText(selectedWord.getExemple1());
                    Example2Field.setText(selectedWord.getExemple2());
               }
          });

          DictionnaireA selectedWord = tabc.getSelectionModel().getSelectedItem();
          if (selectedWord != null) {
               WordFieldd.setText(selectedWord.getMot());
               TypeField.setText(selectedWord.getType());
               TranslatedField.setText(selectedWord.getTraduction());
               Example1Field.setText(selectedWord.getExemple1());
               Example2Field.setText(selectedWord.getExemple2());
          }

     }

     @FXML
     private void getCategorie(MouseEvent event) {
     }

     @FXML
     private void Delete(ActionEvent event) {
          DictionnaireA selectedWord = tabc.getSelectionModel().getSelectedItem();
          if ("FR".equals(currentLanguage)) {
               if (selectedWord == null) {
                    // Show an error message if no row is selected
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Veuillez sélectionner une mot à supprimer !");
                    alert.showAndWait();
                    return;
               }

               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setContentText("Voulez-vous vraiment supprimer le mot sélectionné ?");
               Optional<ButtonType> result = alert.showAndWait();
               if (result.isPresent() && result.get() == ButtonType.OK) {
                    FrDictionaryServices cs = new FrDictionaryServices();
                    tabc.getItems().forEach(System.out::println);
                    cs.Supprimer(selectedWord.getMot());
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setContentText("Mot supprimé!");
                    alert2.showAndWait();
               }

          } else {
               if (selectedWord == null) {
                    // Show an error message if no row is selected
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Select a word to delete!");
                    alert.showAndWait();
                    return;
               }

               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setContentText("confirm deleting this word");
               Optional<ButtonType> result = alert.showAndWait();
               if (result.isPresent() && result.get() == ButtonType.OK) {
                    EnDictionaryServices cs = new EnDictionaryServices();
                    tabc.getItems().forEach(System.out::println);
                    cs.Supprimer(selectedWord.getMot());
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setContentText("Word deleted!");
                    alert2.showAndWait();
               }

          }

          UpdateTable();
     }

     @FXML
     private void Add(ActionEvent event) {

          if ("FR".equals(currentLanguage)) {
               if (WordFieldd.getText().isEmpty() || TypeField.getText().isEmpty() || TranslatedField.getText().isEmpty() || Example1Field.getText().isEmpty() || Example2Field.getText().isEmpty()) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setContentText("Veuillez remplir tous les champs!");
                    alert1.showAndWait();
                    return;
               }
               FrDictionaryServices fds = new FrDictionaryServices();
               DictionnaireF df = new DictionnaireF(WordFieldd.getText(), TypeField.getText(), TranslatedField.getText(), Example1Field.getText(), Example2Field.getText());
               fds.ajouter(df);
               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
               alert1.setContentText("Mot ajouté");
               alert1.showAndWait();
               UpdateTable();
          } else {
               if (WordFieldd.getText().isEmpty() || TypeField.getText().isEmpty() || TranslatedField.getText().isEmpty() || Example1Field.getText().isEmpty() || Example2Field.getText().isEmpty()) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setContentText("Fill All the blanks");
                    alert1.showAndWait();
                    return;
               }
               EnDictionaryServices fds = new EnDictionaryServices();
               DictionnaireA de = new DictionnaireA(WordFieldd.getText(), TypeField.getText(), TranslatedField.getText(), Example1Field.getText(), Example2Field.getText());
               de.setExemple2(Example2Field.getText());
               System.out.println(de);
               fds.ajouter(de);
               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
               alert1.setContentText("Word Added");
               alert1.showAndWait();
               UpdateTable();

          }
     }

     void ConvertLanguage(String Language) {
          if (Language.equals("FR")) {
               Title.setText("Gestion de dictionnaire");
               WordFieldd.setPromptText("Donner le mot en anglais");
               TypeField.setPromptText("Donnez le type de mot");
               TranslatedField.setPromptText("Donner le mot traduit en français!");
               Example1Field.setPromptText("Donner un exemple de mot en français");
               Example2Field.setPromptText("Donner un exemple de mot en anglais");
               Addbtnn.setText("Ajouter");
               Modifybtn.setText("Modifier");
               Deletebtn.setText("Supprimer");
               Word.setCellValueFactory(new PropertyValueFactory<>("mot"));
               Type.setCellValueFactory(new PropertyValueFactory<>("type"));
               Translated.setCellValueFactory(new PropertyValueFactory<>("traduction"));
               Example1.setCellValueFactory(new PropertyValueFactory<>("exemple1"));
               Example2.setCellValueFactory(new PropertyValueFactory<>("exemple2"));
               FrDictionaryServices cs = new FrDictionaryServices();
               List<DictionnaireA> c = cs.ShowF();
               ObservableList<DictionnaireA> list = FXCollections.observableArrayList(c);

               tabc.setItems(list);
               currentLanguage = "FR";
          } else {
               Title.setText("Dictionnary Management");
               WordFieldd.setPromptText("Enter the word in French");
               TypeField.setPromptText("Enter the type of the word");
               TranslatedField.setPromptText("Enter the word translated in English");
               Example1Field.setPromptText("Enter an example in English");
               Example2Field.setPromptText("Enter an example in french");
               Addbtnn.setText("Add");
               Modifybtn.setText("Modify");
               Deletebtn.setText("Delete");
               Word.setCellValueFactory(new PropertyValueFactory<>("mot"));
               Type.setCellValueFactory(new PropertyValueFactory<>("type"));
               Translated.setCellValueFactory(new PropertyValueFactory<>("traduction"));
               Example1.setCellValueFactory(new PropertyValueFactory<>("exemple1"));
               Example2.setCellValueFactory(new PropertyValueFactory<>("exemple2"));
               EnDictionaryServices fds = new EnDictionaryServices();
               List<DictionnaireA> f = fds.ShowA();
               ObservableList<DictionnaireA> list = FXCollections.observableArrayList(f);

               tabc.setItems(list);

          }
     }

     private void UpdateTable() {
          System.out.println(currentLanguage);
          if ("FR".equals(currentLanguage)) {
               Word.setCellValueFactory(new PropertyValueFactory<>("mot"));
               Type.setCellValueFactory(new PropertyValueFactory<>("type"));
               Translated.setCellValueFactory(new PropertyValueFactory<>("traduction"));
               Example1.setCellValueFactory(new PropertyValueFactory<>("exemple1"));
               Example2.setCellValueFactory(new PropertyValueFactory<>("exemple2"));
               FrDictionaryServices fds = new FrDictionaryServices();
               List<DictionnaireA> f = fds.ShowF();
               ObservableList<DictionnaireA> list = FXCollections.observableArrayList(f);

               tabc.setItems(list);
          } else {
               Word.setCellValueFactory(new PropertyValueFactory<>("mot"));
               Type.setCellValueFactory(new PropertyValueFactory<>("type"));
               Translated.setCellValueFactory(new PropertyValueFactory<>("traduction"));
               Example1.setCellValueFactory(new PropertyValueFactory<>("exemple1"));
               Example2.setCellValueFactory(new PropertyValueFactory<>("exemple2"));
               EnDictionaryServices fds = new EnDictionaryServices();
               List<DictionnaireA> f = fds.ShowA();
               ObservableList<DictionnaireA> list = FXCollections.observableArrayList(f);

               tabc.setItems(list);
          }
     }

     @FXML
     private void Modify(ActionEvent event) {

          tabc.getItems().forEach((da) -> {
               System.out.println(da.getMot() + WordFieldd.getText());
               if ("FR".equals(currentLanguage)) {
                    if (WordFieldd.getText().equals(da.getMot())) {
                         DictionnaireA de = new DictionnaireA(WordFieldd.getText(), TypeField.getText(), TranslatedField.getText(), Example1Field.getText(), Example2Field.getText());
                         FrDictionaryServices fds = new FrDictionaryServices();
                         System.out.println(de);
                         fds.Modifier(de);
                         Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                         alert1.setContentText("Mot Modifié");
                         alert1.showAndWait();
                         UpdateTable();
                         
                    }
                 else {
                    if (WordFieldd.getText().equals(da.getMot())) {
                         DictionnaireA de = new DictionnaireA(WordFieldd.getText(), TypeField.getText(), TranslatedField.getText(), Example1Field.getText(), Example2Field.getText());
                         EnDictionaryServices eds = new EnDictionaryServices();
                         eds.Modifier(de);
                         Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                         alert1.setContentText("Word Modified!");
                         alert1.showAndWait();
                         UpdateTable();
                         
                    }
                   
                    }
               }
          });
 

     }

     @FXML
     private void Retour(ActionEvent event) {
          HomePagOnAction();
          
     }
     public void HomePagOnAction() {
          try {
               Stage stage = (Stage) back.getScene().getWindow();
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
    
    
   private String getFile(Stage primaryStage) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("CSV Files", "*.csv")
    );
    File selectedFile = fileChooser.showOpenDialog(primaryStage);
    if (selectedFile != null) {
        return selectedFile.getAbsolutePath();
    }
    return null;
}


     @FXML
     private void Import(ActionEvent event) {
          ImportService IS = new ImportService();
            String filePath = getFile((Stage) ((Node) event.getSource()).getScene().getWindow());
    if (filePath != null && !filePath.isEmpty()) {
               try {
                    IS.importFromFile(filePath);
                     if ("FR".equals(currentLanguage)) {
                    FrDictionaryServices cs = new FrDictionaryServices();
               List<DictionnaireA> c = cs.ShowF();
               ObservableList<DictionnaireA> list = FXCollections.observableArrayList(c);
               tabc.setItems(list); 
               currentLanguage = "FR";
               
                     }  
                     else 
                     { EnDictionaryServices fds = new EnDictionaryServices();
               List<DictionnaireA> f = fds.ShowA();
               ObservableList<DictionnaireA> list = FXCollections.observableArrayList(f);

               tabc.setItems(list);}
                     // ...
               } catch (SQLException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
               }
} else {
    Alert alert = new Alert(Alert.AlertType.ERROR, "No file selected.");
    alert.showAndWait();
}
    
                
     }

     @FXML
     private void Export(ActionEvent event) throws SQLException {
          String filePath = "C:\\Users\\ZOLDYCK\\OneDrive\\Documents\\NetBeansProjects\\Dictionnaire\\src\\files\\export.txt";


File file = new File(filePath);
if (file.exists()) {
    file.delete();
}
ExportService ES = new ExportService();

List<Traduction> translations;
translations = ES.getAllTranslationsFromDatabase();



try (FileWriter writer = new FileWriter(file)) {
   
    for (Traduction t : translations) {
        // Concaténer les attributs de l'objet en une ligne de texte avec des virgules comme séparateurs
        String line = t.getMot() + ", " + t.getTraduction() + ", " + t.getType() + ", " + t.getExemple1()+ ", " + t.getExemple2();

       
        writer.write(line + "\n");
    }
}
catch (IOException e) {
    e.printStackTrace();
}

// Afficher un message de succès
Alert alert = new Alert(Alert.AlertType.INFORMATION, "Les traductions ont été exportées avec succès !");
alert.showAndWait();
     }
     
     
     
     

    
}
