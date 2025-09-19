package controllers;

import enums.Destination;
import enums.Source;
import util.Helper;

import java.util.Scanner;

public class MainController {
    public String accountCode;
    private int choice ;
    static Scanner scanner = new Scanner(System.in);
    private AccountController accountController = new AccountController();
    private OperationController operationController = new OperationController();
    private Helper helper = new Helper();

    public MainController(int choice) {
        this.choice = choice;
        this.displayoptions();
    }

    public void displayoptions() {
        try {
            if (this.choice == 1) {
                this.createAccountOptions();
            } else if (this.choice == 2) {
                boolean exists = false;
                do {
                    System.out.print("please enter the account number : ");
                    accountCode = scanner.next();
                    exists =  helper.isExists(accountCode);

                }while(!exists);

                this.manageAccountOptions();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createAccountOptions() {
        try {
            int accountType;
            do {
                System.out.println("1 => Cretae current account");
                System.out.println("2 => Create saving account");
                System.out.println("3 => Back");
                accountType = scanner.nextInt();
                switch (accountType) {
                    case 1:
                        double Balance, overdraft;
                        do {
                            System.out.println("Please enter balance (from 0 to ****):");
                            Balance = scanner.nextDouble();
                        } while (Balance < 0);
                        do {
                            System.out.println("Please enter your overdraft (from 0 to ****)");
                            overdraft = scanner.nextDouble();
                        } while (overdraft < 0);
                        accountController.createCurrentAccount(Balance, overdraft);
                        break;
                    case 2:
                        double savingBalance;
                        do {
                            System.out.println("Please enter sold (from 0 to ****)");
                            savingBalance = scanner.nextDouble();
                        } while (savingBalance < 0);
                        accountController.createSavingAccount(savingBalance);
                        break;
                    default:
                        System.out.println("Invalid choice !! please enter valid choice");
                        break;
                }
            } while (accountType != 3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void manageAccountOptions() {
        try {
            int operation;
            do {


                System.out.println("1 => Make a deposit");
                System.out.println("2 => Make a withdrawal");
                System.out.println("3 => Make a transfer between accounts");
                System.out.println("4 => View account details");
                System.out.println("5 => View account balance");
                System.out.println("6 => View the list of transactions on an account");
                System.out.println("7 => Home");
                System.out.println("Enter your choice:");

                operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        Source source  = null;
                        System.out.print("Please enter the amount : ");
                        double amountVersing = scanner.nextDouble();
                        System.out.println("Please enter the source : ");
                        System.out.println("1 => External transfer");
                        System.out.println("2 => Cash deposit");
                        System.out.println("3 => Salary");
                        System.out.println("Enter your choice : ");
                        int sourceChoice = scanner.nextInt();

                        if (sourceChoice == 1) {
                            source = Source.EXTERNAL_TRANSFER;
                        } else if (sourceChoice == 2) {
                            source = Source.CASH_DEPOSIT;
                        } else if (sourceChoice == 3) {
                            source = Source.SALARY;
                        } else {
                            System.out.println("Invalid choice!");
                            return;
                        }

                        accountController.payment(accountCode,amountVersing);
                        operationController.depositOperation(source, amountVersing,accountCode);
                        break;
                    case 2:
                        System.out.print("please enter your amount :");
                        double amountWithrawing = scanner.nextDouble();
                        helper.getAccountObject(accountCode).withdraw(amountWithrawing);
                        System.out.println("please enter destination : ");
                        System.out.println("1 => DISTRIBUTEUR_ATM,");
                        System.out.println("2 => CHEQUE");
                        System.out.println("3 => VIREMENT");
                        System.out.println("enter your choice : ");
                        int destinationChoice = scanner.nextInt();

                        Destination destination = null;

                        if (destinationChoice == 1) {
                            destination = Destination.ATM;
                        } else if (destinationChoice == 2) {
                            destination = Destination.CHEQUE;
                        } else if (destinationChoice == 3) {
                            destination = Destination.TRANSFER;
                        } else {
                            System.out.println("Invalid choice!");
                            return;
                        }

                        operationController.withdrawOperation(destination, amountWithrawing,accountCode);
                        break;
                    case 3:
                        boolean exists ;
                        do {
                            System.out.println("Please enter receiver account code : ");
                            String receiver = scanner.next();
                            exists = helper.isExists(receiver);
                            System.out.println("Please enter the amount : ");
                            double amount = scanner.nextDouble();
                            accountController.accountToAccount(receiver, accountCode ,amount);
                            operationController.depositOperation(Source.EXTERNAL_TRANSFER, amount, accountCode);
                        }while (!exists);


                        break;
                    case 4:
                        helper.getAccountObject(accountCode).displayDetails();

                        break;
                    case 5:
                        accountController.displaySold(accountCode);

                        break;
                    case 6:
                        operationController.displayAccountOperations(accountCode);
                        break;
                    case 7:
                        System.out.println("good bye !!");
                        break;
                    default:
                        System.out.println("invalide choice please try valide choice ");
                        break;
                }

            } while (operation != 7);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}