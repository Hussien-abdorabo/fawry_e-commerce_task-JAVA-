abstract public class Product {
    private String name;
    private double price;
    private int quantity;
    Product(String name,double price,int quantity) {
    this.setName(name);
    this.setPrice(price);
    this.setQuantity(quantity);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void reduceQuantity (int amount )throws Exception{
        if (this.isAvailable(amount)){
            this.setQuantity(this.quantity-amount);
        }

    }
public boolean isAvailable(int amount)throws Exception{
        if(this.quantity <amount){
            throw new Exception("Not enough quantity for "+this.getName());
        }
        return true;
}

abstract public boolean isExpirable();
abstract public boolean isShippable();



}