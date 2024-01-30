package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Part {
    private String productID;
    private String productType;
    private String brand;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private boolean fitsSUV;
    private boolean fitsSedan;
    private boolean fitsTruck;
    private boolean fitsCoupe;
    private boolean fitsSport;

    //<editor-fold desc="Get/Set Functions">
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public boolean getFitsSUV() {
        return fitsSUV;
    }

    public void setFitsSUV(boolean fitsSUV) {
        this.fitsSUV = fitsSUV;
    }

    public boolean getFitsSedan() {
        return fitsSedan;
    }

    public void setFitsSedan(boolean fitsSedan) {
        this.fitsSedan = fitsSedan;
    }

    public boolean getFitsTruck() {
        return fitsTruck;
    }

    public void setFitsTruck(boolean fitsTruck) {
        this.fitsTruck = fitsTruck;
    }

    public boolean getFitsCoupe() {
        return fitsCoupe;
    }

    public void setFitsCoupe(boolean fitsCoupe) {
        this.fitsCoupe = fitsCoupe;
    }

    public boolean getFitsSport() {
        return fitsSport;
    }

    public void setFitsSport(boolean fitsSport) {
        this.fitsSport = fitsSport;
    }

    //</editor-fold>

//<editor-fold desc="Database Functions">

    /***********************************************************************************
     *  selectDB() assigns the associated Customer information from the database to the object
     ***********************************************************************************/
    public boolean selectDB(String productID) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://Database/eCommerceDB.accdb");

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Products WHERE ProductID=?");
            statement.setString(1, productID);

            ResultSet resultSet;
            resultSet = statement.executeQuery();
            resultSet.next();

            setProductID(resultSet.getString("ProductID"));
            setProductType(resultSet.getString("ProductType"));
            setBrand(resultSet.getString("Brand"));
            setName(resultSet.getString("ProductName"));
            setDescription(resultSet.getString("Description"));
            setPrice(resultSet.getDouble("Price"));
            setStockQuantity(resultSet.getInt("Stock"));
            setFitsSUV(resultSet.getBoolean("FitsSUV"));
            setFitsSedan(resultSet.getBoolean("FitsSedan"));
            setFitsTruck(resultSet.getBoolean("FitsTruck"));
            setFitsCoupe(resultSet.getBoolean("FitsCoupe"));
            setFitsSport(resultSet.getBoolean("FitsSport"));


            connection.close();
            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }

    /***********************************************************************************
     *  insertDB() inserts the Customer information into the Database
     ***********************************************************************************/
    public boolean insertDB() {
        try  {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://Database/eCommerceDB.accdb");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO Products ([ProductID], [ProductType], [Brand], [ProductName], [Description], [Price], [Stock], [FitsSUV], [FitsSedan], [FitsTruck], [FitsCoupe], [FitsSport]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, getProductID());
            statement.setString(2, getProductType());
            statement.setString(3, getBrand());
            statement.setString(4, getName());
            statement.setString(5,getDescription());
            statement.setDouble(6, getPrice());
            statement.setInt(7, getStockQuantity());
            statement.setBoolean(8, getFitsSUV());
            statement.setBoolean(9, getFitsSedan());
            statement.setBoolean(10, getFitsTruck());
            statement.setBoolean(11, getFitsCoupe());
            statement.setBoolean(12, getFitsSport());

            statement.executeUpdate();

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

            PreparedStatement statement = connection.prepareStatement("UPDATE Products SET [ProductType] = ?, [Brand] = ?, [ProductName] = ?, [Description] = ?, [Price] = ?, [Stock] = ?, [FitsSUV] = ?,[FitsSedan] = ?,[FitsTruck] = ?,[FitsCoupe] = ?,[FitsSport] = ? WHERE CustomerID = ?");

            statement.setString(1, getProductType());
            statement.setString(2, getBrand());
            statement.setString(3, getName());
            statement.setString(4,getDescription());
            statement.setDouble(5, getPrice());
            statement.setInt(6, getStockQuantity());
            statement.setBoolean(7, getFitsSUV());
            statement.setBoolean(8, getFitsSedan());
            statement.setBoolean(9, getFitsTruck());
            statement.setBoolean(10, getFitsCoupe());
            statement.setBoolean(11, getFitsSport());
            statement.setString(12, getProductID());

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

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Products WHERE ProductID = ?");
            statement.setString(1, getProductID());

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }


    //</editor-fold>

    public static void main(String[] args){



    }
}
