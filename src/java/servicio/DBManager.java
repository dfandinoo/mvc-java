package servicio;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    
    private final String db = "OlimpicosWeb";
    private final String url = "jdbc:postgresql://localhost:5432/" + db;
    private final String driver = "org.postgresql.Driver";
    private final String usuario = "postgres";
    private final String password = "POSTGRES";
    
    protected void addObject(ArrayList v, ResultSet rs){
        
    }
    
    protected ArrayList executeQuery(String sz){
        ArrayList v = new ArrayList();
        try {
            Class.forName(driver);
            System.out.println("\nEstableciendo conexion...");
            Connection con = DriverManager.getConnection(url,usuario,password);
            if(con == null) {
                System.out.println("database connection not working");
                return v;
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sz);
            while(rs.next()) {
                addObject(v, rs);
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("**********************ERROR*******************");
            System.out.println("Sql: " + sz);
            System.out.println("Exception " + e);
            
        } catch(SQLException e) {
            System.out.println("**********************ERROR*******************");
            System.out.println("SQL: " + sz);
            System.out.println("Exception " + e);
        }
        return v;
    }
    
    protected void execute(String sz) {
       try {
            Class.forName(driver);
            System.out.println("\nEstableciendo conexion...");
            Connection con = DriverManager.getConnection(url,usuario,password);
            if(con == null) {
                System.out.println("database connection not working");
                return;
            }
            Statement stm = con.createStatement();
            stm.execute(sz);
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("**********************ERROR*******************");
            System.out.println("Sql: " + sz);
            System.out.println("Exception " + e);
            
        } catch(SQLException e) {
            System.out.println("**********************ERROR*******************");
            System.out.println("SQL: " + sz);
            System.out.println("Exception " + e);
        } 
    }
}
