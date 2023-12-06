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
import mydictionary.Entities.DictionnaireF;
import mydictionary.tools.MyConnection;

/**
 *
 * @author ZOLDYCK
 */
public class FrDictionaryServices {

     Connection cnx;

     /**
      *
      */
     public FrDictionaryServices() {
          cnx = MyConnection.getInstance().getCnx();
     }

     public boolean isWord(String input) {
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

    

     public void ajouter(DictionnaireF df) {
          String sql = "INSERT INTO dictionnairef VALUES(?,?,?,?,?)";
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
               System.out.println("Traduction fr ajouté");

          } catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }
     }

     public void Supprimer(String word) {
          String sql = "DELETE FROM dictionnairef where mot=?";
          try {
               //  
               PreparedStatement ste = cnx.prepareStatement(sql);
               ste.setString(1, word);

               cnx.prepareStatement(sql);
               ste.executeUpdate();
               System.out.println("Supprimé FR ");

          } catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }

     }

     public ObservableList<DictionnaireA> ShowF() {
          ObservableList<DictionnaireA> list = FXCollections.observableArrayList();
          try {
               String requete = "SELECT * FROM dictionnairef ";
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
          String sql = "UPDATE dictionnaireF SET type = ?, traduction = ?, exemple1 =?, exemple2 =? WHERE mot = ?";
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
               System.out.println("Modifier FR ");

          } catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }
     }
     public boolean isEnglishWord(String input) {
          boolean test = false;
          int count = 0;
          String req = "select count(*) from dictionnaireF where mot= ?;";
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

     public String showFrench(String word) {
          FrDictionaryServices fds = new FrDictionaryServices();

          if (isEnglishWord(word)) {

               String req = "select type,traduction,exemple1,exemple2 from dictionnaireF where mot=?  ;";
               try {

                    PreparedStatement ste = cnx.prepareStatement(req);
                    ste.setString(1, word);

                    ResultSet rs = ste.executeQuery();
                    while (rs.next()) {
                         DictionnaireF DicF = new DictionnaireF(rs.getString("type"), rs.getString("traduction"), rs.getString("exemple1"), rs.getString("exemple2"));
                         return DicF.toString();
                    }

               } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
               }

          } 
          return "";
     }
     
     
     
     
      public Map<String, String> getFrenchMap() {
    Map<String, String> frenchWords = new HashMap<>();
    String req = "SELECT mot, traduction FROM dictionnaireF";
    try {
        PreparedStatement ste = cnx.prepareStatement(req);
        ResultSet rs = ste.executeQuery();
        while (rs.next()) {
            String mot = rs.getString("mot");
            String traduction = rs.getString("traduction");
            frenchWords.put(mot, traduction);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return frenchWords;
}
     

}
