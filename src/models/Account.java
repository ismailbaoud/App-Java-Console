package models;

import java.util.ArrayList;

public abstract class Account {
    private String code;
    private double solde;
    public static ArrayList<Operation> operations;

    public Account(String code, double solde) {
        this.code = code;
        this.solde = solde;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

}
