package models;

public class SavingAccount extends Account{
    public double tauxInteret;

    public SavingAccount(String code, int solde, double tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }
}
