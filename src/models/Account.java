package models;

import java.util.ArrayList;

public abstract class Account {
    public  String code;
    private double balance;
    public static ArrayList<Operation> operations = new ArrayList<>();

    public Account(String code, double balance) {
        this.code = code;
        this.balance = balance;
    }

    public abstract void withdraw(double balance);
    public abstract double calculateInterest();
    public abstract void displayDetails();


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
