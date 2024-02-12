package Business;

import java.util.ArrayList;

public class Cart {
    private ArrayList<PartOrder> PartOrdersInCartArrayList;

    public Cart(){
        PartOrdersInCartArrayList = new ArrayList<PartOrder>();
    }


    public ArrayList<PartOrder> getPartOrdersInCartArrayList() {
        return PartOrdersInCartArrayList;
    }

    public void setPartOrdersInCartArrayList(ArrayList<PartOrder> partOrdersInCartArrayList) {
        PartOrdersInCartArrayList = partOrdersInCartArrayList;
    }

    public void addPartOrderToCart(PartOrder partOrder){
        PartOrdersInCartArrayList.add(partOrder);
    }

    public void removePartOrderFromCart(int index){
        PartOrdersInCartArrayList.remove(index);
    }
}
