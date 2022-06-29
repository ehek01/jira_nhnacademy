package day06;

import static day06.Money.Currency.*;

public class Main {
    public static void main(String[] args) {
        Bank nhBank = new Bank();
        Customer jonghyun = new Customer();

        // 계좌 생성시, 고객과, 초기자금, 이율 셋팅
        nhBank.openAccount(jonghyun, new Money(5000L, DOLLAR), 0.5f);
        nhBank.openAccount(jonghyun, new Money(15000L, WON), 0.2f);
        nhBank.openAccount(jonghyun, new Money(50000L, WON), 0.1f);
        nhBank.openAccount(jonghyun, new Money(-5000L, DOLLAR), 0.1f);
//        nhBank.openAccount(jonghyun, new Money(5000L, YEN), 0.1f);

        // 이자지급전 nh은행 고객들 잔액
        for (Account account : nhBank.accounts) {
            System.out.println(account.getBalance().getAmount() + " " + account.getBalance().getCurrency());
        }

        // 이자 지급
        nhBank.payInterestOnAllAccounts();

        // 이자지급후 nh은행 고객들 잔액
        System.out.println("------------------------------------------");
        for (Account account : nhBank.accounts) {
            System.out.println(account.getBalance().getAmount() + " " + account.getBalance().getCurrency());
        }
    }
}
