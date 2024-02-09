package Business;

import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

public class Product implements Serializable {
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

    public enum CarType {
        SUV,
        Sedan,
        Truck,
        Coupe,
        Sport
    }

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
            Connection connection = DatabaseConnection.getDatabaseConnection();

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

            Connection connection = DatabaseConnection.getDatabaseConnection();

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
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE Products SET [ProductType] = ?, [Brand] = ?, [ProductName] = ?, [Description] = ?, [Price] = ?, [Stock] = ?, [FitsSUV] = ?,[FitsSedan] = ?,[FitsTruck] = ?,[FitsCoupe] = ?,[FitsSport] = ? WHERE ProductID = ?");

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
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM Products WHERE ProductID = ?");
            statement.setString(1, getProductID());

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }


    //</editor-fold>

    //<editor-fold desc="Get Product By Filter Methods">


    /************************************************************************************************************************
     *   The following method takes in only the productType and returns a ArrayList<Product> ArrayList filtered by product type
     ***********************************************************************************************************************/
    public static ArrayList<Product> getAllProductsFilterBy(String productType){
        ArrayList<Product> productsArrayList = new ArrayList<Product>();
        try {

            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT ProductID FROM Products WHERE ProductType = ?");
            statement.setString(1, productType);

            ResultSet resultSet;
            resultSet = statement.executeQuery();


            while (resultSet.next()){
                Product product = new Product();
                product.selectDB(resultSet.getString("ProductID"));
                productsArrayList.add(product);
            }

        } catch (Exception ex) {ex.printStackTrace();}


        return productsArrayList;
    }

    /************************************************************************************************************************
     *   The following method takes in only the CarType and returns a ArrayList<Product> ArrayList filtered by Car type
     ***********************************************************************************************************************/
    public static ArrayList<Product> getAllProductsFilterBy(CarType carType){
        ArrayList<Product> productsArrayList = new ArrayList<Product>();

        String carTypeColumnName = "";

        switch (carType){
            case SUV:
                carTypeColumnName = "FitsSUV";
                break;
            case Sedan:
                carTypeColumnName = "FitsSedan";
                break;
            case Truck:
                carTypeColumnName = "FitsTruck";
                break;
            case Coupe:
                carTypeColumnName = "FitsCoupe";
                break;
            case Sport:
                carTypeColumnName = "FitsSport";
                break;


        }

        try {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT ProductID FROM Products WHERE " + carTypeColumnName + " = 1");

            ResultSet resultSet;
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.selectDB(resultSet.getString("ProductID"));
                productsArrayList.add(product);
            }

        } catch (Exception ex) {System.out.println(ex);}


        return productsArrayList;
    }


    /************************************************************************************************************************
     *   The following method takes in the ProductType and CarType returns a ArrayList<Product> ArrayList filtered by product type and CarType
     ***********************************************************************************************************************/
    public static ArrayList<Product> getAllProductsFilterBy(String productType, CarType carType){
        ArrayList<Product> productsArrayList = new ArrayList<Product>();

        String carTypeColumnName = "";

        switch (carType){
            case SUV:
                carTypeColumnName = "FitsSUV";
                break;
            case Sedan:
                carTypeColumnName = "FitsSedan";
                break;
            case Truck:
                carTypeColumnName = "FitsTruck";
                break;
            case Coupe:
                carTypeColumnName = "FitsCoupe";
                break;
            case Sport:
                carTypeColumnName = "FitsSport";
                break;


        }

        try {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT ProductID FROM Products WHERE " + carTypeColumnName + " = 1 AND ProductType = ?");
            statement.setString(1, productType);

            ResultSet resultSet;
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.selectDB(resultSet.getString("ProductID"));
                productsArrayList.add(product);
            }

        } catch (Exception ex) {System.out.println(ex);}


        return productsArrayList;
    }

    //</editor-fold>

    //<editor-fold desc="Modify Product Stock methods">
    /************************************************************************************************************************
     *   The following method updates the Product Stock in the database to the newProductStock value
     ***********************************************************************************************************************/
    public static boolean updateProductStock(String productID, int newProductStock) {
        try  {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("UPDATE Products SET [Stock] = ? WHERE ProductID = ?");

            statement.setInt(1, newProductStock);
            statement.setString(2, productID);

            statement.executeUpdate();
            connection.close();
            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }

    /************************************************************************************************************************
     *   The following method decreases the Prodcut Stock in the database by the decreaseAmount
     ***********************************************************************************************************************/

    public static boolean decreaseProductStock(String productID, int decreaseAmount) {
        try  {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT Stock FROM Products WHERE ProductID = ?");
            statement.setString(1, productID);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            System.out.println(resultSet.getInt("Stock"));

            int currentStock = resultSet.getInt("Stock");
            int newStock = currentStock - decreaseAmount;
            connection.close();

            updateProductStock(productID, newStock);

            return true;

        } catch (Exception ex) {System.out.println(ex); return false;}
    }
    //</editor-fold>


    public static CarType getCarType(String carTypeName) {
        String lowerCaseCarTypeName = carTypeName.toLowerCase();

        CarType carType;

        switch (lowerCaseCarTypeName) {
            case "suv":
                carType = CarType.SUV;
                break;

            case "sedan":
                carType = CarType.Sedan;
                break;

            case "truck":
                carType = CarType.Truck;
                break;

            case "coupe":
                carType = CarType.Coupe;
                break;

            default:
                carType = CarType.Sport;
                break;
        }

        return  carType;
    }

    public void display(){
        System.out.println("ProductID : " + getProductID());
        System.out.println("Product Type : " + getProductType());
        System.out.println("Brand : " + getBrand());
        System.out.println("Name : " + getName());
        System.out.println("Description : " + getDescription());
        System.out.println("Price : " + getPrice());
        System.out.println("Stock : " + getStockQuantity());
        System.out.println("Fits SUV : " + getFitsSUV());
        System.out.println("Fits Sedan : " + getFitsSedan());
        System.out.println("Fits Truck : " + getFitsTruck());
        System.out.println("Fits Coupe : " + getFitsCoupe());
        System.out.println("Fits Sport : " + getFitsSport());
    }

    public static void main(String[] args){


        Product p1 = new Product();
        p1.selectDB("AF108");
        p1.display();

        p1.decreaseProductStock("AF108", 2);

        p1.selectDB("AF108");
        p1.display();



        ArrayList<Product> productsArraylist = p1.getAllProductsFilterBy("Spark Plug");
        //ArrayList<Product> productsArraylist = getAllProductsFilterBy(CarType.Truck);
        //ArrayList<Product> productsArraylist = getAllProductsFilterBy("Battery", CarType.Truck);
        for (Product product : productsArraylist){
            System.out.println(product.name);
        }


    }
}
