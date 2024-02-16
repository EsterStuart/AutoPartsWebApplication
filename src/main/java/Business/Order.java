package Business;

import jakarta.servlet.http.Part;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.stream.StreamSupport;

public class Order {
    private int orderID;
    private int CustomerID;
    private double orderTotalCost;
    public Cart c;
    private String customerAddress;
    private String orderDate;
    private String orderStatus;
    private ArrayList<PartOrder>orderedPartsArrayList;

    public Order(){
        orderID =0;
        CustomerID = 0;
        orderTotalCost = 0;
        customerAddress = "";
        orderDate ="";
        orderStatus = "";
        orderedPartsArrayList = new ArrayList<PartOrder>();
    }
    public Order(int orderID, int CustomerID,double orderTotalCost, String customerAddress, String orderDate,String orderStatus,Boolean isOrderFulfilled, ArrayList<PartOrder> orderedPartsArrayList)
    {
        this.orderID = orderID;
        this.CustomerID = CustomerID;
        this.orderTotalCost = orderTotalCost;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderedPartsArrayList = orderedPartsArrayList;
    }


    private void addPartOrder(PartOrder partOrder) {
        orderedPartsArrayList.add(partOrder);
    }

    private double calculateTotalPrice(){
        double totalPrice = 0.0;

        for (PartOrder partOrder : orderedPartsArrayList){
            totalPrice += partOrder.getTotalOrderPrice();
        }
        return totalPrice;
    }

    private static ArrayList<PartOrder> deserializeOrderedParts(byte[] serialString){
        ArrayList<PartOrder> outputArrayList = new ArrayList<PartOrder>();

        try{
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serialString);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);


            outputArrayList = (ArrayList<PartOrder>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (Exception ex) {ex.printStackTrace();}
        return outputArrayList;
    }

