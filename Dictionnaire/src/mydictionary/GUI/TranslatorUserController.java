/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.GUI;
//import com.itextpdf.io.font.woff2.Woff2Common.Table;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
//import com.itextpdf.styledxmlparser.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.reflect.Array.set;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import org.controlsfx.control.textfield.AutoCompletionBinding;
//import org.controlsfx.control.textfield.TextFields;


	
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import com.controlsfx.control.textfield;
//import com.controlsfx.control.textfield.TextFields;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mydictionary.Services.EnDictionaryServices;
import mydictionary.Services.FrDictionaryServices;


/**
 * FXML Controller class
 *
 * @author ZOLDYCK
 */
public class TranslatorUserController implements Initializable {

     @FXML
     private Button TransEnglish;
     @FXML
     private TextField mot;
     @FXML
     private TextArea textShow;
     @FXML
     private Button back;
     @FXML
     private Button TransFrench1;
     @FXML
     private Button Printbtn;
     @FXML
     private Button PrintAllbtn;
     @FXML
     private Button PrintAllbtn1;

     /**
      * Initializes the controller class.
      */
    
    private String[] words; // array of words from database
    
//    @Override
//    public void initialize(URL url, ResourceBundle rb)  {
//         
//           try {
//        List<String> suggestions = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
//
//        mot.setOnKeyReleased(event -> {
//            try {
//                String searchText = mot.getText().toLowerCase();
//                List<String> filteredSuggestions = suggestions.stream()
//                        .filter(suggestion -> suggestion.startsWith(searchText))
//                        .collect(Collectors.toList());
//                ComboBox<String> suggestionList = new ComboBox<>(FXCollections.observableList(filteredSuggestions));
//                suggestionList.setOnMouseClicked(event1 -> {
//                    mot.setText(suggestionList.getSelectionModel().getSelectedItem());
//                    suggestionList.setVisible(false);
//                });
//                suggestionList.setPrefWidth(mot.getWidth());
//                suggestionList.setVisible(filteredSuggestions.size() > 0);
//                suggestionList.setManaged(filteredSuggestions.size() > 0);
//                suggestionList.relocate(mot.getLayoutX(), mot.getLayoutY() + mot.getHeight());
//                mot.getParent().getChildrenUnmodifiable().add(suggestionList);
//            } catch (Exception e) {
//                e.getMessage();
//            }
//        });
//    } catch (Exception e) {
//        e.getMessage();
//    }
//    }
    @Override
public void initialize(URL url, ResourceBundle rb)  {
  
}

         
        // TODO
        
        // Initialize the array of words from your database
//        words = getWordsFromDatabase(); // replace with your code
//        
//        // Create an autocomplete binding for the "mot" text field
//       AutoCompletionBinding<String> autoComplete = TextFields.bindAutoCompletion(mot, words);
//        autoComplete.setDelay(500);  //set a delay before showing suggestions
    
//     private String[] getWordsFromDatabase() {
//        // Replace with your code to fetch the words from the database
//        return new String[] { "apple", "banana", "cherry", "date", "elderberry" };
//    }

     @FXML
     private void translateEnglish(ActionEvent event) {
          
          EnDictionaryServices eds = new EnDictionaryServices();
          FrDictionaryServices fds = new FrDictionaryServices();
          if (eds.isFrenchWord(mot.getText()))
          textShow.setText(eds.showEnglish(mot.getText()));
            
         else if (fds.isEnglishWord(mot.getText()))
          textShow.setText(fds.showFrench(mot.getText()));
          else {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Travel Me :: Error Message");
               alert.setHeaderText(null);
               alert.setContentText("The word is invalid !!");
               alert.showAndWait();
          }}
     

     @FXML
     private void translateFrench(ActionEvent event) {
        String input="";
        input = textShow.getText();
        String Traduction="";
        EnDictionaryServices eds = new EnDictionaryServices();
        FrDictionaryServices fds = new FrDictionaryServices();

        if(input!=null ) { 
            Alert alert4 = new Alert(Alert.AlertType.ERROR);
            Traduction= getTraduction(input);
            alert4.setContentText(Traduction);
             
          if (eds.isFrenchWord(Traduction)){
          mot.setText(Traduction);
          textShow.setText(eds.showEnglish(Traduction));}
            
         else if (fds.isEnglishWord(Traduction)){
                  mot.setText(Traduction);
          textShow.setText(fds.showFrench(Traduction));}
            
            
        }
        else {
              Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Travel Me :: Error Message");
               alert.setHeaderText(null);
               alert.setContentText("The word is invalid !!");
               alert.showAndWait();
        }
                  
          
     }
     

