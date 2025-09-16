package controllers;

import java.util.Scanner;

public class MainController {
    private int choice ;
    static Scanner scanner = new Scanner(System.in);
    AccountController accountController = new AccountController();

    public MainController(int choice) {
        this.choice = choice;
        this.displayoptions();
    }

    public void displayoptions() {
        try {
            if (this.choice == 1) {
                this.createAccountOptions();
            } else if (this.choice == 2) {
                this.manageAccountOptions();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createAccountOptions() {
        int accType;
        do {
            System.out.println("1 => cretae current account");
            System.out.println("2 => create saving account");
            System.out.println("3 => return");
            accType = scanner.nextInt();
            switch (accType) {
                case 1 :
                    double sold , overdraft;
                    do {
                        System.out.println("please entre sold (de 0 a ****)");
                        sold = scanner.nextDouble();
                    }while (sold < 0);
                    do {
                        System.out.println("please entre your overdraft (de 0 a ****)");
                        overdraft = scanner.nextDouble();
                    } while (overdraft <0);
                    accountController.createCourantAccount(sold,overdraft);
                    break;
                case 2 :
                    System.out.println("saving account");
                    break;
                default:
                    System.out.println("invalide choice !! please enter valide choice");
                    break;
            }
        }while (accType != 3);
    }

    public void manageAccountOptions() {
        int operation;
        do {


            System.out.println("1 => Effectuer un versement");
            System.out.println("2 => Effectuer un retrait");
            System.out.println("3 => Effectuer un virement entre comptes");
            System.out.println("4 => Consulter le solde du compte");
            System.out.println("5 => Consulter la liste des opérations effectuées sur un compte");
            System.out.println("6 => l'accueil");
            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("your choice is 1");
                    break;
                case 2:
                    System.out.println("your choice is 2");
                    break;
                case 3:
                    System.out.println("your choice is 3");
                    break;
                case 4:
                    System.out.println("your choice is 4");
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

        }while (operation != 6);
    }
}
