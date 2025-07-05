public class NonExpirableProduct extends Product {
    NonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpirable() {

        return false;
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
