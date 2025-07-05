public class ShippableNonExpirableProduct extends Product implements Shippable{
    private double weight;

    public ShippableNonExpirableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
         this.setWeight(weight);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean isExpirable(){
        return false;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }
}
