package controllers;

import models.Account;
import models.CurrentAccount;
import models.SavingAccount;
import java.util.HashMap;

public class AccountController{
    private static int chiffre = 10000;
    public static HashMap<String,Account> compteCourantList = new HashMap<>();
    public static HashMap<String,Account> compteEpargneList = new HashMap<>();
    private CurrentAccount currentAccount ;
    private SavingAccount savingAccount ;

    public void createCourantAccount(double sold, double decouvert) {
        try {
            String code = generateCode();
            currentAccount = new CurrentAccount(code, sold, decouvert);
            compteCourantList.put(code, currentAccount);
            displaySold(code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createSavingAccount(double sold) {
        try {
            String code = generateCode();
            double tauxInteret = 5;
            if (sold < 100) {
                tauxInteret = 5;
            } else if (sold < 500) {
                tauxInteret = 10;
            } else if (sold < 1000) {
                tauxInteret = 15;
            }
            savingAccount = new SavingAccount(code, sold, tauxInteret);
            compteEpargneList.put(code, savingAccount);
            displaySold(savingAccount.code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String code, HashMap<String , ? extends Account> list) {
        try {
            list.remove(code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends Account> void update(String code, T object, HashMap<String , T> list) {
        try {
            list.replace(code, object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void displaySold(String code) {
        Account account = getAccountObject(code);
        if (account != null) {
            System.out.println("Account code: " + code + " , Sold: " + account.getSolde());
        } else {
            System.out.println("No account found with code: " + code);
        }
    }

    public void displayAll(HashMap<String, ? extends Account> list) {
        try {
            for (String item : list.keySet()) {
                System.out.println("Code :" + item + " ,Account : " + list.get(item));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generateCode() {
        try {
            return "CPT-" + chiffre++;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account getAccountObject(String code) {
        if (compteCourantList.containsKey(code)) {
            return compteCourantList.get(code);
        }
        if (compteEpargneList.containsKey(code)) {
            return compteEpargneList.get(code);
        }
        return null;
    }

    public void versement(String code,double amount){
        Account account = getAccountObject(code);
        double newBalance = account.getSolde() + amount;
        account.setSolde(newBalance);
        System.out.println(newBalance);
    }

    public boolean isExist(String code) {
        if(compteCourantList.containsKey(code)) {
            return true;
        }else if (compteEpargneList.containsKey(code)) {
            return true;
        }else return false;
    }

    public void accountToAccount(String receiverCode , String senderCode, double amount) {
        Account sender, receiver ;
        receiver = getAccountObject(receiverCode);
        sender = getAccountObject(senderCode);
        if (sender.getSolde() >= amount) {
            receiver.setSolde(receiver.getSolde() + amount);
            sender.setSolde(sender.getSolde() - amount);
        }
        System.out.println("new sender amount : " + sender.getSolde());
        System.out.println("new receiver amount : " + receiver.getSolde());
    }
 }
