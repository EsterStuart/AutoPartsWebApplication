package Business;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer extends  Person{
    private int customerID;
    private String address;

    public Customer() {
        super();
        this.customerID = 0;
        this.address = "";
    }
    public Customer(String firstName, String lastName, String email, String password, String address) {
        super(firstName, lastName, email, password);
        this.customerID = 0;
        this.address = address;
    }

    //<editor-fold desc="Get/Set functions">
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //</editor-fold>

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

    public void display(){
        System.out.println("Customer ID : " + Integer.toString(getCustomerID()));
        System.out.println("First Name : " + getFirstName());
        System.out.println("Last Name : " + getLastName());
        System.out.println("Address : " + getAddress());
        System.out.println("Password : " + getPassword());
        System.out.println("Email : " + getEmail());
    }

    public static void main(String[] args){
        Customer c1 = new Customer();
        c1.selectDB(1);
        c1.display();

        Customer c2 = new Customer("Larry", "Smith", "larrySmith@email.com", "password123", "5290 Marget Dr, Powder Springs GA");
        c2.insertDB();
        c2.display();

        Customer c3 = new Customer();
        c3.selectDB(c2.getCustomerID());

        c3.setPassword("UPDATED_PASSWORD");
        c3.setFirstName("UPDATED_FNAME");
        c3.setLastName("UPDATED_LNAME");

        c3.setEmail("UPDATED_EMAIL");
        c3.setAddress("UPDATED_ADDRESS");
        c3.updateDB();


    }

}


