import java.sql.*;

public class TestDisplay {
    public static void main(String[] args) {
        try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","root");
        String sql = "select * from student";
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        }
        
        con.close();
            
        }catch(Exception e){}
    }
    
}
