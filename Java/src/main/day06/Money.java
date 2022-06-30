package day06;


import day06.exception.NegativeAmountException;

public class Money {
    private long amount;
    private Currency currency;

    public long getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money(long amount, Currency currency) {
        if (amount < 0) {
            throw new NegativeAmountException("음수 돈은 존재하지 않습니다.");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money amount) {
        if (this.currency != amount.getCurrency()) {
            throw new NegativeAmountException("통화가 맞지 않습니다.");
        }
        return new Money(amount.getAmount() + this.amount, amount.getCurrency());
    }

    public Money substract(Money amount) {
        if (this.currency != amount.getCurrency()) {
            throw new NegativeAmountException("통화가 맞지 않습니다.");
        }
        if (this.amount < amount.getAmount()) {
            throw new NegativeAmountException("음수 돈은 존재할 수 없습니다.");
        }
        return new Money(amount.getAmount() - this.amount, amount.getCurrency());
    }

    public enum Currency {
        WON, DOLLAR

    }

    public String toString() {
        return amount + " " + currency;
    }
}
