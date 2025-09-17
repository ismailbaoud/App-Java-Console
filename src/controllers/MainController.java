package controllers;

import models.Account;
import models.CurrentAccount;

import java.util.Scanner;

public class MainController {
    public String compteCode;
    private int choice ;
    static Scanner scanner = new Scanner(System.in);
    AccountController accountController = new AccountController();
    CurrentAccount currentAccount = new CurrentAccount("", 0 , 0) ;
    public MainController(int choice) {
        this.choice = choice;
        this.displayoptions();
    }

    public void displayoptions() {
        try {
            if (this.choice == 1) {
                this.createAccountOptions();
            } else if (this.choice == 2) {
                boolean exist ;
                do {
                    exist =  accountController.isExist(compteCode);
                    System.out.print("please enter the account number : ");
                    compteCode = scanner.next();

                }while(!exist);

                this.manageAccountOptions();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createAccountOptions() {
        try {
            int accType;
            do {
                System.out.println("1 => cretae current account");
                System.out.println("2 => create saving account");
                System.out.println("3 => return");
                accType = scanner.nextInt();
                switch (accType) {
                    case 1:
                        double sold, overdraft;
                        do {
                            System.out.println("please enter sold (from 0 a ****)");
                            sold = scanner.nextDouble();
                        } while (sold < 0);
                        do {
                            System.out.println("please enter your overdraft (from 0 a ****)");
                            overdraft = scanner.nextDouble();
                        } while (overdraft < 0);
                        accountController.createCourantAccount(sold, overdraft);
                        break;
                    case 2:
                        double savingSold;
                        do {
                            System.out.println("please entre sold (de 0 a ****)");
                            savingSold = scanner.nextDouble();
                        } while (savingSold < 0);
//                    do {
//                        System.out.println("please entre (de 0 a ****)");
//                        tauxInteret = scanner.nextDouble();
//                    } while (tauxInteret <0);
                        accountController.createSavingAccount(savingSold);
                        break;
                    default:
                        System.out.println("invalide choice !! please enter valide choice");
                        break;
                }
            } while (accType != 3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void manageAccountOptions() {
        try {
            int operation;
            do {


                System.out.println("1 => Effectuer un versement");
                System.out.println("2 => Effectuer un retrait");
                System.out.println("3 => Effectuer un virement entre comptes");
                System.out.println("4 => Consulter le solde du compte");
                System.out.println("5 => Consulter la liste des opérations effectuées sur un compte");
                System.out.println("6 => l'accueil");
                System.out.println("Enter your choice");
                operation = scanner.nextInt();
                switch (operation) {
                    case 1:
                        System.out.print("please enter the amount : ");
                        double amountVersing = scanner.nextDouble();
                        accountController.versement(compteCode,amountVersing);
                        break;
                    case 2:
                        System.out.print("please enter your amount :");
                        double amountWithrawing = scanner.nextDouble();
                        accountController.getAccountObject(compteCode).retirer(amountWithrawing);
                        break;
                    case 3:

                        break;
                    case 4:
                        accountController.display(compteCode, AccountController.compteCourantList);
                        break;
                    case 5:
                        System.out.println("your choice is 5");
                        break;
                    case 6:
                        System.out.println("your choice is 6");
                        break;
                    default:
                        System.out.println("invalide choice please try valide choice ");
                }

            } while (operation != 6);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