     @FXML
     private void Retour(ActionEvent event) {
          HomePagOnAction();
     }
     public void HomePagOnAction() {
          try {
               Stage stage = (Stage) back.getScene().getWindow();
               stage.close();
               Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
               Stage registerStage = new Stage();
               registerStage.initStyle(StageStyle.UNDECORATED);
               registerStage.setScene(new Scene(root, 1000, 600));
               registerStage.show();

          } catch (Exception e) {
               e.printStackTrace();
               e.getCause();
          }

     }
public String  getTraduction(String input)  { // "type:nom,traduction:amitié
     String[] parts = input.split(",");

String translation = "";

// Loop through the parts to find the "traduction" value
for (String part : parts) {
    String[] keyValue = part.split(":");
    if (keyValue[0].equals(" traduction")) {
        translation = keyValue[1];
    }
}

if (translation != null) {
    return translation;
} else {
    return  null;
}}

     @FXML
     private void printWord(ActionEvent event) {
          
        String input="";
        input = mot.getText();
        if ((input.isEmpty())== false )
        {    
             createPDFFromWord(input);   
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Travel Me :: Succes");
               alert.setHeaderText(null);
               alert.setContentText("Your File is ready to Print ");
               alert.showAndWait();}
        else 
        {  Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Travel Me :: Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Please type the word to print its translation!!");
               alert.showAndWait();
        }
     }

     @FXML
     private void printFrench(ActionEvent event) {
      createPDFFromFrenchToEnglish();
              
          
     }

