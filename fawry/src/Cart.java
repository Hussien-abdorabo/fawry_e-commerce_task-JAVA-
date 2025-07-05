import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items ;

    public Cart() {
        this.setItems(new ArrayList<CartItem>());
    }

    public void add (Product product, int quantity)throws Exception
    {
        if (product==null){
            throw new Exception("Product is Null");
        }
        if (product.isAvailable(quantity)){
            this.items.add(new CartItem(product,quantity));
        }


    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    public ArrayList<CartItem> getItems() {
        return this.items;
    }



    public boolean isEmpty() throws Exception
    {
        if(this.items.isEmpty()){
            throw new Exception("Cart Is Empty :(");
        }
        return false;
    }


}
