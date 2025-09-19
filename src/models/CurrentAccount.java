package models;

public class CurrentAccount extends Account{
    private double decouvert;

    public CurrentAccount(String code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return  "Code : " + this.getCode() +
                " ,solde " + this.getBalance() + "DH" +
                " ,decouvert=" + decouvert;
    }

    @Override
    public void withdraw(double sold) {
        if(sold <= (getBalance() + getDecouvert()) && getBalance() != 0  && getBalance() > 0) {
            double newSold = getBalance()-sold;
            setBalance(newSold);
            System.out.println(newSold);
        }else {
            System.out.println("your haven't the amount");
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    @Override
    public void displayDetails() {
        System.out.println(toString());
    }
}
