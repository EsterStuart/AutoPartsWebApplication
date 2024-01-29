package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Part {
    private String productID;
    private String productType;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    //<editor-fold desc="Database Functions">

    /***********************************************************************************
     *  selectDB() assigns the associated Customer information from the database to the object
     ***********************************************************************************/
    public boolean selectDB(int customerID) {
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://Database/eCommerceDB.accdb");

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customers WHERE CustomerID=?");
            statement.setInt(1, customerID);

            ResultSet resultSet;
            resultSet = statement.executeQuery();
            resultSet.next();

            setCustomerID(resultSet.getInt("CustomerID"));
            setFirstName(resultSet.getString("FirstName"));
            setLastName(resultSet.getString("LastName"));
            setAddress(resultSet.getString("Address"));
            setPassword(resultSet.getString("password"));
            setEmail(resultSet.getString("email"));

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
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://Database/eCommerceDB.accdb");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Customers ([FirstName], [LastName], [email], [Address], [Password]) VALUES (?,?,?,?,?)");
            statement.setString(1, getFirstName());
            statement.setString(2, getLastName());
            statement.setString(3, getEmail());
            statement.setString(4, getAddress());
            statement.setString(5, getPassword());

            statement.executeUpdate();

            //The auto-generated key is returned and set using the getGeneratedKeys() function
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            setCustomerID(resultSet.getInt(1));
            connection.close();

            return true;
        } catch (Exception ex) {System.out.println(ex); return false;}
    }


    /***********************************************************************************
     *  updateDB() updates the associated Customer information from the object to the database
     ***********************************************************************************/
    public boolean updateDB() {
        try  {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://Database/eCommerceDB.accdb");

            PreparedStatement statement = connection.prepareStatement("UPDATE Customers SET [FirstName] = ?, [LastName] = ?, [email] = ?, [Address] = ?, [Password] = ? WHERE CustomerID = ?");
            statement.setString(1, getFirstName());
            statement.setString(2, getLastName());
            statement.setString(3, getEmail());
            statement.setString(4, getAddress());
            statement.setString(5, getPassword());
            statement.setInt(6, getCustomerID());

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }

    /***********************************************************************************
     *  deleteDB() deletes the associated Customer from the database
     ***********************************************************************************/
    public boolean deleteDB() {
        try  {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://Database/eCommerceDB.accdb");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Customers WHERE CustomerID = ?");
            statement.setInt(1, getCustomerID());

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }

    //</editor-fold>
}
