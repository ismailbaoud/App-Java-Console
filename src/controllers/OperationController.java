package controllers;

import enums.Destination;
import enums.Source;
import models.Deposit;
import models.Operation;
import models.Withdraw;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class OperationController {
    public static ArrayList<Operation> operationList = new ArrayList<>();
    public Deposit deposit;
    public Withdraw withdraw;

    public void depositOperation(Source source, double amount) {
        deposit = new Deposit(
                UUID.randomUUID(),
                new Date(),
                amount,
                source
        );
        operationList.add(deposit);
        System.out.println(deposit.toString());
    }

    public void withdrawOperation(Destination destination, double amount) {
        withdraw = new Withdraw(
                UUID.randomUUID(),
                new Date(),
                amount,
                destination
        );
        operationList.add(withdraw);
        System.out.println(deposit.toString());
    }
}
