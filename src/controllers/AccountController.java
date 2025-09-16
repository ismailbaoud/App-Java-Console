package controllers;

import models.Account;
import models.CurrentAccount;
import models.SavingAccount;

import java.util.HashMap;

public class AccountController {
    private static int chiffre = 10000;
    private static String code;
    private static HashMap<String,Account> compteCourantList = new HashMap<>();
    private static HashMap<String,Account> compteEpargneList = new HashMap<>();
    private CurrentAccount currentAccount ;
    private SavingAccount savingAccount;

    public void createCourantAccount(double solde, double decouvert) {
        generateCode();
        currentAccount = new CurrentAccount(code, solde, decouvert);
        compteCourantList.put(code, currentAccount);
        displayLastOne();
    }

    public void displayLastOne() {
        System.out.println(compteCourantList.get(code).toString());
    }

    public void generateCode() {
        code = "CPT-"+(++chiffre);
    }


}
