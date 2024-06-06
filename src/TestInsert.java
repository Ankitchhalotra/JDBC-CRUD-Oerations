import java.sql.*;
import java.util.Scanner;

public class TestInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","root");
         String sql = "insert into student(name,course)values(?,?)";
         
            System.out.println("enter name");
            String nm = sc.next();
            System.out.println("enter course");
            String c = sc.next();
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nm);
            ps.setString(2, c);
            
            int i = ps.executeUpdate();
            con.close();
         
        }catch(Exception e){}
    }
   
}


// for static query
//Statement st = con.createStatement();
//int i = st.executeUpdate(sql);