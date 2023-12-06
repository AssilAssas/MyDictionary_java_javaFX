/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionnaire;

import mydictionary.Entities.DictionnaireA;
import mydictionary.Entities.DictionnaireF;
import mydictionary.Entities.User;
import mydictionary.Services.EnDictionaryServices;
import mydictionary.Services.FrDictionaryServices;
import mydictionary.Services.UserServices;

/**
 *
 * @author ZOLDYCK
 */
public class Dictionnaire {

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {
          User u = new User(0, 0, "Assil2", "", "azerty123");
          UserServices us = new UserServices();
          us.Connexion("Assil2", "azerty123");
          
          if(us.Connexion("", "") == null) {
               System.out.println("Inexistant");
          }
          
//          EnDictionaryServices eds = new EnDictionaryServices();
//          System.out.println( eds.isEnglishWord(""));
//          FrDictionaryServices fds = new FrDictionaryServices();
//          System.out.println(fds.isFrenchWord("amité"));
          FrDictionaryServices dictionaryServices = new FrDictionaryServices();
          EnDictionaryServices e = new EnDictionaryServices();
          DictionnaireA da = new DictionnaireA("Friendship", "a", "a", "1", "a");

          
          System.out.println(e.showEnglish("Word"));
      //   e.Modifier(da);
     }
     
}
