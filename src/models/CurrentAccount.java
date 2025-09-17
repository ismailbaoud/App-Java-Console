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
        return "Code : " + this.getCode() + " solde" + this.getSolde() +
                "decouvert=" + decouvert;
    }
}
