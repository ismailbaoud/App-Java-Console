package models;

import enums.Source;

import java.util.Date;
import java.util.UUID;

public class Deposit extends Operation {
    private Source source;

    public Deposit(UUID numero, Date date, double montant, Source source , String code) {
        super(numero, date, montant , code);
        this.source = source;
    }

    public Source getSource() {
        return source;
    }

    @Override
    public String toString() {
        return  "UUID : " + getNumero() +
                " ,Account code" + getAccountCode() +
                " , source : " + source +
                " , Amount : " + getMontant() +
                " , Date : " + getDate();
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
