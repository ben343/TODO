package todo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

     private static DBConnectionProvider instance=new DBConnectionProvider();

    private Connection connection;
    private  final String DB_URL="jdbc:mysql://localhost:3306/todo?useUnicode=true&characterEncoding=utf8";
    private  final String DB_USERNAME="root";
    private  final String DB_PASSWORD="Root";

     private  DBConnectionProvider (){
     }


public static DBConnectionProvider getInstance(){
         return instance;
}
public Connection getConnection(){
    try {
        if (connection==null || connection.isClosed()){
            connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        }
    } catch (SQLException e) {
   e.printStackTrace();
   System.exit(1);

    }
    return connection;
}

}
