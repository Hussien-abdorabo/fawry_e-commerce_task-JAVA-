import java.util.Date;

public class ExpirableProduct extends Product implements Expirable{
    private Date expireDate;

    public ExpirableProduct(String name, double price, int quantity, Date expireDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
    }

    @Override
    public Date getExpireDate() {
        return expireDate;
    }

    @Override
    public boolean isExpirable()  {
        if (new Date().compareTo(getExpireDate())>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
