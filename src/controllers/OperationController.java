package controllers;

import enums.Destination;
import enums.Source;
import models.Account;
import models.Deposit;
import models.Operation;
import models.Withdraw;
import util.Helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

public class OperationController {
    public static ArrayList<Operation> operationList = new ArrayList<>();
    public Stream<Operation> operationStream = operationList.stream();
    public Deposit deposit;
    public Withdraw withdraw;

    public void depositOperation(Source source, double amount, String code) {
        deposit = new Deposit(
                UUID.randomUUID(),
                new Date(),
                amount,
                source,
                code
        );
        operationList.add(deposit);
        System.out.println(deposit.toString());
    }

    public void withdrawOperation(Destination destination, double amount, String code) {
        withdraw = new Withdraw(
                UUID.randomUUID(),
                new Date(),
                amount,
                destination,
                code
        );
        operationList.add(withdraw);
        System.out.println(withdraw.toString());
    }

    public void displayAccountOperations(String code) {
        operationStream.filter(n -> n.accountCode.equals(code))
                .sorted()
                .forEach(System.out::println);
    }


}
