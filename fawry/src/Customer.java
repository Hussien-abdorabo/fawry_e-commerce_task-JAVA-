public class Customer {
    public String name;
    public double balance;

    public Customer(String name, double balance) {
        this.setName(name);
        this.setBalance(balance);
    }
    public void charge(double amount)throws Exception{
        if  (!hasEnoughBalance(amount)){
            throw new Exception("Not Have Enough Money :(");
        }
        this .setBalance(this.getBalance()-amount);
    }
    public boolean hasEnoughBalance(double amount){
        return this.balance >= amount;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


