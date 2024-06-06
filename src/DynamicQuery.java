
import java.sql.Connection;
import java.sql.DriverManager
import java.util.Scanner;
public class DynamicQuery {
    public static void main(String[] args) {
      
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7", "root" , "root");
            String sql = "select * from student where rno=2";
            
//            Scanner sc = new Scanner(System.in);
//            System.out.println("enter name ....");
//            String nm = sc.next();
//            System.out.println("enter roll no...");
//            int rno = sc.nextInt();
                    
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, nm);
//            ps.setInt(2, rno);
            
           ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+""+ rs.getString(2)+rs.getString(3));
            }            con.close();
            
        } catch (Exception e) {}
    }
      
}
