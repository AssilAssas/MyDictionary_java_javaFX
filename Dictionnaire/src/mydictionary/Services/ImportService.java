/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import mydictionary.tools.MyConnection;

/**
 *
 * @author ZOLDYCK
 */
public class ImportService {
     
      Connection cnx;

     /**
      *
      */
     public ImportService() {
          cnx = MyConnection.getInstance().getCnx();
     }
      public void importFromFile(String filePath) throws  SQLException {
//           String    FilePath= "C:\\Users\\ZOLDYCK\\OneDrive\\Documents\\NetBeansProjects\\Dictionnaire\\src\\files\\import.txt";
             if (!new File(filePath).exists()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Le fichier spécifié n'existe pas !");
            alert.showAndWait();
            return;
        }
               // Lire le fichier de traductions
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Diviser la ligne en attributs séparés par des virgules
                String[] attributes = line.split(",");
                String motL1 = attributes[0].trim();
                String motL2 = "";
                String type = "";
                String expl1 = "";
                String expl2 = "";
                String lang = "";

                if (attributes.length > 1) {
                    motL2 = attributes[1].trim();
                }

                if (attributes.length > 2) {
                    type = attributes[2].trim();
                }

                if (attributes.length > 3) {
                    expl1 = attributes[3].trim();
                }

                if (attributes.length > 4) {
                    expl2 = attributes[4].trim();
                }

                if (attributes.length > 5) {
                    lang = attributes[5].trim();
                }
             
        String tableName = lang.equals("f") ? "dictionnaireF" : "dictionnaireA";
        String query = "INSERT INTO " + tableName + " (mot, type, traduction, exemple1, exemple2) VALUES (?, ?, ?, ?, ?)";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line1;
            while ((line = reader.readLine()) != null) {
                String[] attributes1 = line.split(",");
                String motL11 = attributes[0].trim();
                String motL22 = attributes.length > 1 ? attributes[1].trim() : "";
                String type1 = attributes.length > 2 ? attributes[2].trim() : "";
                String expl11 = attributes.length > 3 ? attributes[3].trim() : "";
                String expl22 = attributes.length > 4 ? attributes[4].trim() : "";
                
                try (PreparedStatement statement = cnx.prepareStatement(query)) {
                    statement.setString(1, motL1);
                    statement.setString(2, type);
                    statement.setString(3, motL2);
                    statement.setString(4, expl1);
                    statement.setString(5, expl2);
                    statement.executeUpdate();
                    
                }
            }
        }}} catch (IOException ex) {
                Logger.getLogger(ImportService.class.getName()).log(Level.SEVERE, null, ex);
           }}}






