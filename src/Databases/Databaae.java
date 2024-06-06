
package Databases;
import java.sql.*;

public class Databaae {
   public static void main(String args[]){
       System.out.println("Start.....");   
       
       try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7", "root", "root");
       String sql = "insert into student(name,course) values ('Mihir' , 'ME')";
       Statement st = con.createStatement();
       int result=st.executeUpdate(sql) ;
       
       System.out.println("Sucessfull.....");
       } catch (Exception e){}
       
  }     
}
