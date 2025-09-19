package controllers;

import models.Account;
import models.CurrentAccount;
import models.SavingAccount;
import util.Helper;
import java.util.HashMap;

public class AccountController{
    public static HashMap<String,Account> currentAccountsList = new HashMap<>();
    public static HashMap<String,Account> savingAccountsList = new HashMap<>();
    private CurrentAccount currentAccount ;
    private SavingAccount savingAccount ;
    private Helper helper = new Helper();

    public void createCurrentAccount(double balance, double overDraft) {
        try {
            String code = helper.generateCode() ;
            currentAccount = new CurrentAccount(code, balance, overDraft);
            currentAccountsList.put(code, currentAccount);
            displaySold(code);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createSavingAccount(double balance) {
        try {
            String code = helper.generateCode();
            savingAccount = new SavingAccount(code, balance);
            savingAccountsList.put(code, savingAccount);
            displaySold(savingAccount.code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void displaySold(String code) {
        Account account = helper.getAccountObject(code);
        if (account != null) {
            System.out.println("Account code: " + code + " , Balance: " + account.getBalance());
        } else {
            System.out.println("No account found with code: " + code);
        }
    }

    public void payment(String code,double amount){
        Account account = helper.getAccountObject(code);
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        System.out.println(newBalance);
    }

    public void accountToAccount(String receiverCode , String senderCode, double amount) {
        Account sender, receiver ;
        receiver = helper.getAccountObject(receiverCode);
        sender = helper.getAccountObject(senderCode);
        if (sender.getBalance() >= amount) {
            receiver.setBalance(receiver.getBalance() + amount);
            sender.setBalance(sender.getBalance() - amount);
        }
        System.out.println("new sender amount : " + sender.getBalance());
        System.out.println("new receiver amount : " + receiver.getBalance());
    }
 }
