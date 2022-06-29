package day06;

public class Account {
    public Money getBalance() {
        return balance;
    }

    private Money balance; // 잔액
    private float interestRate; // 이율
    private Customer customer;

    public Account(Money balance, float interestRate, Customer customer) {
        this.balance = balance;
        this.interestRate = interestRate;
        this.customer = customer;
    }

    // 입금
    public Money deposit(Money amount) {
        // 제약 조건
        this.balance = this.balance.add(amount);
        return this.balance;
    }

    // 출금
    public Money withdrawal(Money amount) {
        // 제약 조건
        this.balance = this.balance.substract(amount);
        return this.balance;
    }

    // 이자 지급
    Money payInterest() {
        Money interest = calculateInterest(); // 이자
        this.balance = this.balance.add(interest);
        return this.balance;
    }

    private Money calculateInterest() {
        long rate = (long) (balance.getAmount() * interestRate);
        return new Money(rate, balance.getCurrency());
    }
}
