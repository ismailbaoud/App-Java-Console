package models;

public class CurrentAccount extends Account{
    public double decouvert;

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
        return "Code : " + this.getCode() + " ,solde " + this.getSolde() +
                " ,decouvert=" + decouvert;
    }

    @Override
    public void retirer(double sold) {
        if(sold <= (getSolde() + getDecouvert()) && getSolde() != 0 ) {
            double newSold = getSolde()-sold;
            setSolde(newSold);
            System.out.println(newSold);
        }else {
            System.out.println("your haven't the amount");
        }
    }

    @Override
    public void calculerInteret() {
        return;
    }

    @Override
    public void afficherDetails() {

    }
}
