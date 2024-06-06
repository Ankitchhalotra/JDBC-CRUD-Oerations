import java.sql.*;

public class TestMetaData {
    public static void main(String[] args) {
        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","root");
            String sql = "select * from student";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(""+rsmd.getColumnName(1)+ "\t"+rsmd.getColumnLabel(2)+"\t"+ rsmd.getColumnName(3));
            
        } catch (Exception e){}
    }
    
}
