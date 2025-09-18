package models;

public class SavingAccount extends Account{
    private double tauxInteret;

    public SavingAccount(String code, double solde, double tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    @Override
    public String toString() {
        return " Code= " + getCode() +
                " ,solde = " + getSolde() +
                " ,tauxInteret " + getTauxInteret();
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public  void retirer(double sold) {
        if(getSolde() <= 0 || sold > getSolde()) {
            System.out.println("your haven't the amount");
        }else {
            double newSold = getSolde()-sold;
            setSolde(newSold);
            System.out.println(newSold);
        }
    }

    @Override
    public void calculerInteret() {
        setSolde(getSolde() * (this.tauxInteret / 100));
        System.out.println(getCode());
    }

    @Override
    public void afficherDetails() {
        System.out.println(toString());
    }
}
