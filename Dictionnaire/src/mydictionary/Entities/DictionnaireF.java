/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.Entities;

/**
 *
 * @author ZOLDYCK
 */
public class DictionnaireF {
     String mot;
     String type;
     String traduction;
     String exemple1;
     String exemple2;

     public DictionnaireF(String mot, String type, String traduction, String exemple1, String exemple2) {
          this.mot = mot;
          this.type = type;
          this.traduction = traduction;
          this.exemple1 = exemple1;
          this.exemple2 = exemple2;
     }

     public DictionnaireF(String type, String traduction, String exemple1, String exemple2) {
          this.type = type;
          this.traduction = traduction;
          this.exemple1 = exemple1;
          this.exemple2 = exemple2;
     }

    

     public String getMot() {
          return mot;
     }

     public String getType() {
          return type;
     }

     public String getTraduction() {
          return traduction;
     }

     public String getExemple1() {
          return exemple1;
     }

     public String getExemple2() {
          return exemple2;
     }

     public void setMot(String mot) {
          this.mot = mot;
     }

     public void setType(String type) {
          this.type = type;
     }

     public void setTraduction(String traduction) {
          this.traduction = traduction;
     }

     public void setExemple1(String exemple1) {
          this.exemple1 = exemple1;
     }

     public void setExemple2(String exemple2) {
          this.exemple2 = exemple2;
     }

     @Override
     public String toString() {
          return " type:" + type + ", traduction:" + traduction + ", Exemple :<< " + exemple1 + ">>  -  <<" + exemple2 + ">>";
     }

     
}
