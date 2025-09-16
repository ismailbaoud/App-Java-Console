package controllers;

public class MainController {
    private int choice ;

    public MainController(int choice) {
        this.choice = choice;
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

    }

    public void manageAccountOptions() {

    }
}
