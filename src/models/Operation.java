package models;

import java.util.Date;
import java.util.UUID;

public class Operation {
    private UUID numero;
    private Date date;

    public Operation(UUID numero, Date date, double montant) {
        this.numero = numero;
        this.date = date;
        this.montant = montant;
    }

    private double montant;

    public UUID getNumero() {
        return numero;
    }

    public void setNumero(UUID numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
