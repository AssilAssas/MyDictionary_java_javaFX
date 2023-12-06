/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mydictionary.Entities.Traduction;
import mydictionary.tools.MyConnection;

/**
 *
 * @author ZOLDYCK
 */
public class ExportService {
     
     
      Connection cnx;

     /**
      *
      */
     public ExportService() {
          cnx = MyConnection.getInstance().getCnx();
     }
    
     
     public List<Traduction> getAllTranslationsFromDatabase() throws SQLException {
    List<Traduction> translations = new ArrayList<>();
    try {
        
        String query = "SELECT * FROM dictionnaireA";
        Statement statement = cnx.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Traduction t = new Traduction();
            t.setMot(resultSet.getString(1));
            t.setTraduction(resultSet.getString(2));
            t.setType(resultSet.getString(3));
            t.setExemple1(resultSet.getString(4));
            t.setExemple2(resultSet.getString(5));
            translations.add(t);
        }
        resultSet.close();

        String query1 = "SELECT * FROM DictionnaireF";
        Statement statement1 = cnx.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(query1);
        while (resultSet1.next()) {
            Traduction t = new Traduction();
            t.setMot(resultSet1.getString(1));
            t.setTraduction(resultSet1.getString(2));
            t.setType(resultSet1.getString(3));
            t.setExemple1(resultSet1.getString(4));
            t.setExemple2(resultSet1.getString(5));
            translations.add(t);
        }
        resultSet1.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cnx.close();
    }
    return translations;
}
}