     @FXML
     private void printEnglish(ActionEvent event) {
        //  createPDFFromTableView();
         
              
     }
     
     
//    public static void generatePdf(Map<String, String> dictionary) {
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream("dictionary.pdf"));
//            document.open();
//            
//             for (String word : dictionary.keySet()) {
//                String translation = dictionary.get(word);
//                Paragraph p = new Paragraph(word + ": " + translation);
//                do  cument.add(p);
//            }
//            
//            document.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//     public void createPDFFromTableView() throws SQLException, FileNotFoundException, IOException {
//
//        try {
//            // Choose the output file for the PDF
//            File outputFile = new File("output.pdf");
//
//            // Create the PDF writer
//            PdfWriter writer = new PdfWriter(new FileOutputStream(outputFile));
//
//            // Create the PDF document
//            PdfDocument pdf = new PdfDocument(writer);
//            PageSize pageSize = PageSize.A4;
//            Document document = new Document(pdf, pageSize);
//
//            // Add a header to the PDF document
//
//
//            // Create the table to hold the data
//            Table table = new Table(2);
//            table.setWidth(UnitValue.createPercentValue(100));
//
//            // Set the table headers
//            
//                Cell headerCell = new Cell()
//                        .add(new Paragraph("Mot")
//                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
//                        .setBorder(new SolidBorder(1))
//                        .setBackgroundColor(ColorConstants.LIGHT_GRAY);
//                table.addHeaderCell(headerCell);
//                
//                Cell headerCell1 = new Cell()
//                        .add(new Paragraph("Traduction")
//                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
//                        .setBorder(new SolidBorder(1))
//                        .setBackgroundColor(ColorConstants.LIGHT_GRAY);
//                table.addHeaderCell(headerCell1);
//              
//              Map<String, String> englishWords = new HashMap<>();
//              EnDictionaryServices eds = new EnDictionaryServices();
//              englishWords=eds.getEnglishMap();
//
//            // Add the data rows to the table
//         
//            for (String item : englishWords) {
//                for (TableColumn<Commande, ?> column : tableView.getColumns()) {
//                    String cellData = getValue(column, item);
//                    Cell dataCell = new Cell().add(new Paragraph(cellData));
//                    table.addCell(dataCell);
//                }
//            }
//
//            // Add the table to the PDF document
//            document.add(table);
//
//            // Close the PDF document
//            document.close();
//
//            System.out.println("PDF file created successfully!");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException ex) {
//            Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
     
     
     
     public void createPDFFromWord(String input) {
    try {
        // Choose the output file for the PDF
        File outputFile = new File("PrintWord.pdf");

        // Create the PDF writer
        PdfWriter writer = new PdfWriter(new FileOutputStream(outputFile));

        // Create the PDF document
        PdfDocument pdf = new PdfDocument(writer);
        PageSize pageSize = PageSize.A4;
        Document document = new Document(pdf, pageSize);

        // Add a header to the PDF document

        // Create the table to hold the data
        Table table = new Table(2);
        table.setWidth(UnitValue.createPercentValue(100));

        // Set the table headers
        Cell headerCell = new Cell()
                .add(new Paragraph("Mot")
                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
                .setBorder(new SolidBorder(1))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addHeaderCell(headerCell);

        Cell headerCell1 = new Cell()
                .add(new Paragraph("Traduction")
                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
                .setBorder(new SolidBorder(1))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addHeaderCell(headerCell1);

        EnDictionaryServices eds = new EnDictionaryServices();
        FrDictionaryServices fds = new FrDictionaryServices();
       if (eds.isFrenchWord(input)){ 
            // Add the data rows to the table
     String a = eds.showEnglish(input);      
     String traduction = getTraduction(a) ;
     //  traduction = eds.getEnglish(input);
            table.addCell(new Cell().add(new Paragraph(input)));
            table.addCell(new Cell().add(new Paragraph(traduction)));}
      else if (fds.isEnglishWord(input)){
//        
//
String a = fds.showFrench(input);
String traduction = getTraduction(a);
            table.addCell(new Cell().add(new Paragraph(input)));
            table.addCell(new Cell().add(new Paragraph(traduction)));
      }
       else {
            System.out.println("Invalid word");
            return;
       }
        

        // Add the table to the PDF document
        document.add(table);

        // Close the PDF document
        document.close();

        System.out.println("PDF file created successfully!");

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException ex) {
        Logger.getLogger(TranslatorUserController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     public void createPDFFromEnglishToFrench() {
    try {
        // Choose the output file for the PDF
        File outputFile = new File("PrintEnglishWords.pdf");

        // Create the PDF writer
        PdfWriter writer = new PdfWriter(new FileOutputStream(outputFile));

        // Create the PDF document
        PdfDocument pdf = new PdfDocument(writer);
        PageSize pageSize = PageSize.A4;
        Document document = new Document(pdf, pageSize);

        // Add a header to the PDF document

        // Create the table to hold the data
        Table table = new Table(2);
        table.setWidth(UnitValue.createPercentValue(100));

        // Set the table headers
        Cell headerCell = new Cell()
                .add(new Paragraph("Mot")
                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
                .setBorder(new SolidBorder(1))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addHeaderCell(headerCell);

        Cell headerCell1 = new Cell()
                .add(new Paragraph("Traduction")
                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
                .setBorder(new SolidBorder(1))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addHeaderCell(headerCell1);

        Map<String, String> englishWords = new HashMap<>();
        EnDictionaryServices eds = new EnDictionaryServices();
        englishWords = eds.getEnglishMap();

        // Add the data rows to the table
        for (Map.Entry<String, String> entry : englishWords.entrySet()) {
            String frenchWord = entry.getKey();
            String englishWord = entry.getValue();
            table.addCell(new Cell().add(new Paragraph(englishWord)));
            table.addCell(new Cell().add(new Paragraph(frenchWord)));
        }

        // Add the table to the PDF document
        document.add(table);

        // Close the PDF document
        document.close();

        System.out.println("PDF file created successfully!");

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException ex) {
        Logger.getLogger(TranslatorUserController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  
      public void createPDFFromFrenchToEnglish() {
    try {
        // Choose the output file for the PD000F
        File outputFile = new File("PrintFrenchWords.pdf");

        // Create the PDF writer
        PdfWriter writer = new PdfWriter(new FileOutputStream(outputFile));

        // Create the PDF document
        PdfDocument pdf = new PdfDocument(writer);
        PageSize pageSize = PageSize.A4;
        Document document = new Document(pdf, pageSize);

        // Add a header to the PDF document

        // Create the table to hold the data
        Table table = new Table(2);
        table.setWidth(UnitValue.createPercentValue(100));

        // Set the table headers
        Cell headerCell = new Cell()
                .add(new Paragraph("Mot")
                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
                .setBorder(new SolidBorder(1))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addHeaderCell(headerCell);

        Cell headerCell1 = new Cell()
                .add(new Paragraph("Traduction")
                        .setFont(PdfFontFactory.createFont("Helvetica-Bold")))
                .setBorder(new SolidBorder(1))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addHeaderCell(headerCell1);

        Map<String, String> frenchWords = new HashMap<>();
       FrDictionaryServices fds = new FrDictionaryServices();
        frenchWords = fds.getFrenchMap();

        // Add the data rows to the table
        for (Map.Entry<String, String> entry : frenchWords.entrySet()) {
            String frenchWord = entry.getKey();
            String englishWord = entry.getValue();
            table.addCell(new Cell().add(new Paragraph(englishWord)));
            table.addCell(new Cell().add(new Paragraph(frenchWord)));
        }

        // Add the table to the PDF document
        document.add(table);

        // Close the PDF document
        document.close();

        System.out.println("PDF file created successfully!");

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException ex) {
        Logger.getLogger(TranslatorUserController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  

            
    

     }