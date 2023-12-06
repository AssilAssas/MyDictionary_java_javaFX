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
public class Traduction {
     private String mot ;
     private String type;
     private String traduction;
     private String exemple1;
     private String exemple2;
     
     
    public Traduction(String mot, String type, String traduction, String exemple1, String exemple2) {
          this.mot = mot;
          this.type = type;
          this.traduction = traduction;
          this.exemple1 = exemple1;
          this.exemple2 = exemple2;
     }
    
   public Traduction (){
   }

     public String getMot() {
          return mot;
     }

     public void setMot(String mot) {
          this.mot = mot;
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public String getTraduction() {
          return traduction;
     }

     public void setTraduction(String traduction) {
          this.traduction = traduction;
     }

     public String getExemple1() {
          return exemple1;
     }

     public void setExemple1(String exemple1) {
          this.exemple1 = exemple1;
     }

     public String getExemple2() {
          return exemple2;
     }

     public void setExemple2(String exemple2) {
          this.exemple2 = exemple2;
     }
   
     
     
     
}
