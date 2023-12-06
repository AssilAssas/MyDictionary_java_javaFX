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
public class User {
     
    private int id;
    private int CIN;
    private String UserName;
    private String Adresse;
    private String Password;
    
     public User(int id, int CIN, String UserName,String Adresse, String Password) {
        this.id = id;
        this.CIN = CIN;
        this.UserName = UserName;
        this.Adresse = Adresse;
        this.Password = Password;
        
    }
      public User( int CIN, String UserName,String Adresse, String Password) {
        
        this.CIN = CIN;
        this.UserName = UserName;
        this.Adresse = Adresse;
        this.Password = Password;
        
    }

     public User(String UserName, String Password) {
          this.UserName = UserName;
          this.Password = Password;
     }

      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

     @Override
     public String toString() {
          return "User{" + "id=" + id + ", CIN=" + CIN + ", UserName=" + UserName + ", Adresse=" + Adresse + ", Password=" + Password + '}';
     }
     
     
     

     
   

     
    
    

}
