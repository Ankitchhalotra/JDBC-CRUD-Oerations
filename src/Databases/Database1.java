
package Databases;
import java.sql.*;

public class Database1 {
    public static void main(String args[]){
        System.out.println("Started.....");
        
        try{
            
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7", "root", "root");
        String sql = "insert into employee values ('Mihir',101,'MBBS','Male','City')";
        Statement st = con.createStatement();
        int i = st.executeUpdate(sql);
        con.close();
        System.out.println("Completed......");
        
        } catch (Exception e) {
        
        }
        
        
        
        
        
//    try{
//    Class.forName("com.mysql.cj.jdbc.Driver");
//    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7", "root", "root");
//    String sql = "insert into student (name,course) values ('Avi','IT')"; 
//    Statement st = con.createStatement();
//    int i = st.executeUpdate(sql);
//    con.close();
//    System.out.print("Operatioin run sucessfull....");
//    } catch (Exception e){
//    
//    }  
 }  
}
