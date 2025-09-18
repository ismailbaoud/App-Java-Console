package controllers;

import enums.Destination;
import enums.Source;
import models.Account;
import models.CurrentAccount;

import java.util.Scanner;

public class MainController {
    public String compteCode;
    private int choice ;
    static Scanner scanner = new Scanner(System.in);
    AccountController accountController = new AccountController();
    OperationController operationController = new OperationController();

    public MainController(int choice) {
        this.choice = choice;
        this.displayoptions();
    }

    public void displayoptions() {
        try {
            if (this.choice == 1) {
                this.createAccountOptions();
            } else if (this.choice == 2) {
                boolean exist = false;
                do {
                    System.out.print("please enter the account number : ");
                    compteCode = scanner.next();
                    exist =  accountController.isExist(compteCode);

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
                System.out.println("4 => Consulter les details du compte");
                System.out.println("5 => Consulter le solde de compte");
                System.out.println("6 => Consulter la liste des opérations effectuées sur un compte");
                System.out.println("7 => l'accueil");
                System.out.println("Enter your choice");
                operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        Source source  = null;
                        System.out.print("please enter the amount : ");
                        double amountVersing = scanner.nextDouble();
                        System.out.println("please enter the source : ");
                        System.out.println("1 => Virement externe");
                        System.out.println("2 => Dépôt espèces");
                        System.out.println("3 => Salaire");
                        System.out.println("enter your choice : ");
                        int sourceChoice = scanner.nextInt();

                        if (sourceChoice == 1) {
                            source = Source.VIREMENT_EXTERNE;
                        } else if (sourceChoice == 2) {
                            source = Source.DEPOT_ESPECES;
                        } else if (sourceChoice == 3) {
                            source = Source.SALAIRE;
                        } else {
                            System.out.println("Invalid choice!");
                            return;
                        }

                        accountController.versement(compteCode,amountVersing);
                        operationController.depositOperation(source, amountVersing,compteCode);
                        break;
                    case 2:
                        System.out.print("please enter your amount :");
                        double amountWithrawing = scanner.nextDouble();
                        accountController.getAccountObject(compteCode).retirer(amountWithrawing);
                        System.out.println("please enter destination : ");
                        System.out.println("1 => DISTRIBUTEUR_ATM,");
                        System.out.println("2 => CHEQUE");
                        System.out.println("3 => VIREMENT");
                        System.out.println("enter your choice : ");
                        int destinationChoice = scanner.nextInt();

                        Destination destination = null;

                        if (destinationChoice == 1) {
                            destination = Destination.DISTRIBUTEUR_ATM;
                        } else if (destinationChoice == 2) {
                            destination = Destination.CHEQUE;
                        } else if (destinationChoice == 3) {
                            destination = Destination.VIREMENT;
                        } else {
                            System.out.println("Invalid choice!");
                            return;
                        }

                        operationController.withdrawOperation(destination, amountWithrawing,compteCode);
                        break;
                    case 3:
                        boolean exist ;
                        do {
                            System.out.println("please enter receiver account code : ");
                            String receiver = scanner.next();
                            exist = accountController.isExist(receiver);
                            System.out.println("please enter the amount : ");
                            double amount = scanner.nextDouble();
                            accountController.accountToAccount(receiver, compteCode ,amount);
                            operationController.depositOperation(Source.VIREMENT_EXTERNE, amount,compteCode);
                        }while (!exist);


                        break;
                    case 4:
                        accountController.getAccountObject(compteCode).afficherDetails();

                        break;
                    case 5:
                        accountController.displaySold(compteCode);

                        break;
                    case 6:
                        operationController.displayAccountOPerations(compteCode);
                        break;
                    case 7:
                        System.out.println("good bye !!");
                    default:
                        System.out.println("invalide choice please try valide choice ");
                }

            } while (operation != 7);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
