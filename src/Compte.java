import java.util.ArrayList;

public abstract class Compte {
    private String code ;
    private double solde ;
    private ArrayList<Operation> listOperations;

    public abstract void retirer();

    public abstract void calculerInteret();

    public abstract void afficherDetails();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public ArrayList<Operation> getListOperations() {
        return listOperations;
    }

    public void setListOperations(ArrayList<Operation> listOperations) {
        this.listOperations = listOperations;
    }


}
