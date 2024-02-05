package Business;

public class PartOrder {
    private Part part;
    private int quantity;
    private double totalPrice;
    public Part getPart(){return part;}

    public void setPart(Part part){this.part = part;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    /***
     Calculates the total price of a product and its quantity
     **/
    public double getTotalPrice() {
        totalPrice = part.getPrice() * quantity;
        return totalPrice;
    }

    public static void main(String[] args){
        Part p = new Part();
        p.selectDB("AF101");
        p.display();
        PartOrder po = new PartOrder();
        po.setPart(p);
        po.setQuantity(4);

        System.out.println("Total Price is "+po.getTotalPrice());

    }
}
