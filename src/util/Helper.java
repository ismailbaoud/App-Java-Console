package util;

import models.Account;

import static controllers.AccountController.*;

public class Helper {
    private static int chiffre = 10000;

    public String generateCode() {
        try {
            return "CPT-" + chiffre++;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account getAccountObject(String code) {
        if (currentAccountsList.containsKey(code)) {
            return currentAccountsList.get(code);
        }
        if (savingAccountsList.containsKey(code)) {
            return savingAccountsList.get(code);
        }
        return null;
    }

    public boolean isExists(String code) {
        if(currentAccountsList.containsKey(code)) {
            return true;
        }else if (savingAccountsList.containsKey(code)) {
            return true;
        }else return false;
    }


}
