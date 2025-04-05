import java.sql.*;
public class JDBConnector {
    Connection c;
    Statement s;
    public  JDBConnector(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///BankingManagementSystem","root","admin123");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
    }
}
