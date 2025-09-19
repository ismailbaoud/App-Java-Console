package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SavingAccount extends Account{
    private double interestRate = 0.05;
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public SavingAccount(String code, double solde) {
        super(code, solde);
        startInterestScheduler();
    }

    private void startInterestScheduler() {
        Runnable task = () -> {
            double interet = calculateInterest();
            setBalance(getBalance() + interet);
            System.out.println("Interest added: " + interet + " DH" + ", new solde: " + getBalance() + " DH");
        };

        scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);
    }

    @Override
    public String toString() {
        return " Code= " + getCode() +
                " ,Balance = " + getBalance() + "DH" +
                " ,interestRate " + getInterestRate();
    }

    @Override
    public  void withdraw(double sold) {
        if(getBalance() <= 0 || sold > getBalance()) {
            System.out.println("your haven't the amount");
        }else {
            double newSold = getBalance()-sold;
            setBalance(newSold);
            System.out.println(newSold);
        }
    }

    @Override
    public double calculateInterest() {
        if (getBalance() > 0) {
            return getBalance() * interestRate;
        }
        return 0;
    }

    @Override
    public void displayDetails() {
        System.out.println(toString());
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
