package models;

import java.util.Date;
import java.util.UUID;

public abstract class Operation {
    private UUID numero;
    private Date date;
    public String accountCode;
    private double amount;

    public Operation(UUID numero, Date date, double amount , String accountCode) {
        this.numero = numero;
        this.date = date;
        this.amount = amount;
        this.accountCode = accountCode;
    }


    public UUID getNumero() {
        return numero;
    }

    public void setNumero(UUID numero) {
        this.numero = numero;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return amount;
    }

    public void setMontant(double montant) {
        this.amount = montant;
    }
}
