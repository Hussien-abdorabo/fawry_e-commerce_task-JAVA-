import java.util.ArrayList;

public class CheckOutService {
    private double subTotal;
    private ArrayList<CartItem> shippingItems ;
    private ShippingService shippingService;



    public CheckOutService() {
        this.setSubTotal(0);
        this.setShippingItems(new ArrayList<CartItem>());
        this.setShippingService(new ShippingService());
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public ShippingService getShippingService() {
        return shippingService;
    }
    public ArrayList<CartItem> getShippingItems() {
        return shippingItems;
    }

    public void setShippingItems(ArrayList<CartItem> shippingItems) {
        this.shippingItems = shippingItems;
    }
    public void addShippingItem(CartItem item) {
        this.shippingItems.add(item);
    }
    public void checkout(Customer customer, Cart cart)throws Exception {
        if (!cart.isEmpty()) {
            Product product;

            for (CartItem item : cart.getItems()) {
                product = item.getProduct();

                if (product.isExpirable()) {
                    throw new Exception("Product {" + product.getName() + "} is expired.");
                }

                if (product.isAvailable(item.getQuantity())) {
                    this.setSubTotal(this.subTotal + (product.getPrice() * item.getQuantity()));

                }

                if (product instanceof Shippable) {
                    this.addShippingItem(item);
                    System.out.println("reduce " + item.getQuantity() + " unit of " + product.getName() + "\t" + ((Shippable) product).getWeight() * item.getQuantity() + " g\n");


                }
            }

            double shippingFees = this.getShippingService().checkout(this.getShippingItems());

            this.checkoutReceipt(customer, cart, shippingFees);
            this.reduceQuantity(cart);
        }

    }

    private void reduceQuantity(Cart cart) throws  Exception {
        if (cart==null){
            throw new Exception("reduce quantity not accept  null cart :(");
        }

        Product product;

        for (CartItem item:cart.getItems()
             ) {
            product=item.getProduct();

            product.reduceQuantity(item.getQuantity());


        }
    }


    private void checkoutReceipt(Customer customer, Cart cart, double shippingFees) throws Exception{

        if (customer==null||cart==null){
            throw new Exception("checkout receipt not allow null value :(");
        }

        System.out.println("**************** Checkout Receipt ****************\n");
        System.out.printf("%-4s %-12s %-12s %s\n", "Qty", "Item", "Unit Price", "Total");
        System.out.println("------------------------------------------");



        for (CartItem item : cart.getItems()) {
            String name = item.getProduct().getName();
            int qty = item.getQuantity();
            double unitPrice = item.getProduct().getPrice();

            double itemTotal = item.getProduct().getPrice() * qty;

            System.out.printf("%2dx  %-12s %10.2f %10.2f\n", qty, name, unitPrice, itemTotal);


        }
        System.out.println("------------------------------------------");

        System.out.printf("%-30s %10.2f\n", "Subtotal",  this.getSubTotal());


        System.out.printf("%-30s %10.2f\n", "Shipping", shippingFees);

        System.out.println("------------------------------------------");

        double total = this.getSubTotal() + shippingFees;

        if (!customer.hasEnoughBalance(total)) {
            throw new RuntimeException("Customer does not have enough balance.");
        }

        customer.charge(total);
        System.out.printf("%-30s %10.2f\n", "Total", total);
        System.out.printf("%-30s %10.2f\n", "Customer balance after payment:", customer.getBalance());

        System.out.println("\n**************************************************");

    }


}