    private static byte[] serializeOrderedParts(ArrayList<PartOrder> OrderedPartsArrayList){
        byte[] outputByteArray = new byte[0];
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(OrderedPartsArrayList);
            objectOutputStream.flush();

            outputByteArray = byteArrayOutputStream.toByteArray();

            objectOutputStream.close();

        } catch (Exception ex) {ex.printStackTrace();}
        return outputByteArray;
    }


    public static ArrayList<Order> getAllOrders(){

        ArrayList<Order> allOrdersArrayList =  new ArrayList<Order>();

        try{
            Connection connection = DatabaseConnection.getDatabaseConnection();
            String sql = "SELECT OrderID FROM Orders";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                Order order = new Order();
                int orderID = resultSet.getInt("OrderID");

                order.selectDB(orderID);
                System.out.println(order.getOrderID());
                allOrdersArrayList.add(order);
            }

        }catch (Exception ex) {ex.printStackTrace();}

        return allOrdersArrayList;
    }


    /**
     Retrieves order information from the database based on Order ID
     **/
    public void selectDB(int orderID){
        try {
            this.orderID = orderID;
            Connection connection = DatabaseConnection.getDatabaseConnection();

            String sql = "SELECT * FROM Orders WHERE OrderID =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,getOrderID());
            ResultSet rs;
            rs = ps.executeQuery();
            System.out.println("Searching for Order...");
            if (rs.next()){
                setOrderID(rs.getInt("OrderID"));
                setCustomerID(0);
                setCustomerID(rs.getInt("CustomerID"));
                setOrderTotalCost(rs.getDouble("TotalCost"));
                setCustomerAddress(rs.getString("Address"));
                setOrderDate(rs.getString("OrderDate"));
                setOrderStatus(rs.getString("Status"));

                setOrderedPartsArrayList(Order.deserializeOrderedParts(rs.getBytes("OrderedParts")));

                System.out.println("Order Found");


            }else{System.out.println("Order not found");}
            connection.close();
        }
        catch (Exception ex){System.out.println(ex);}
    }

    /***
     Retrieves order information from the database based on customerID
     **/
    public void selectDBB(int customerID){
        try {
            this.CustomerID = customerID;
            Connection connection = DatabaseConnection.getDatabaseConnection();

            String sql = "SELECT * FROM Orders WHERE OrderID =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,getCustomerID());
            ResultSet rs;
            rs = ps.executeQuery();
            System.out.println("Searching for Order...");
            if (rs.next()){
                setOrderID(rs.getInt("OrderID"));
                setOrderTotalCost(rs.getDouble("TotalCost"));
                setCustomerAddress(rs.getString("Address"));
                setOrderDate(rs.getString("OrderDate"));
                setOrderStatus(rs.getString("Status"));
                setOrderedPartsArrayList(Order.deserializeOrderedParts(rs.getBytes("OrderedParts")));

                System.out.println("Order Found");


            }else{System.out.println("Order not found");}
            connection.close();
        }
        catch (Exception ex){System.out.println(ex);}
    }
    /**
     Creates new Orders and inserts them into the database
     **/
    public void insertDB(){
        try {
            Connection connection = DatabaseConnection.getDatabaseConnection();

            System.out.println("Order Inserting...");

            String sql = "INSERT into Orders(CustomerID,TotalCost,Address,OrderDate,Status, OrderedParts) Values(?,?,?,?,?,?)";

            PreparedStatement s = connection.prepareStatement(sql);

            s.setString(1, String.valueOf(getCustomerID()));
            s.setDouble(2,getOrderTotalCost());
            s.setString(3,getCustomerAddress());
            s.setString(4,getOrderDate());
            s.setString(5,getOrderStatus());
            s.setBytes(6, Order.serializeOrderedParts(orderedPartsArrayList) );

            int h = s.executeUpdate();
            if(h==1){ System.out.println("Order Inserted");}
            else{System.out.println("Order could not be inserted");}
            connection.close();
        }

        catch (Exception ex){System.out.println(ex);}
    }
    /**
     Updates information on Orders, specifically the order status
     **/
    public void updateDB(){
        try{
            Connection connection = DatabaseConnection.getDatabaseConnection();

            String sql = "UPDATE Orders SET CustomerID=?,TotalCost=?,Address=?,OrderDate=?,Status=?, OrderedParts=? WHERE OrderID = ?";
            PreparedStatement s = connection.prepareStatement(sql);

            s.setString(1, String.valueOf(getCustomerID()));
            s.setDouble(2,getOrderTotalCost());
            s.setString(3,getCustomerAddress());
            s.setString(4,getOrderDate());
            s.setString(5,getOrderStatus());
            s.setBytes(6, Order.serializeOrderedParts(orderedPartsArrayList) );
            s.setInt(7,getOrderID());

            int h = s.executeUpdate();
            if(h==1){System.out.println("Order Updated");}
            else{System.out.println("Order unable to be updated");}
            connection.close();

        }
        catch(Exception ex){System.out.println(ex);}

    }
    /**
     Deletes any Order based on inputted Order ID
     **/
    public void deleteDB(){
        try{
            Connection connection = DatabaseConnection.getDatabaseConnection();
            System.out.println("Deleting Order...");
            String sql = "Delete from Orders WHERE OrderID=?";
            PreparedStatement s = connection.prepareStatement(sql);
            s.setInt(1,getOrderID());

            int j = s.executeUpdate();
            if(j==1){System.out.println("Order Deleted");}
            else{System.out.println("Order unable to be Deleted");}
            connection.close();

        }
        catch(Exception ex){System.out.println(ex);}
    }

    public static void main(String[] args) {



        /*

        Product p1 = new Product();
        p1.selectDB("AF101");
        Product p2 = new Product();
        p2.selectDB("AFC103");

        PartOrder po1 = new PartOrder();
        po1.setPart(p1);
        po1.setQuantity(3);
        po1.setTotalOrderPrice(po1.getTotalPrice());

        PartOrder po2 = new PartOrder();
        po2.setPart(p2);
        po2.setQuantity(5);
        po2.setTotalOrderPrice(po2.getTotalPrice());

        Order order = new Order();
        order.addPartOrder(po1);
        order.addPartOrder(po2);

        order.setCustomerID(2);
        order.setOrderTotalCost(order.calculateTotalPrice());
        order.setOrderDate("TEST-DATE");
        order.setCustomerAddress("Street");
        order.setOrderStatus("Placed");


        byte[] serialNumber = Order.serializeOrderedParts(order.orderedPartsArrayList);
        ArrayList<PartOrder> partOrderArrayList = new ArrayList<PartOrder>();
        partOrderArrayList = Order.deserializeOrderedParts(serialNumber);

         */


        //order.insertDB();

        Order newOrder = new Order();
        newOrder.selectDB(3);

        for (PartOrder partOrder : newOrder.getOrderedPartsArrayList()){
            System.out.println("Part Name : " + partOrder.getPart().getName() + " " + partOrder.getPart().getProductType());
            System.out.println("Amount Ordered : " + partOrder.getQuantity());
            System.out.println("Cost of parts ordered : " + partOrder.getTotalOrderPrice());
        }

    }


    public int getOrderID(){return orderID;}
    public void setOrderID(int orderID) {this.orderID = orderID;}

    public int getCustomerID(){return CustomerID;}
    public void setCustomerID(int customerID) {CustomerID = customerID;}

    public double getOrderTotalCost() {return orderTotalCost;}
    public void setOrderTotalCost(double orderTotalCost) {this.orderTotalCost = orderTotalCost;}

    public String getCustomerAddress() {return customerAddress;}

    public void setCustomerAddress(String customerAddress) {this.customerAddress = customerAddress;}

    public String getOrderDate(){return orderDate;}
    public void setOrderDate(String orderDate){this.orderDate =orderDate;}

    public String getOrderStatus(){return orderStatus;}
    public void setOrderStatus(String orderStatus) {this.orderStatus = orderStatus;}

    public ArrayList<PartOrder> getOrderedPartsArrayList() {
        return orderedPartsArrayList;
    }

    public void setOrderedPartsArrayList(ArrayList<PartOrder> orderedPartsArrayList) {
        this.orderedPartsArrayList = orderedPartsArrayList;
    }
}
