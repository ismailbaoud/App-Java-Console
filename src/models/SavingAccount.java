package models;

public class SavingAccount extends Account{
    public double tauxInteret;

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
                " ,tauxInteret= " + tauxInteret +
                " ,solde = " + getSolde();
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
