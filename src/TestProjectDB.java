import java.sql.*;
import java.util.Scanner;

class GetConnection {
    public static Connection getConnection(){
        
    
    Connection con = null;
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java7","root","root");
    } catch(Exception e){}
    return con;
    } 
    
}
class DBBL {
    
   public void addRecored(Scanner sc)
   {
       try {
       Connection con = GetConnection.getConnection();
           System.out.println("enter name");
           String nm = sc.next();
           System.out.println("enter course");
           String course = sc.next();
           
           String sql = "insert into student(name , course) values (?,?)";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, nm);
           ps.setString(2, course);
           
         //  int i = ps.executeUpdate();
           if(ps.executeUpdate()>0){
               System.out.println("record insert");
           } else {System.out.println("failed insert");}
           
       
       }catch (Exception e) {}
   }    
   
   public void deleteByName(Scanner sc)
   {
      
       int ch = sc.nextInt();
      try{
      
          Connection con = GetConnection.getConnection();
          String sql = "delete from student where name=?";
          
          System.out.println("enter name who you delete");
          String name = sc.next();
          
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, name);
          
          if(ps.executeUpdate()>0){
              System.out.println("data deleted");
          } else {System.out.println("somthing went wrong");}
          
      } catch (Exception e){}
   }
   public void displayData()
   {
   try {
   
       Connection con = GetConnection.getConnection();
       String sql = "select * from student";
       
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sql);
   }catch (Exception e){}
   }
   public void deleteByRoll(Scanner sc)
   {
       try {
       
           Connection con = GetConnection.getConnection();
           String sql = "delete from student where rno=?";
           
           System.out.println("Enter roll no");
           int rollNo = sc.nextInt();
           
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, rollNo);
           int i = ps.executeUpdate();
           while(i>=0){
               System.out.println("Recored deleted");
                break;
           }
           
       } catch (Exception e){}
   }
   public void UpdateRecored()
   {
   
   }
   public void displayAll()
   {
       try {
          Connection con = GetConnection.getConnection();
          String sql = "select * from student";
          
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while (rs.next()){
          
              System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
          }
          
          
       } catch (Exception e){}
   }

    
}

public class TestProjectDB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DBBL ob = new DBBL();
        
        int ch;
        do{
            System.out.println("Your choices are:");
            System.out.println("1 for Add new record:");
            System.out.println("2 for delete:");
            System.out.println("3 for Show all record:");
            System.out.println("5 for Exit:");
            System.out.print("Enter your choice:");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:ob.addRecored(sc);
                break;
                
                case 2:
                    System.out.println("-------------------------");
                    System.out.println("press 1 for delete by name");
                    System.out.println("press 2 for delete by roll no.");
                    int num = sc.nextInt();
       switch (num) {
           case 1: 
               ob.deleteByName(sc);
               break;
           case 2:
               ob.deleteByRoll(sc);
               break;
       }
       break;
                
                
                case 3:ob.displayAll();
                break;
        } 
    } while (ch != 5);
        
    }   
}
