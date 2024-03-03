package Business;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getDatabaseConnection(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            File databaseFile = new File("./database/eCommerceDB.accdb");

            String cononicalPath = databaseFile.getCanonicalPath();
            String databasePath = cononicalPath.replace("\\apache-tomcat-10.1.18\\bin\\", "\\");
            String adjustededDatabasePath = databasePath.replace("\\apache-tomcat-10.1.18\\bin\\", "\\");

            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + adjustededDatabasePath);
            return connection;
        } catch (Exception ex) {ex.printStackTrace();}
        return null;
    }

}


