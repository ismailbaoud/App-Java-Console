import controllers.MainController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice , operation , accType ;
        do {
            System.out.println("********* welcome ********");
            System.out.println("1 => create account");
            System.out.println("2 => manage account");
            System.out.println("3 => Exit");
            System.out.print("Please enter your choice : ");
            choice = scanner.nextInt();
            new MainController(choice);
        }while (choice != 3);
    }
}