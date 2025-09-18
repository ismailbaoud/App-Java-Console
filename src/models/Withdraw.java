package models;

import enums.Destination;

import java.util.Date;
import java.util.UUID;

public class Withdraw extends Operation {
    private Destination distination;

    public Withdraw(UUID numero, Date date, double montant, Destination distination) {
        super(numero, date, montant);
        this.distination = distination;
    }

    public Destination getDistination() {
        return distination;
    }

    public void setDistination(Destination distination) {
        this.distination = distination;
    }
}
