/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydictionary.Services;
import mydictionary.Entities.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mydictionary.tools.MyConnection;


/**
 *
 * @author ZOLDYCK
 */
public class UserServices {
      Connection cnx;

     /**
      *
      */
     public UserServices() {
          cnx = MyConnection.getInstance().getCnx();
     }

     public void ajouter(User t) {
          try {
               String req = "insert into user(CIN,USERNAME,ADRESSE,PASSWORD) values(?,?,?,?);";
               PreparedStatement ps = cnx.prepareStatement(req);
               ps.setInt(1, t.getCIN());
               ps.setString(2, t.getUserName());
               ps.setString(3, t.getAdresse());
               ps.setString(4, t.getPassword());
              
               ps.executeUpdate();
               System.out.println("Utilisateur ajoutée");}
          catch (SQLException ex) {
               System.out.println(ex.getMessage());
          }
     }
     public boolean verifUser (User t) {
//          boolean res=true ;
//          try {
//          String req = "select count(*) from User where USERNAME=? ;  ";
//          PreparedStatement ps=cnx.prepareStatement(req);
//          ps.setString(1,t.getUserName());
//        
//          ResultSet rs = ps.executeQuery();
//          int count = rs.getInt(1);
//          if (count == 1){
//               String req1 = "select PASSWORD from User where USERNAME =?;";
//               PreparedStatement ps1=cnx.prepareStatement(req1);
//               ps.setString(1, t.getUserName());
//               ResultSet rs1 =ps1.executeQuery();
//               String count1 = rs1.getString(1);
//               if (t.getPassword().equals(count1)){
//                    return res;
//               }
//               else res=false ;
//             
//               
//          }
//          else res=false ;
//          
//          
//          }
//          catch (SQLException ex){
//               System.out.println("ALOOOOO");
//               System.out.println(ex.getMessage());
//          }
//          return res;
         /*boolean res = false;
         
         try {
         String req = "select * from User where USERNAME=?";
         PreparedStatement ste = cnx.prepareStatement(req);
         ste.setString(1, t.getUserName());
            
            ResultSet rs = ste.executeQuery();
            
            while(rs.next()){
                System.out.println(t.getUserName().equals(rs.getString("username")));
                System.out.println(t.getUserName()+"/"+rs.getString("username"));
                if (t.getPassword().equals(rs.getString("Password"))  || t.getUserName().equals(rs.getString("username"))) {
                    res = true;
                     System.out.println("LOGGED in ");
//                    u = this.findById(rs.getInt("Id"));
//                    Session.setUser(u);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Email or Password incorrect");
                    alert.showAndWait();
                    res= false;
                }
            }
         } 
         catch (SQLException ex) {
              System.out.println(ex.getMessage());
         } 
          System.out.println(res);*/
          return true ;
     }
         
    public void LoginValidate(TextField t, PasswordField p) throws SQLException{
        
        Statement stmt;
        ResultSet rst;
        stmt = cnx.createStatement();
        rst = stmt.executeQuery("select *from users");
        ArrayList<User> listUsers = new ArrayList<User>();
        //Pegar os itens do resultset e inserir na lista
        while(rst.next()){
            User u = new User("","");
            u.setUserName(rst.getString("username"));
            u.setPassword(rst.getString("password"));
            listUsers.add(u);
        }
        rst.close();
        cnx.close();
        //login
        String login = t.getText();
       String password = p.getText();
        //validar login
        for (User u : listUsers){
            if(u.getUserName().equals(login) && u.getPassword().equals(password)){
                    LoginPagOnAction();
                    break;
            }else{
                System.out.println("Login Incorreto");
                LoginmenssagemLabel.setText("Login Incorreto");
            }
        
    }
          }
    
    
     
}
