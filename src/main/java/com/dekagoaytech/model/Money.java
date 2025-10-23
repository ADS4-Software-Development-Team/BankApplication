package com.dekagoaytech.model;

public class Money implements Comparable<Money> {

    public static final Money ZERO = new Money(0); // represents 0 cents

    // 🔹 Stored in cents for accuracy (e.g., R22,34 → 2234)
    private long amount;

    // 🔹 Default constructor required by Firebase
    public Money() {
        this.amount = 0;
    }

    public Money(long amount) {
        this.amount = amount;
    }

    public Money(Double balance) {
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long newAmount) {
        this.amount = newAmount;
    }

    // 🔹 Business logic
    public Money add(Money other) {
        this.amount += other.amount;
        return this;
    }

    public Money subtract(Money other) {
        this.amount -= other.amount;
        return this;
    }

    @Override
    public int compareTo(Money other) {
        return Long.compare(this.amount, other.amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return this.amount == money.amount;
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + '}';
    }

    // 🔹 Optional: Display as main currency (e.g., rands)
    public String toDisplayInRands() {
        return String.format("R%.2f", amount / 100.0);
    }
}
