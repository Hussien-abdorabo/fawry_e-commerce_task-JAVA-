import java.util.Date;

public class ShippableExpirableProduct extends ShippableNonExpirableProduct implements Expirable {
    private Date expireDate;

    public ShippableExpirableProduct(String name, double price, int quantity, double weight, Date expireDate) {
        super(name, price, quantity, weight);
        this.expireDate = expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public Date getExpireDate() {
        return expireDate;
    }

    @Override
    public boolean isExpirable() {

        if (new Date().compareTo(getExpireDate())>0){
            return true;
        }
        return false;
    }


}
