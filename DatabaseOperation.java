
package Todo_List;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseOperation {
    public ArrayList<String> strings = new ArrayList<String>(0);
    
    public int insert( String task){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(Credentials.SQL_URL + "?" +
                    "user=" + Credentials.SQL_USERNAME + "&password=" + Credentials.SQL_PASSWORD); 
            Statement stmt=con.createStatement();
            String query1 = "INSERT INTO task " + "VALUES ('" + task+"')";
            stmt.executeUpdate(query1);  
            }catch(Exception e){ 
                System.out.println(e);
        } 
        return 0;
    }
    public int printAll(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(Credentials.SQL_URL + "?" +
                    "user=" + Credentials.SQL_USERNAME + "&password=" + Credentials.SQL_PASSWORD);  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from task"); 
            
            while(rs.next()){
                strings.add(rs.getString(1));   
            }
            
            con.close();  
            }catch(Exception e){ 
                System.out.println(e);
        } 
        return 0;
    }
    public int deleteAll(){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(Credentials.SQL_URL + "?" +
                    "user=" + Credentials.SQL_USERNAME + "&password=" + Credentials.SQL_PASSWORD); 
            Statement stmt=con.createStatement();
            String query1 = "DELETE FROM task";
            stmt.executeUpdate(query1);  
            }catch(Exception e){ 
                System.out.println(e);
        } 
        return 0;
    }
    public int delete(String task){
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(Credentials.SQL_URL + "?" +
            "user=" + Credentials.SQL_USERNAME + "&password=" + Credentials.SQL_PASSWORD);  
            Statement stmt=con.createStatement();
            String query1 = "DELETE FROM task where task ='"+task+"'";
            stmt.executeUpdate(query1);  
            }catch(Exception e){ 
                System.out.println(e);
        } 
        return 0;
    }
   
}