package Business;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer extends  Person{
    private int customerID;

    public Address completeAddress;

    public Customer() {
        super();
        this.customerID = 0;
        this.completeAddress = new Address();
    }
    public Customer(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.customerID = 0;
    }

    public Customer(String firstName, String lastName, String email, String password, int customerID, Address completeAddress) {
        super(firstName, lastName, email, password);
        this.customerID = customerID;
        this.completeAddress = completeAddress;
    }

    //<editor-fold desc="Get/Set functions">
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Address getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(Address completeAddress) {
        this.completeAddress = completeAddress;
    }

    //</editor-fold>

    //<editor-fold desc="Database Functions">


    public boolean selectDB(String email) {
        try {

            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customers WHERE email=?");
            statement.setString(1, email);

            ResultSet resultSet;
            resultSet = statement.executeQuery();
            resultSet.next();

            setCustomerID(resultSet.getInt("CustomerID"));
            setFirstName(resultSet.getString("FirstName"));
            setLastName(resultSet.getString("LastName"));
            setPassword(resultSet.getString("password"));
            setEmail(resultSet.getString("email"));

            this.completeAddress.setStreet(resultSet.getString("Street"));
            this.completeAddress.setCity(resultSet.getString("City"));
            this.completeAddress.setState(resultSet.getString("State"));
            this.completeAddress.setZip(resultSet.getString("Zip"));

            connection.close();
            return true;

        } catch (Exception ex) {ex.printStackTrace(); return false;}
    }

    /***********************************************************************************
     *  selectDB() assigns the associated Customer information from the database to the object
     ***********************************************************************************/
    public boolean selectDB(int customerID) {
        try {

            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customers WHERE CustomerID=?");
            statement.setInt(1, customerID);

            ResultSet resultSet;
            resultSet = statement.executeQuery();
            resultSet.next();

            setCustomerID(resultSet.getInt("CustomerID"));
            setFirstName(resultSet.getString("FirstName"));
            setLastName(resultSet.getString("LastName"));
            setPassword(resultSet.getString("password"));
            setEmail(resultSet.getString("email"));

            this.completeAddress.setStreet(resultSet.getString("Street"));
            this.completeAddress.setCity(resultSet.getString("City"));
            this.completeAddress.setState(resultSet.getString("State"));
            this.completeAddress.setZip(resultSet.getString("Zip"));

            connection.close();
            return true;

        } catch (Exception ex) {ex.printStackTrace(); return false;}
    }

    /***********************************************************************************
     *  insertDB() inserts the Customer information into the Database
     *  Since the customerID is auto-generated in the database no customerID is used
     ***********************************************************************************/
    public boolean insertDB() {
        try  {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Customers ([FirstName], [LastName], [email], [Password], [Street], [City], [State], [Zip]) VALUES (?,?,?,?,?,?,?,?)");
            statement.setString(1, getFirstName());
            statement.setString(2, getLastName());
            statement.setString(3, getEmail());
            statement.setString(4, getPassword());
            statement.setString(5, completeAddress.getStreet());
            statement.setString(6,completeAddress.getCity());
            statement.setString(7, completeAddress.getState());
            statement.setString(8, completeAddress.getZip());

            statement.executeUpdate();

            //The auto-generated key is returned and set using the getGeneratedKeys() function
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            setCustomerID(resultSet.getInt(1));
            connection.close();

            return true;
        } catch (Exception ex) {ex.printStackTrace(); return false;}
    }


    /***********************************************************************************
     *  updateDB() updates the associated Customer information from the object to the database
     ***********************************************************************************/
    public boolean updateDB() {
        try  {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE Customers SET [FirstName] = ?, [LastName] = ?, [email] = ?, [Password] = ? , [Street] = ?, [City] = ?, [State] = ?, [Zip] = ? WHxERE CustomerID = ?");
            statement.setString(1, getFirstName());
            statement.setString(2, getLastName());
            statement.setString(3, getEmail());
            statement.setString(4, getPassword());
            statement.setString(5, completeAddress.getStreet());
            statement.setString(6,completeAddress.getCity());
            statement.setString(7, completeAddress.getState());
            statement.setString(8, completeAddress.getZip());
            statement.setInt(9, getCustomerID());

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (Exception ex) {ex.printStackTrace(); return false;}
    }

    /***********************************************************************************
     *  deleteDB() deletes the associated Customer from the database
     ***********************************************************************************/
    public boolean deleteDB() {
        try  {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Customers WHERE CustomerID = ?");
            statement.setInt(1, getCustomerID());

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (Exception ex) {ex.printStackTrace(); return false;}
    }

    //</editor-fold>

    public void display(){
        System.out.println("Customer ID : " + Integer.toString(getCustomerID()));
        System.out.println("First Name : " + getFirstName());
        System.out.println("Last Name : " + getLastName());
        System.out.println("Password : " + getPassword());
        System.out.println("Email : " + getEmail());
        System.out.println("Street : " + completeAddress.getStreet());
        System.out.println("City : " + completeAddress.getCity());
        System.out.println("State : " + completeAddress.getState());
        System.out.println("Zip : " + completeAddress.getZip());
    }

    public static void main(String[] args){




    }

}


