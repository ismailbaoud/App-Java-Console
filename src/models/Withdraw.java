package models;

import enums.Destination;

import java.util.Date;
import java.util.UUID;

public class Withdraw extends Operation {
    private Destination distination;

    public Withdraw(UUID numero, Date date, double montant, Destination distination , String code) {
        super(numero, date, montant, code);
        this.distination = distination;
    }

    public Destination getDistination() {
        return distination;
    }

    public void setDistination(Destination distination) {
        this.distination = distination;
    }

    @Override
    public String toString() {
        return  "UUID : " + getNumero() +
                " ,Account code" + getAccountCode() +

                " , Amount : " + getMontant() +
                " , distinction=" + distination +
                " , Date : " + getDate();
    }
}
