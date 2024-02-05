package Business;

import java.sql.*;

public class Order {
    private int orderID;
    private int CustomerID;
    private double orderTotalCost;
    public Cart c;
    private String customerAddress;
    private String orderDate;

    private String orderStatus;
    private Boolean isOrderFulfilled;

    public Order(){
        orderID =0;
        CustomerID = 0;
        orderTotalCost = 0;
        customerAddress = "";
        orderDate ="";
        orderStatus = "";
        isOrderFulfilled = null;
    }
    public Order(int orderID, int CustomerID,double orderTotalCost, String customerAddress, String orderDate,String orderStatus,Boolean isOrderFulfilled)
    {
        this.orderID = orderID;
        this.CustomerID = CustomerID;
        this.orderTotalCost = orderTotalCost;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.isOrderFulfilled = isOrderFulfilled;
    }
    /**
     Retrieves order information from the database based on Order ID
     **/
    public void selectDB(int orderID){
        try {
            this.orderID = orderID;
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://C://Users//alexgxz//Downloads//AutoPartsWebApplication-master//AutoPartsWebApplication-master//database//eCommerceDB.accdb");

            String sql = "SELECT * FROM Orders WHERE OrderID =?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,getOrderID());
            ResultSet rs;
            rs = ps.executeQuery();
            System.out.println("Searching for Order...");
            if (rs.next()){
                setCustomerID(rs.getInt(2));
                setOrderTotalCost(rs.getDouble(3));
                setCustomerAddress(rs.getString(4));
                setOrderDate(rs.getString(5));
                setOrderStatus(rs.getString(6));
                setOrderFulfilled(Boolean.valueOf(rs.getString(7)));
                System.out.println("Order Found");


            }else{System.out.println("Order not found");}
            c.close();
        }
        catch (Exception ex){System.out.println(ex);}
    }

    /***
     Retrieves order information from the database based on customerID
     */
    public void selectDBB(int customerID){
        try {
            this.CustomerID = customerID;
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://C://Users//alexgxz//Downloads//AutoPartsWebApplication-master//AutoPartsWebApplication-master//database//eCommerceDB.accdb");

            String sql = "SELECT * FROM Orders WHERE OrderID =?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,getCustomerID());
            ResultSet rs;
            rs = ps.executeQuery();
            System.out.println("Searching for Order...");
            if (rs.next()){
                setOrderID(rs.getInt("OrderID"));
                setOrderTotalCost(rs.getDouble(3));
                setCustomerAddress(rs.getString(4));
                setOrderDate(rs.getString(5));
                setOrderStatus(rs.getString(6));
                setOrderFulfilled(Boolean.valueOf(rs.getString(7)));
                System.out.println("Order Found");


            }else{System.out.println("Order not found");}
            c.close();
        }
        catch (Exception ex){System.out.println(ex);}
    }
    /**
     Creates new Orders and inserts them into the database
     **/
    public void insertDB(){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://C://Users//alexgxz//Downloads//AutoPartsWebApplication-master//AutoPartsWebApplication-master//database//eCommerceDB.accdb");
            System.out.println("Order Inserting...");
            String sql = "INSERT into Orders(OrderID,CustomerID,TotalCost,Address,OrderDate,Status,OrderParts) Values(?,?,?,?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,getOrderID());
            s.setString(2, String.valueOf(getCustomerID()));
            s.setDouble(3,getOrderTotalCost());
            s.setString(4,getCustomerAddress());
            s.setString(5,getOrderDate());
            s.setString(6,getOrderStatus());
            s.setString(7,"Yes");
            int h = s.executeUpdate();
            if(h==1){ System.out.println("Order Inserted");}
            else{System.out.println("Order could not be inserted");}
            c.close();
        }

        catch (Exception ex){System.out.println(ex);}
    }
    /**
     Updates information on Orders, specifically the order status
     **/
    public void updateDB(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://C://Users//alexgxz//Downloads//AutoPartsWebApplication-master//AutoPartsWebApplication-master//database//eCommerceDB.accdb");

            String sql = "UPDATE Orders set CustomerID=?,TotalCost=?,Address=?,OrderDate=?,Status=?,OrderParts=? WHERE OrderID= ?";
            PreparedStatement s = c.prepareStatement(sql);

            System.out.println("Updating Order");
            s.setString(1, String.valueOf(getCustomerID()));
            s.setDouble(2,getOrderTotalCost());
            s.setString(3,getCustomerAddress());
            s.setString(4,getOrderDate());
            s.setString(5,getOrderStatus());
            s.setString(6,"Yes");
            s.setInt(7,getOrderID());

            int h = s.executeUpdate();
            if(h==1){System.out.println("Order Updated");}
            else{System.out.println("Order unable to be updated");}
            c.close();

        }
        catch(Exception ex){System.out.println(ex);}

    }
    /**
     Deletes any Order based on inputted Order ID
     **/
    public void deleteDB(){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://C://Users//alexgxz//Downloads//AutoPartsWebApplication-master//AutoPartsWebApplication-master//database//eCommerceDB.accdb");
            System.out.println("Deleting Order...");
            String sql = "Delete from Orders WHERE OrderID=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,getOrderID());

            int j = s.executeUpdate();
            if(j==1){System.out.println("Order Deleted");}
            else{System.out.println("Order unable to be Deleted");}
            c.close();

        }
        catch(Exception ex){System.out.println(ex);}
    }
    public static void main(String[] args) {

        Order o2 = new Order(14,4,56.54,"Georgia","2/1/2024","Shipped",true);
        o2.insertDB();
   /*   Order o3 = new Order();
    o3.selectDB(2);
    o3.setOrderStatus("Delivered");
    o3.updateDB();
    Order o4 = new Order();
    o4.selectDB(3);
    o4.deleteDB();*/
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

    public Boolean getOrderFulfilled() {return isOrderFulfilled;}
    public void setOrderFulfilled(Boolean orderFulfilled) {isOrderFulfilled = orderFulfilled;}
}
