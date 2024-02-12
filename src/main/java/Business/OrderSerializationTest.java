package Business;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class OrderSerializationTest {
    ArrayList<String> partOrderArrayList = new ArrayList<>(Arrays.asList("test_1", "test_2", "test_3", "test_4"));


    public boolean selectDB(int orderID) {
        try {

            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Orders WHERE OrderID=?");
            statement.setInt(1, orderID);

            ResultSet resultSet;
            resultSet = statement.executeQuery();
            resultSet.next();

            connection.close();
            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }

    /***********************************************************************************
     *  insertDB() inserts the Customer information into the Database
     *  Since the customerID is auto-generated in the database no customerID is used
     ***********************************************************************************/
    public boolean insertDB() {
        try  {

            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders ([CustomerID], [TotalCost], [Address], [OrderDate], [Status], [OrderParts]) VALUES (?,?,?,?,?,?)");


            statement.setString(1, "TEST");
            statement.setDouble(2, 65.33);
            statement.setString(3, "Test Street");
            statement.setString(4, "1-1-2024");
            statement.setString(5, "Recieved");
            statement.setObject(6, partOrderArrayList);

            statement.executeUpdate();


            connection.close();

            return true;
        } catch (Exception ex) {System.out.println(ex); return false;}
    }


}
