import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create product objects
        Product cheese = new ShippableExpirableProduct("Cheese", 120, 9, 200.5, new Date(2025, 1, 1));
        Product biscuits = new ShippableExpirableProduct("Biscuits", 150, 5, 30.5, new Date(2025, 12, 1));
        Product tv = new ShippableNonExpirableProduct("TV", 2500, 10, 5000.6);
        Product scratchCard = new NonExpirableProduct("ScratchCard", 20, 30);

        // Create a customer
        Customer customer = new Customer("Ahmed", 1_000_000);

        // Add items to cart
        Cart cart = new Cart();

        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(tv, 2);
            cart.add(scratchCard,12);

            // Checkout
            CheckOutService checkoutService = new CheckOutService();
            checkoutService.checkout(customer, cart);

        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(cheese.getQuantity());
        System.out.println(biscuits.getQuantity());
        System.out.println(tv.getQuantity());
        System.out.println(scratchCard.getQuantity());
    }
}