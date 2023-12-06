/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import mydictionary.Entities.DictionnaireA;
import mydictionary.tools.MyConnection;

/**
 *
 * @author ZOLDYCK
 */
public class EnDictionaryServices {

     Connection cnx;

     /**
      *
      */
     public EnDictionaryServices() {
          cnx = MyConnection.getInstance().getCnx();
     }

     public static boolean isWord(String input) {
          if (input == null || input.isEmpty()) {
               // Empty or null strings are not words
               return false;
          }
          for (int i = 0; i < input.length(); i++) {
               char c = input.charAt(i);
               if (!Character.isLetter(c)) {
                    // The string contains a non-letter character, so it's not a word
                    return false;
               }
          }
          return true;
     }

      public boolean isFrenchWord(String input) {
          boolean test = false;
          int count = 0;
          String req = "select count(*) from dictionnaireA where mot= ?;";
          try {
               PreparedStatement ste = cnx.prepareStatement(req);
               ste.setString(1, input);

               ResultSet rs = ste.executeQuery();
               if (rs.next()) {
                    count = rs.getInt(1);
               }
               if (count == 1) {
                    test = true;
               } else {
                    test = false;
               }

          } catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }

          return test;
     }

     public void ajouter(DictionnaireA df) {
          String sql = "INSERT INTO dictionnairea VALUES(?,?,?,?,?)";
          try {
               //  
               PreparedStatement ste = cnx.prepareStatement(sql);
               ste.setString(1, df.getMot());
               ste.setString(2, df.getType());
               ste.setString(3, df.getTraduction());
               ste.setString(4, df.getExemple1());
               ste.setString(5, df.getExemple2());

               cnx.prepareStatement(sql);
               ste.executeUpdate();
               System.out.println("Traduction EN ajouté");

          } catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }
     }

     public void Supprimer(String word) {
          String sql = "DELETE FROM dictionnairea where mot=?";
          try {
               //  
               PreparedStatement ste = cnx.prepareStatement(sql);
               ste.setString(1, word);

               cnx.prepareStatement(sql);
               ste.executeUpdate();
               System.out.println("Supprimé EN ");

          } catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }
     }

     public ObservableList<DictionnaireA> ShowA() {
          ObservableList<DictionnaireA> list = FXCollections.observableArrayList();
          try {
               String requete = "SELECT * FROM dictionnaireA ";
               PreparedStatement pst = cnx.prepareStatement(requete);
               ResultSet rs = pst.executeQuery();
               while (rs.next()) {
                    list.add(new DictionnaireA(rs.getString("mot"), rs.getString("type"), rs.getString("traduction"), rs.getString("exemple1"), rs.getString("exemple2")));
               }

          } catch (SQLException ex) {
               ex.getMessage();
          }
          return list;
     }

     public void Modifier(DictionnaireA da) {
          String sql = "UPDATE dictionnaireA SET type = ?, traduction = ?, exemple1 =?, exemple2 =? WHERE mot = ?";
          try {
               //  
               PreparedStatement ste = cnx.prepareStatement(sql);
               ste.setString(1, da.getType());
               ste.setString(2, da.getTraduction());
               ste.setString(3, da.getExemple1());
               ste.setString(4, da.getExemple2());
               ste.setString(5, da.getMot());

               cnx.prepareStatement(sql);
               ste.executeUpdate();
               System.out.println("Modifier EN ");

          } catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }
     }

     public String showEnglish(String word) {
               
          if (isFrenchWord(word)) {

               String req = "select * from dictionnaireA where mot=? ";
               try {

                    PreparedStatement ste = cnx.prepareStatement(req);
                    ste.setString(1, word);

                    ResultSet rs = ste.executeQuery();
                    while (rs.next()) {
                         DictionnaireA DicA = new DictionnaireA(rs.getString("mot"),rs.getString("type"), rs.getString("traduction"), rs.getString("exemple1"), rs.getString("exemple2"));
                         return DicA.toString();
                    }
                    

               } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
               }
          }
          return "";
     }
    
     
     public Map<String, String> getEnglishMap() {
    Map<String, String> englishWords = new HashMap<>();
    String req = "SELECT mot, traduction FROM dictionnaireA";
    try {
        PreparedStatement ste = cnx.prepareStatement(req);
        ResultSet rs = ste.executeQuery();
        while (rs.next()) {
            String mot = rs.getString("mot");
            String traduction = rs.getString("traduction");
            englishWords.put(mot, traduction);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return englishWords;
}


}
