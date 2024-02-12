package Business;

import java.io.Serializable;

public class PartOrder implements Serializable {
    private Product part;
    private int quantity;
    private double totalOrderPrice;

    public Product getPart() {
        return part;
    }

    public void setPart(Product part) {
        this.part = part;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    /***
     Calculates the total price of a product and its quantity
     ***/
    public double getTotalPrice() {
        return part.getPrice() * quantity;
    }

    public static void main(String[] args){
        Product p = new Product();
        p.selectDB("AF101");
        p.display();
        PartOrder po = new PartOrder();
        po.setPart(p);
        po.setQuantity(4);

        System.out.println("Total Price is "+po.getTotalPrice());

    }
}
