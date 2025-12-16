package com.baldhokade.reboot.day01;

import java.util.Objects;

public class Transaction {

    private final String id;
    private final String type;
    private final double amount;
    private final String currency;

    public Transaction(String id, String type, double amount, String currency) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Transaction)) return false;
        if(this == object) return true;
        Transaction that  = (Transaction) object;
        return Double.compare(amount, that.amount) == 0
                && Objects.equals(id, that.id)
                && Objects.equals(type, that.type)
                && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, currency);
    }
}