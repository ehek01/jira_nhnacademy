package day06;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts = new ArrayList<>();

    Account openAccount(Customer customer, Money initMoney, float rate) {
        Account newAccount = new Account(initMoney, rate, customer);
        accounts.add(newAccount);
        return newAccount;
    }

    public void payInterestOnAllAccounts() {
        for(Account account : accounts) {
            account.payInterest();
        }
    }
}
