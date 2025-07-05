import java.util.ArrayList;

public class ShippingService {
    private ArrayList<CartItem> shippingItems ;
    private double totalWeightGrams;
    private double shippingFee;
    private static final double shippingCostPerKg=30;

    public ShippingService() {
        this.setShippingFee(0);
        this.setTotalWeightGrams(0);

    }

    public double getShippingCostPerKg() {
        return shippingCostPerKg;
    }



    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double checkout(ArrayList<CartItem> shippingItems)throws Exception{
        this.setShippingItems(shippingItems);
       this.setTotalWeightGrams(this.calculateTotalWeightGrams(shippingItems));

        shippingFee = (totalWeightGrams / 1000) * shippingCostPerKg;

        System.out.printf( "Total package weight: %.2f KG \n" ,totalWeightGrams / 1000 );
        return shippingFee;
    }

    private double calculateTotalWeightGrams(ArrayList<CartItem> shippingItems) throws Exception{
        if (shippingItems==null){
            throw new Exception("shipping Items is empty");
        }
        double totalWeight=0;
        Product product;
        for (CartItem item:shippingItems
             ) {

            product = item.getProduct();

            if (product instanceof Shippable) {
                totalWeight += ((Shippable) product).getWeight() * item.getQuantity();
            }

        }
return totalWeight;
    }

    public double getTotalWeightGrams() {
        return totalWeightGrams;
    }

    public void setTotalWeightGrams(double $totalWeightGrams) {
        this.totalWeightGrams = $totalWeightGrams;
    }

    public ArrayList<CartItem> getShippingItems() {
        return shippingItems;
    }

    public void setShippingItems(ArrayList<CartItem> shippingItems) {
        this.shippingItems = shippingItems;
    }
}
