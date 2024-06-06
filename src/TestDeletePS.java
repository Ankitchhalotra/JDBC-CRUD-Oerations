
import java.sql.*;
import java.util.Scanner;
public class TestDeletePS {
    public static void main(String[] args) {
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","root");
            //String sql="delete from student where rno=?";
            //String sql="update student set name=? where rno=?";
            String sql="select * from student where name=? and course=?";
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter name:");
            String nm=sc.next();
            System.out.print("Enter course:");
            String c=sc.next();
            PreparedStatement ps=con.prepareStatement(sql);
          
            ps.setString(1,nm);
              ps.setString(2,c);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                System.out.println("Recored hai....");
            }
            else
                System.out.println("Recored nahi hai....");
            con.close();
        }
        catch(Exception e){}
        
    }
    
}
